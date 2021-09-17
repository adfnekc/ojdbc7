//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oracle.jdbc.proxy.AnnotationsRegistry.Value;
import oracle.jdbc.proxy.ClassGenerator.AnnotationsForIface;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

class MethodGenerator {
    private static long ids = 0L;
    private final String methodObject;
    private final String proxyName;
    private final String ifaceName;
    private final String superclassName;
    private final String proxyType;
    private final String ifaceType;
    private final Method method;
    private final AnnotationsForIface annotationsForIface;
    private final boolean callDelegate;
    private final boolean returns;
    private final Class[] parameterTypes;
    private final Class[] exceptionTypes;
    private final Class returnType;
    private final String methodName;
    private final String signature;
    private final String[] throwables;
    private final List<Class> exceptionsToCatch;

    MethodGenerator(ClassGenerator var1, Method var2, boolean var3) {
        this.methodObject = "methodObject" + ids++;
        this.exceptionsToCatch = new ReadOnlyList<Class>() {
            public Class get(int var1) {
                return 0 == var1 ? RuntimeException.class : MethodGenerator.this.exceptionTypes[var1 - 1];
            }

            public int size() {
                return MethodGenerator.this.exceptionTypes.length + 1;
            }
        };
        this.proxyName = var1.getProxyName();
        this.ifaceName = var1.getIfaceName();
        this.superclassName = var1.getSuperclassName();
        this.ifaceType = var1.getIfaceType();
        this.proxyType = var1.getProxyType();
        this.method = var2;
        this.annotationsForIface = var1.getAnnotationsForIface();
        this.callDelegate = var3;
        this.parameterTypes = var2.getParameterTypes();
        this.exceptionTypes = var2.getExceptionTypes();
        this.returnType = var2.getReturnType();
        this.returns = !"void".equals(this.returnType.getName());
        this.methodName = var2.getName();
        this.signature = Utils.makeSignature(this.parameterTypes, this.returnType);
        this.throwables = Utils.makeThrowables(this.exceptionTypes);
    }

    String getMethodObject() {
        return this.methodObject;
    }

    private Method getMethodPre() {
        Value var1 = this.annotationsForIface.getValue();
        return null == var1 ? null : var1.getMethodPre(this.annotationsForIface.getIface(), new MethodSignature(this.method));
    }

    private boolean isResultProxied() {
        if (!this.hasAssignableProxyForReturnType(this.returnType, this.annotationsForIface.getRegistry().keySet())) {
            return false;
        } else {
            Value var1 = this.annotationsForIface.getValue();
            if (null == var1) {
                return false;
            } else {
                boolean var2 = var1.belongsToIfaceToProxy(this.annotationsForIface.getIface(), new MethodSignature(this.method));
                return var2 && ProxyResultPolicy.MANUAL != this.getProxyResultPolicy();
            }
        }
    }

    private final boolean hasAssignableProxyForReturnType(Class var1, Set<Class> var2) {
        Iterator var3 = var2.iterator();

        Class var4;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            var4 = (Class)var3.next();
        } while(!var1.isAssignableFrom(var4));

