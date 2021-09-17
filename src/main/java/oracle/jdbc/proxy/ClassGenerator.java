//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import oracle.jdbc.proxy.AnnotationsRegistry.Value;
import oracle.jdbc.proxy.GeneratedProxiesRegistry.Key;
import oracle.jdbc.proxy.annotation.ProxyFor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

class ClassGenerator {
    private final ClassGenerator.AnnotationsForIface annotationsForIface;
    private final String proxyName;
    private final String superclassName;
    private final String ifaceName;
    private final String proxyType;
    private final String ifaceType;
    final Map<MethodSignature, MethodGenerator> members;

    private ClassGenerator(ClassGenerator.AnnotationsForIface var1, String var2, String var3, String var4, Map<MethodSignature, MethodGenerator> var5) {
        this.annotationsForIface = var1;
        this.proxyName = Utils.makeSlashed(var2);
        this.proxyType = Utils.makeType(var2);
        this.superclassName = Utils.makeSlashed(var3);
        this.ifaceName = Utils.makeSlashed(var4);
        this.ifaceType = Utils.makeType(var4);
        this.members = var5;
    }

    String getProxyName() {
        return this.proxyName;
    }

    String getSuperclassName() {
        return this.superclassName;
    }

    String getIfaceName() {
        return this.ifaceName;
    }

    String getProxyType() {
        return this.proxyType;
    }

    String getIfaceType() {
        return this.ifaceType;
    }

    static <T> byte[] generateBytecode(Key var0, AnnotationsRegistry var1) {
        Class var2 = var0.getIface();
        final Class var3 = var0.getSuperclass();
        if (!var2.isInterface()) {
            new RuntimeException("iface must be interface");
        }

        if (var3.isInterface()) {
            new RuntimeException("sclass must not be interface");
        }

        HashMap var4 = new HashMap();
        final HashMap var5 = new HashMap();
        final HashMap var6 = new HashMap();
        ClassGenerator.AnnotationsForIface var7 = new ClassGenerator.AnnotationsForIface(var1, var2, var1.get(var2));
        ClassGenerator var8 = new ClassGenerator(var7, var0.toString(), var3.getName(), var2.getName(), var4);
        (new Runnable() {
            public void run() {
                this.traverse(var3, var3.isAnnotationPresent(ProxyFor.class));
            }

            void traverse(Class var1, boolean var2) {
                if (null != var1) {
                    Method[] var3x = var1.getDeclaredMethods();
                    int var4 = var3x.length;

                    for(int var5x = 0; var5x < var4; ++var5x) {
                        Method var6x = var3x[var5x];
                        MethodSignature var7 = new MethodSignature(var6x);
                        if (var2) {
                            var5.put(var7, var6x);
                        } else if (!Modifier.isAbstract(var6x.getModifiers())) {
                            var6.put(var7, var6x);
                        }
                    }

                    Class var8 = var1.getSuperclass();
                    this.traverse(var8, var2 && var8.isAnnotationPresent(ProxyFor.class));
                }
            }
        }).run();
        Method[] var9 = var2.getMethods();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            Method var12 = var9[var11];
            MethodSignature var13 = new MethodSignature(var12);
            Method var14 = (Method)var5.get(var13);
            if (null != var14 || !var6.containsKey(var13)) {
                var4.put(var13, new MethodGenerator(var8, var12, null == var14 || Modifier.isAbstract(var14.getModifiers())));
            }
        }