        return true;
    }

    private boolean isMethodPreDefined() {
        return null != this.getMethodPre();
    }

    private Method getMethodVoidPost() {
        Value var1 = this.annotationsForIface.getValue();
        return null == var1 ? null : var1.getMethodVoidPost(this.annotationsForIface.getIface(), new MethodSignature(this.method));
    }

    private boolean isMethodVoidPostDefined() {
        return null != this.getMethodVoidPost();
    }

    private Method getMethodReturningPost() {
        Value var1 = this.annotationsForIface.getValue();
        return null == var1 ? null : var1.getMethodReturningPost(this.annotationsForIface.getIface(), new MethodSignature(this.method));
    }

    private boolean isMethodReturningPostDefined() {
        return null != this.getMethodReturningPost();
    }

    private Method getMethodVoidOnError(Class var1) {
        Value var2 = this.annotationsForIface.getValue();
        if (null == var2) {
            return null;
        } else {
            Map var3 = var2.getMapVoidOnError(this.annotationsForIface.getIface(), new MethodSignature(this.method));
            return null == var3 ? null : (Method)var3.get(var1);
        }
    }

    private boolean isMethodVoidOnErrorDefined() {
        boolean var1 = false;
        Iterator var2 = this.exceptionsToCatch.iterator();

        while(var2.hasNext()) {
            Class var3 = (Class)var2.next();
            if (null != this.getMethodVoidOnError(var3)) {
                var1 = true;
            }
        }

        return var1;
    }

    private Method getMethodReturningOnError(Class var1) {
        Value var2 = this.annotationsForIface.getValue();
        if (null == var2) {
            return null;
        } else {
            Map var3 = var2.getMapReturningOnError(this.annotationsForIface.getIface(), new MethodSignature(this.method));
            return null == var3 ? null : (Method)var3.get(var1);
        }
    }

    private boolean isMethodReturningOnErrorDefined() {
        boolean var1 = false;
        Iterator var2 = this.exceptionsToCatch.iterator();

        while(var2.hasNext()) {
            Class var3 = (Class)var2.next();
            if (null != this.getMethodReturningOnError(var3)) {
                var1 = true;
            }
        }

        return var1;
    }

    private boolean isMethodOnErrorDefined() {
        return this.returns ? this.isMethodReturningOnErrorDefined() : this.isMethodVoidOnErrorDefined();
    }

    private boolean isMethodPostDefined() {
        return this.returns ? this.isMethodReturningPostDefined() : this.isMethodVoidPostDefined();
    }

    final Method getMethodPost() {
        return this.returns ? this.getMethodReturningPost() : this.getMethodVoidPost();
    }

    boolean isAnyInterceptorDefined() {
        return this.isMethodPreDefined() || this.isMethodVoidPostDefined() || this.isMethodReturningPostDefined() || this.isMethodVoidOnErrorDefined() || this.isMethodReturningOnErrorDefined();
    }

    ProxyResultPolicy getProxyResultPolicy() {
        Value var1 = this.annotationsForIface.getValue();
        return null == var1 ? ProxyResultPolicy.CACHE : var1.getProxyResultPolicy(this.method);
    }

    void generate(ClassWriter var1) {
        MethodVisitor var2 = var1.visitMethod(this.method.isVarArgs() ? 129 : 1, this.methodName, this.signature, (String)null, this.throwables);
        var2.visitCode();
        Label var3 = new Label();
        Label var4 = new Label();
        Label var5 = new Label();
        Label var6 = new Label();
        int var11 = 1;
        Class[] var12 = this.parameterTypes;
        int var13 = var12.length;

        int var14;
        Class var15;
        for(var14 = 0; var14 < var13; ++var14) {
            var15 = var12[var14];
            var11 += Utils.varSize(var15);
        }

        int var10 = var11;
        Label[] var7;
        int var17;
        if (this.isMethodOnErrorDefined()) {
            var11 = this.exceptionsToCatch.size();
            var7 = new Label[var11];

            for(var17 = 0; var17 < var11; ++var17) {
                Class var19 = (Class)this.exceptionsToCatch.get(var17);
                Method var21 = this.returns ? this.getMethodReturningOnError(var19) : this.getMethodVoidOnError(var19);
                if (null != var21) {
                    var2.visitTryCatchBlock(var5, var6, var7[var17] = new Label(), Utils.makeSlashed((Class)this.exceptionsToCatch.get(var17)));
                }
            }
        } else {
            var7 = null;
        }

        var2.visitLabel(var3);
        var2.visitLabel(var5);
        Class var22;
        if (this.isMethodPreDefined()) {
            var2.visitVarInsn(25, 0);
            var2.visitFieldInsn(178, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
            var2.visitVarInsn(25, 0);
            var11 = this.parameterTypes.length;
            if (this.method.isVarArgs() && 1 == var11) {
                var2.visitVarInsn(25, 1);
            } else if (0 == var11) {
                var2.visitFieldInsn(178, this.proxyName, "zeroLengthObjectArray", "[Ljava/lang/Object;");
            } else {
                Utils.loadConst(var2, var11);
                var2.visitTypeInsn(189, "java/lang/Object");
                var17 = 1;

                for(var13 = 0; var13 < var11; ++var13) {
                    var22 = this.parameterTypes[var13];
                    var2.visitInsn(89);
                    Utils.loadConst(var2, var13);
                    var2.visitVarInsn(Utils.loadOpcode(var22), var17);
                    Utils.autoBox(var2, var22);
                    var2.visitInsn(83);
                    var17 += Utils.varSize(var22);
                }
            }

            var2.visitMethodInsn(183, this.superclassName, this.getMethodPre().getName(), "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)V");
        }

        if (this.isMethodPostDefined()) {
            var2.visitVarInsn(25, 0);
            var2.visitFieldInsn(178, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
        }

        boolean var18 = this.isResultProxied();
        if (this.returns && var18) {
            var2.visitVarInsn(25, 0);
            var2.visitFieldInsn(180, this.proxyName, "proxyFactory", Utils.makeType(ProxyFactory.class.getName()));
        }

        var2.visitVarInsn(25, 0);
        if (this.callDelegate) {
            var2.visitFieldInsn(180, this.proxyName, "delegate", this.ifaceType);
        }

        this.loadDelegateParams(var2);
        var2.visitMethodInsn(this.callDelegate ? 185 : 183, this.callDelegate ? this.ifaceName : this.superclassName, this.methodName, this.signature);
        if (this.returns && var18) {
            Utils.cast(var2, this.returnType, Object.class);
            var2.visitVarInsn(25, 0);
            var2.visitVarInsn(25, 0);
            var2.visitFieldInsn(180, this.proxyName, "proxyCache", "Ljava/util/Map;");
            var2.visitFieldInsn(178, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
            String var20;
            switch(this.getProxyResultPolicy()) {
                case CREATE:
                    var20 = "proxyForCreate";
                    break;
                case CACHE:
                    var20 = "proxyForCache";
                    break;
                case CREATE_CACHE:
                    var20 = "proxyForCreateCache";
                    break;
                default:
                    throw new RuntimeException("internal error");
            }

            var2.visitMethodInsn(182, Utils.makeSlashed(ProxyFactory.class.getName()), var20, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/reflect/Method;)Ljava/lang/Object;");
        }

        if (this.isMethodPostDefined()) {
            if (this.returns) {
                Utils.cast(var2, var18 ? Object.class : this.returnType, this.getMethodPost().getParameterTypes()[1]);
            }

            var2.visitMethodInsn(182, this.superclassName, this.getMethodPost().getName(), "(Ljava/lang/reflect/Method;" + (this.returns ? Utils.makeType(this.getMethodPost().getParameterTypes()[1]) : "") + ")" + Utils.makeType(this.getMethodPost().getReturnType()));
            if (this.returns) {
                Utils.cast(var2, this.getMethodPost().getReturnType(), this.returnType);
            }
        } else if (this.returns) {
            Utils.cast(var2, var18 ? Object.class : this.returnType, this.returnType);
        }

        var2.visitLabel(var6);
        var2.visitInsn(Utils.returnOpcode(this.returnType));
        Label[] var8;
        Label[] var9;
        if (this.isMethodOnErrorDefined()) {
            var17 = this.exceptionsToCatch.size();
            var8 = new Label[var17];
            var9 = new Label[var17];

            for(var13 = 0; var13 < var17; ++var13) {
                var22 = (Class)this.exceptionsToCatch.get(var13);
                Method var24 = this.returns ? this.getMethodReturningOnError(var22) : this.getMethodVoidOnError(var22);
                if (null != var24) {
                    var2.visitLabel(var7[var13]);
                    var2.visitFrame(4, 0, (Object[])null, 1, new Object[]{Utils.makeSlashed(var22)});
                    var2.visitVarInsn(58, var10);
                    var2.visitLabel(var8[var13] = new Label());
                    var2.visitVarInsn(25, 0);
                    var2.visitFieldInsn(178, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
                    if (this.returns && this.isMethodPostDefined()) {
                        var2.visitVarInsn(25, 0);
                        var2.visitFieldInsn(178, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
                    }

                    var2.visitVarInsn(25, var10);
                    var2.visitMethodInsn(182, this.superclassName, var24.getName(), "(Ljava/lang/reflect/Method;" + Utils.makeType(var24.getParameterTypes()[1].getName()) + ")" + Utils.makeType(var24.getReturnType().getName()));
                    if (this.returns && this.isMethodPostDefined()) {
                        Utils.cast(var2, var24.getReturnType(), this.getMethodPost().getParameterTypes()[1]);
                        var2.visitMethodInsn(182, this.superclassName, this.getMethodPost().getName(), "(Ljava/lang/reflect/Method;" + Utils.makeType(this.getMethodPost().getParameterTypes()[1].getName()) + ")" + Utils.makeType(this.getMethodPost().getReturnType().getName()));
                        Utils.cast(var2, this.getMethodPost().getReturnType(), this.returnType);
                    } else {
                        Utils.cast(var2, var24.getReturnType(), this.returnType);
                    }

                    var2.visitInsn(Utils.returnOpcode(this.returnType));
                    var2.visitLabel(var9[var13] = new Label());
                }
            }
        } else {
            var9 = null;
            var8 = null;
        }

        var2.visitLabel(var4);
        byte var23 = 0;
        var17 = var23 + 1;
        var2.visitLocalVariable("this", this.proxyType, (String)null, var3, var4, var23);

        for(var13 = 0; var13 < this.parameterTypes.length; ++var13) {
            var2.visitLocalVariable("arg" + var13, Utils.makeType(this.parameterTypes[var13]), (String)null, var3, var4, var17);
            var17 += Utils.varSize(this.parameterTypes[var13]);
        }

        if (this.isMethodOnErrorDefined()) {
            if (var10 != var17) {
                throw new RuntimeException("wrong exception index");
            }

            var13 = this.exceptionsToCatch.size();

            for(var14 = 0; var14 < var13; ++var14) {
                var15 = (Class)this.exceptionsToCatch.get(var14);
                Method var16 = this.returns ? this.getMethodReturningOnError(var15) : this.getMethodVoidOnError(var15);
                if (null != var16) {
                    var2.visitLocalVariable("e", Utils.makeType((Class)this.exceptionsToCatch.get(var14)), (String)null, var8[var14], var9[var14], var10);
                }
            }
        }

        var2.visitMaxs(0, 0);
        var2.visitEnd();
    }

    private void loadDelegateParams(MethodVisitor var1) {
        String var2 = Utils.makeSlashed(_Proxy_.class.getName());
        int var3 = 1;

        for(int var4 = 0; var4 < this.parameterTypes.length; ++var4) {
            Class var5 = this.parameterTypes[var4];
            String var6 = Utils.makeSlashed(var5.getName());
            boolean var7 = false;
            Iterator var8 = this.annotationsForIface.getRegistry().values().iterator();

            while(true) {
                while(var8.hasNext()) {
                    Value var9 = (Value)var8.next();
                    Iterator var10 = var9.getIfacesToProxy().iterator();

                    while(var10.hasNext()) {
                        Class var11 = (Class)var10.next();
                        if (var5.isAssignableFrom(var11)) {
                            var7 = true;
                            break;
                        }
                    }
                }

                if (var7) {
                    var1.visitVarInsn(Utils.loadOpcode(var5), var3);
                    var1.visitTypeInsn(193, var2);
                    Label var12 = new Label();
                    var1.visitJumpInsn(153, var12);
                    var1.visitVarInsn(Utils.loadOpcode(var5), var3);
                    var1.visitTypeInsn(192, var2);
                    var1.visitMethodInsn(185, var2, "_getDelegate_", "()Ljava/lang/Object;");
                    var1.visitTypeInsn(192, var6);
                    Label var13 = new Label();
                    var1.visitJumpInsn(167, var13);
                    var1.visitLabel(var12);
                    var1.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
                    var1.visitVarInsn(Utils.loadOpcode(var5), var3);
                    var1.visitLabel(var13);
                    var1.visitFrame(4, 0, (Object[])null, 1, new Object[]{var6});
                } else {
                    var1.visitVarInsn(Utils.loadOpcode(var5), var3);
                }

                var3 += Utils.varSize(this.parameterTypes[var4]);
                break;
            }
        }

    }

    void initializeMethodObject(MethodVisitor var1) {
        int var2 = this.parameterTypes.length;
        var1.visitLdcInsn(Type.getType(Utils.makeType(this.method.getDeclaringClass().getName())));
        var1.visitLdcInsn(this.methodName);
        Utils.loadConst(var1, var2);
        var1.visitTypeInsn(189, "java/lang/Class");

        for(int var3 = 0; var3 < var2; ++var3) {
            var1.visitInsn(89);
            Utils.loadConst(var1, var3);
            Utils.loadClass(var1, this.parameterTypes[var3]);
            var1.visitInsn(83);
        }

        var1.visitMethodInsn(182, "java/lang/Class", "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;");
        var1.visitFieldInsn(179, this.proxyName, this.getMethodObject(), "Ljava/lang/reflect/Method;");
    }
}