        ClassWriter var15 = new ClassWriter(3);
        var8.generate(var15);
        return var15.toByteArray();
    }

    static <T> Class generate(Class<T> var0, Class var1, AnnotationsRegistry var2) {
        Key var3 = new Key(var0, var1);
        final byte[] var4 = generateBytecode(var3, var2);
        String var5 = System.getProperty("oracle.jdbc.proxy.asm.verify");
        if (null != var5 && 0 == "true".compareToIgnoreCase(var5)) {
            try {
                Class var6 = Class.forName("org.objectweb.asm.util.CheckClassAdapter");
                Method var7 = var6.getMethod("verify", ClassReader.class, Boolean.TYPE, PrintWriter.class);
                var7.invoke((Object)null, new ClassReader(var4), true, new PrintWriter(new OutputStreamWriter(System.out)));
            } catch (ClassNotFoundException var9) {
            } catch (NoSuchMethodException var10) {
            } catch (IllegalAccessException var11) {
            } catch (InvocationTargetException var12) {
            }
        }

        try {
            return Class.forName(var3.toString(), false, new ClassLoader() {
                protected Class findClass(String var1) {
                    return this.defineClass(var1, var4, 0, var4.length);
                }
            });
        } catch (ClassNotFoundException var8) {
            throw new RuntimeException(var8);
        }
    }

    private void generate(ClassWriter var1) {
        var1.visit(50, 33, this.proxyName, (String)null, this.superclassName, new String[]{this.ifaceName, Utils.makeSlashed(_Proxy_.class.getName())});
        Iterator var2 = this.members.values().iterator();

        while(var2.hasNext()) {
            MethodGenerator var3 = (MethodGenerator)var2.next();
            if (null != var3) {
                var3.generate(var1);
            }
        }

        MethodVisitor var10 = var1.visitMethod(1, "_getDelegate_", "()" + this.ifaceType, (String)null, (String[])null);
        var10.visitCode();
        var10.visitVarInsn(25, 0);
        var10.visitFieldInsn(180, this.proxyName, "delegate", this.ifaceType);
        var10.visitInsn(176);
        var10.visitMaxs(0, 0);
        var10.visitEnd();
        var10 = var1.visitMethod(4161, "_getDelegate_", "()Ljava/lang/Object;", (String)null, (String[])null);
        var10.visitCode();
        var10.visitVarInsn(25, 0);
        var10.visitMethodInsn(182, this.proxyName, "_getDelegate_", "()" + this.ifaceType);
        var10.visitInsn(176);
        var10.visitMaxs(0, 0);
        var10.visitEnd();
        Value var11 = this.annotationsForIface.getValue();
        MethodVisitor var4;
        Label var5;
        Label var6;
        Label var7;
        if (null != var11) {
            Method var12 = var11.getMethodGetDelegate();
            if (null != var12) {
                var4 = var1.visitMethod(1, var12.getName(), "()" + Utils.makeType(var12.getReturnType()), (String)null, (String[])null);
                var4.visitCode();
                var5 = new Label();
                var4.visitLabel(var5);
                var4.visitVarInsn(25, 0);
                var4.visitFieldInsn(180, this.proxyName, "delegate", this.ifaceType);
                var4.visitInsn(176);
                var6 = new Label();
                var4.visitLabel(var6);
                var4.visitLocalVariable("this", this.proxyType, (String)null, var5, var6, 0);
                var4.visitMaxs(0, 0);
                var4.visitEnd();
            }

            Method var16 = var11.getMethodSetDelegate();
            Label var8;
            MethodVisitor var22;
            if (null != var16) {
                Class[] var20 = var16.getParameterTypes();
                if (1 != var20.length) {
                    throw new RuntimeException("wrong delegate setter signature");
                }

                var22 = var1.visitMethod(1, var16.getName(), "(" + Utils.makeType(var20[0]) + ")V", (String)null, (String[])null);
                var22.visitCode();
                var22.visitLabel(var7 = new Label());
                var22.visitVarInsn(25, 0);
                var22.visitFieldInsn(180, this.proxyName, "proxyFactory", Utils.makeType(ProxyFactory.class));
                var22.visitVarInsn(25, 0);
                var22.visitVarInsn(25, 0);
                var22.visitFieldInsn(180, this.proxyName, "delegate", this.ifaceType);
                var22.visitVarInsn(25, 1);
                var22.visitMethodInsn(182, Utils.makeSlashed(ProxyFactory.class), "updateDelegate", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V");
                var22.visitVarInsn(25, 0);
                var22.visitVarInsn(25, 1);
                var22.visitFieldInsn(181, this.proxyName, "delegate", this.ifaceType);
                var22.visitInsn(177);
                var22.visitLabel(var8 = new Label());
                var22.visitLocalVariable("this", this.proxyType, (String)null, var7, var8, 0);
                var22.visitLocalVariable("delegate", this.ifaceType, (String)null, var7, var8, 1);
                var22.visitMaxs(0, 0);
                var22.visitEnd();
            }

            Method var21 = var11.getMethodGetCreator();
            if (null != var21) {
                var22 = var1.visitMethod(1, var21.getName(), "()" + Utils.makeType(var21.getReturnType()), (String)null, (String[])null);
                var22.visitCode();
                var7 = new Label();
                var22.visitLabel(var7);
                var22.visitVarInsn(25, 0);
                var22.visitFieldInsn(180, this.proxyName, "creator", "Ljava/lang/Object;");
                var22.visitInsn(176);
                var8 = new Label();
                var22.visitLabel(var8);
                var22.visitLocalVariable("this", this.proxyType, (String)null, var7, var8, 0);
                var22.visitMaxs(1, 1);
                var22.visitEnd();
            }

            Method var23 = var11.getMethodGetProxy();
            if (null != var23) {
                Class[] var24 = var23.getParameterTypes();
                Class var25 = var23.getReturnType();
                if (!Arrays.deepEquals(new Class[]{Object.class, Object.class}, var24) || !Object.class.equals(var25)) {
                    throw new RuntimeException("internal error: wrong @GetProxy method");
                }

                MethodVisitor var9 = var1.visitMethod(1, var23.getName(), "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<T:Ljava/lang/Object;>(TT;Ljava/lang/Object;)TT;", (String[])null);
                var9.visitCode();
                var9.visitVarInsn(25, 0);
                var9.visitFieldInsn(180, this.proxyName, "proxyFactory", Utils.makeType(ProxyFactory.class));
                var9.visitVarInsn(25, 1);
                var9.visitVarInsn(25, 2);
                var9.visitMethodInsn(182, Utils.makeSlashed(ProxyFactory.class), "proxyFor", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                var9.visitInsn(176);
                var9.visitMaxs(3, 3);
                var9.visitEnd();
            }
        }

        var1.visitField(2, "delegate", this.ifaceType, (String)null, (Object)null).visitEnd();
        var1.visitField(18, "creator", "Ljava/lang/Object;", (String)null, (Object)null).visitEnd();
        var1.visitField(18, "proxyFactory", Utils.makeType(ProxyFactory.class.getName()), (String)null, (Object)null).visitEnd();
        var1.visitField(18, "proxyCache", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;", (Object)null).visitEnd();
        var1.visitField(10, "zeroLengthObjectArray", "[Ljava/lang/Object;", (String)null, (Object)null).visitEnd();
        boolean var13 = false;

        for(Iterator var14 = this.members.values().iterator(); var14.hasNext(); var13 = true) {
            MethodGenerator var18 = (MethodGenerator)var14.next();
            var1.visitField(10, var18.getMethodObject(), "Ljava/lang/reflect/Method;", (String)null, (Object)null).visitEnd();
        }

        MethodVisitor var15 = var1.visitMethod(8, "<clinit>", "()V", (String)null, (String[])null);
        var15.visitCode();
        Utils.loadConst(var15, 0);
        var15.visitTypeInsn(189, "java/lang/Object");
        var15.visitFieldInsn(179, this.proxyName, "zeroLengthObjectArray", "[Ljava/lang/Object;");
        if (var13) {
            Label var19;
            var15.visitTryCatchBlock(var19 = new Label(), var5 = new Label(), var6 = new Label(), "java/lang/Throwable");
            var15.visitLabel(var19);
            Iterator var26 = this.members.values().iterator();

            while(var26.hasNext()) {
                MethodGenerator var27 = (MethodGenerator)var26.next();
                var27.initializeMethodObject(var15);
            }

            var15.visitLabel(var5);
            var15.visitJumpInsn(167, var7 = new Label());
            var15.visitLabel(var6);
            var15.visitFrame(4, 0, (Object[])null, 1, new Object[]{"java/lang/Throwable"});
            var15.visitVarInsn(58, 0);
            var15.visitTypeInsn(187, "java/lang/RuntimeException");
            var15.visitInsn(89);
            var15.visitVarInsn(25, 0);
            var15.visitMethodInsn(183, "java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V");
            var15.visitInsn(191);
            var15.visitLabel(var7);
            var15.visitFrame(3, 0, (Object[])null, 0, (Object[])null);
        }

        var15.visitInsn(177);
        var15.visitMaxs(0, 0);
        var15.visitEnd();
        String var17 = "(" + this.ifaceType + "Ljava/lang/Object;" + Utils.makeType(ProxyFactory.class.getName()) + "Ljava/util/Map;" + ")V";
        var4 = var1.visitMethod(1, "<init>", var17, (String)null, (String[])null);
        var4.visitCode();
        var4.visitVarInsn(25, 0);
        var4.visitMethodInsn(183, this.superclassName, "<init>", "()V");
        var4.visitVarInsn(25, 0);
        var4.visitVarInsn(25, 1);
        var4.visitFieldInsn(181, this.proxyName, "delegate", this.ifaceType);
        var4.visitVarInsn(25, 0);
        var4.visitVarInsn(25, 2);
        var4.visitFieldInsn(181, this.proxyName, "creator", "Ljava/lang/Object;");
        var4.visitVarInsn(25, 0);
        var4.visitVarInsn(25, 3);
        var4.visitFieldInsn(181, this.proxyName, "proxyFactory", Utils.makeType(ProxyFactory.class.getName()));
        var4.visitVarInsn(25, 0);
        var4.visitVarInsn(25, 4);
        var4.visitFieldInsn(181, this.proxyName, "proxyCache", "Ljava/util/Map;");
        var4.visitInsn(177);
        var4.visitMaxs(0, 0);
        var4.visitEnd();
        var1.visitEnd();
    }

    ClassGenerator.AnnotationsForIface getAnnotationsForIface() {
        return this.annotationsForIface;
    }

    static class AnnotationsForIface {
        private final AnnotationsRegistry registry;
        private final Class iface;
        private final Value value;

        AnnotationsForIface(AnnotationsRegistry var1, Class var2, Value var3) {
            this.registry = var1;
            this.iface = var2;
            this.value = var3;
        }

        AnnotationsRegistry getRegistry() {
            return this.registry;
        }

        Class getIface() {
            return this.iface;
        }

        Value getValue() {
            return this.value;
        }
    }
}
