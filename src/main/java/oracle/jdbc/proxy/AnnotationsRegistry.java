//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.GetProxy;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyAccess;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyLocale;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;

class AnnotationsRegistry {
    private Map<Class, AnnotationsRegistry.Value> ifacesToAnnotatedSuperclasses = new HashMap();

    AnnotationsRegistry() {
    }

    void register(Class... var1) {
        Class[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Class var5 = var2[var4];
            if (var5.isInterface()) {
                throw AnnotationsRegistry.SyntaxError.mustBeClass(var5);
            }

            AnnotationsRegistry.Value var6 = new AnnotationsRegistry.Value(var5);
            Iterator var7 = var6.getIfacesToProxy().iterator();

            while(var7.hasNext()) {
                Class var8 = (Class)var7.next();
                this.ifacesToAnnotatedSuperclasses.put(var8, var6);
            }
        }

    }

    AnnotationsRegistry.Value get(Class var1) {
        return null == var1 ? null : (AnnotationsRegistry.Value)this.ifacesToAnnotatedSuperclasses.get(var1);
    }

    Set<Class> keySet() {
        return this.ifacesToAnnotatedSuperclasses.keySet();
    }

    Collection<AnnotationsRegistry.Value> values() {
        return this.ifacesToAnnotatedSuperclasses.values();
    }

    boolean containsKey(Object var1) {
        return this.ifacesToAnnotatedSuperclasses.containsKey(var1);
    }

    static class Value {
        private final Class superclass;
        private final List<Class> ifacesToProxy = new ArrayList();
        private final AnnotationsRegistry.Value.MethodSpecific.Pres pres = new AnnotationsRegistry.Value.MethodSpecific.Pres();
        private final AnnotationsRegistry.Value.MethodSpecific.VoidPosts voidPosts = new AnnotationsRegistry.Value.MethodSpecific.VoidPosts();
        private final AnnotationsRegistry.Value.MethodSpecific.ReturningPosts returningPosts = new AnnotationsRegistry.Value.MethodSpecific.ReturningPosts();
        private final AnnotationsRegistry.Value.MethodSpecific.VoidOnErrors voidOnErrors = new AnnotationsRegistry.Value.MethodSpecific.VoidOnErrors();
        private final AnnotationsRegistry.Value.MethodSpecific.ReturningOnErrors returningOnErrors = new AnnotationsRegistry.Value.MethodSpecific.ReturningOnErrors();
        private final AnnotationsRegistry.Value.Rest rest;
        private Method methodGetCreator = null;
        private Method methodGetDelegate = null;
        private Method methodGetProxy = null;
        private Method methodSetDelegate = null;
        private boolean isProxyLocale = false;
        private ProxyResultPolicy proxyResultPolicy;
        private Class proxyAccessIface;
        private Method proxyAccessGetter;
        private Method proxyAccessSetter;
        private Method pre;
        private Method voidPost;
        private Method returningPost;
        private Map<Class, Method> voidOnErrorsMap;
        private Map<Class, Method> returningOnErrorsMap;
        private static final Class[] listOfMethodOperators = new Class[]{Pre.class, Post.class, OnError.class, GetCreator.class, GetDelegate.class, GetProxy.class, SetDelegate.class};

        Value(Class var1) {
            this.proxyResultPolicy = ProxyResultPolicy.CACHE;
            this.proxyAccessIface = null;
            this.proxyAccessGetter = null;
            this.proxyAccessSetter = null;
            this.pre = null;
            this.voidPost = null;
            this.returningPost = null;
            this.voidOnErrorsMap = new HashMap();
            this.returningOnErrorsMap = new HashMap();
            this.superclass = var1;
            this.rest = this.parseAnnotations();
        }

        private void parseAnnotationTypeProxyResult() {
            if (this.superclass.isAnnotationPresent(ProxyResult.class)) {
                ProxyResult var1 = (ProxyResult)this.superclass.getAnnotation(ProxyResult.class);
                this.proxyResultPolicy = var1.value();
            }

        }

        private void parseAnnotationProxyLocale() {
            if (this.superclass.isAnnotationPresent(ProxyLocale.class)) {
                this.isProxyLocale = true;
            }

        }

        private void parseAnnotationProxyFor() {
            if (this.superclass.isAnnotationPresent(ProxyFor.class)) {
                ProxyFor var1 = (ProxyFor)this.superclass.getAnnotation(ProxyFor.class);
                Class[] var2 = var1.value();
                int var3 = var2.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    Class var5 = var2[var4];
                    if (!var5.isInterface()) {
                        throw AnnotationsRegistry.SyntaxError.mustBeIface(var5);
                    }

                    this.ifacesToProxy.add(var5);
                }

            } else {
                throw AnnotationsRegistry.SyntaxError.noProxyForClass(this.superclass);
            }
        }

        private boolean isProxyAccessGetter(Method var1) {
            if (!Object.class.equals(var1.getReturnType())) {
                return false;
            } else if (!Arrays.deepEquals(new Class[0], var1.getParameterTypes())) {
                return false;
            } else {
                return Arrays.deepEquals(new Class[0], var1.getExceptionTypes());
            }
        }

        private boolean isProxyAccessSetter(Method var1) {
            if (!Void.TYPE.equals(var1.getReturnType())) {
                return false;
            } else if (!Arrays.deepEquals(new Class[]{Object.class}, var1.getParameterTypes())) {
                return false;
            } else {
                return Arrays.deepEquals(new Class[0], var1.getExceptionTypes());
            }
        }

        private void parseAnnotationProxyAccess() {
            if (this.superclass.isAnnotationPresent(ProxyAccess.class)) {
                this.proxyAccessIface = ((ProxyAccess)this.superclass.getAnnotation(ProxyAccess.class)).value();
                if (!this.proxyAccessIface.isInterface()) {
                    throw AnnotationsRegistry.SyntaxError.mustBeIface(this.proxyAccessIface);
                }

                if (0 != this.proxyAccessIface.getInterfaces().length) {
                    throw AnnotationsRegistry.SyntaxError.mustNotImplementIfaces(this.proxyAccessIface);
                }

                Method[] var1 = this.proxyAccessIface.getMethods();
                if (2 != var1.length) {
                    throw AnnotationsRegistry.SyntaxError.wrongProxyAccessIface(this.proxyAccessIface);
                }

                if (this.isProxyAccessGetter(var1[0]) && this.isProxyAccessSetter(var1[1])) {
                    this.proxyAccessGetter = var1[0];
                    this.proxyAccessSetter = var1[1];
                } else {
                    if (!this.isProxyAccessGetter(var1[1]) || !this.isProxyAccessSetter(var1[0])) {
                        throw AnnotationsRegistry.SyntaxError.wrongProxyAccessIface(this.proxyAccessIface);
                    }

                    this.proxyAccessGetter = var1[1];
                    this.proxyAccessSetter = var1[0];
                }
            }

        }

        private void checkIsSingle(Method var1, Class var2) {
            Class[] var3 = listOfMethodOperators;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Class var6 = var3[var5];
                if (!var6.equals(var2) && var1.isAnnotationPresent(var6)) {
                    throw AnnotationsRegistry.SyntaxError.onlyOneAllowed;
                }
            }

        }

        private void parseAnnotationPre(Method var1) {
            if (var1.isAnnotationPresent(Pre.class)) {
                this.checkIsSingle(var1, Pre.class);
                if (!Arrays.deepEquals(new Class[0], var1.getExceptionTypes())) {
                    throw AnnotationsRegistry.SyntaxError.wrongPre;
                }

                if (!Arrays.deepEquals(new Class[]{Method.class, Object.class, Object[].class}, var1.getParameterTypes())) {
                    throw AnnotationsRegistry.SyntaxError.wrongPre;
                }

                if (!Void.TYPE.equals(var1.getReturnType())) {
                    throw AnnotationsRegistry.SyntaxError.wrongPre;
                }

                if (var1.isAnnotationPresent(Methods.class)) {
                    Signature[] var2 = ((Methods)var1.getAnnotation(Methods.class)).signatures();
                    int var3 = var2.length;

                    for(int var4 = 0; var4 < var3; ++var4) {
                        Signature var5 = var2[var4];
                        this.pres.put(new MethodSignature(var5.name(), var5.args(), (Class)null), var1);
                    }
                } else {
                    if (null != this.pre) {
                        throw AnnotationsRegistry.SyntaxError.onlyOneMethodslessAllowed;
                    }

                    this.pre = var1;
                }
            }

        }

        private Class doAutoBoxing(Class var1) {
            if (Boolean.TYPE.equals(var1)) {
                return Boolean.class;
            } else if (Character.TYPE.equals(var1)) {
                return Character.class;
            } else if (Byte.TYPE.equals(var1)) {
                return Byte.class;
            } else if (Short.TYPE.equals(var1)) {
                return Short.class;
            } else if (Integer.TYPE.equals(var1)) {
                return Integer.class;
            } else if (Long.TYPE.equals(var1)) {
                return Long.class;
            } else if (Float.TYPE.equals(var1)) {
                return Float.class;
            } else {
                return Double.TYPE.equals(var1) ? Double.class : var1;
            }
        }

        private void checkReturnTypesMismatch(MethodSignature var1, Method var2) {
            Method var3 = null;
            Class var4 = this.doAutoBoxing(var2.getReturnType());
            Iterator var5 = this.getIfacesToProxy().iterator();

            while(var5.hasNext()) {
                Class var6 = (Class)var5.next();

                try {
                    var3 = var6.getDeclaredMethod(var1.getName(), var1.getParameterTypes());
                    Class var7 = this.doAutoBoxing(var3.getReturnType());
                    if (!Void.TYPE.equals(var7)) {
                        var4.asSubclass(var7);
                    }
                } catch (NoSuchMethodException var8) {
                } catch (ClassCastException var9) {
                    throw AnnotationsRegistry.SyntaxError.returnTypeMismatch(var2, var3);
                }
            }

        }

        private void checkReturnTypesMismatch(Method var1) {
            Class var2 = this.doAutoBoxing(var1.getReturnType());
            Iterator var3 = this.getIfacesToProxy().iterator();

            while(var3.hasNext()) {
                Class var4 = (Class)var3.next();
                Method[] var5 = var4.getDeclaredMethods();
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    Method var8 = var5[var7];
                    Class var9 = this.doAutoBoxing(var8.getReturnType());
                    if (!Void.TYPE.equals(var9)) {
                        try {
                            var9.asSubclass(var2);
                        } catch (ClassCastException var11) {
                            throw AnnotationsRegistry.SyntaxError.returnTypeMismatch(var1, var8);
                        }
                    }
                }
            }

        }

        private void parseAnnotationPost(Method var1) {
            if (var1.isAnnotationPresent(Post.class)) {
                this.checkIsSingle(var1, Post.class);
                Class var2 = var1.getReturnType();
                Class[] var3 = var1.getParameterTypes();
                Class[] var4 = var1.getExceptionTypes();
                if (!Arrays.deepEquals(new Class[0], var4)) {
                    throw AnnotationsRegistry.SyntaxError.wrongPost;
                }

                Signature[] var5;
                int var6;
                int var7;
                Signature var8;
                if (Void.TYPE.equals(var2) && Arrays.deepEquals(new Class[]{Method.class}, var3)) {
                    if (var1.isAnnotationPresent(Methods.class)) {
                        var5 = ((Methods)var1.getAnnotation(Methods.class)).signatures();
                        var6 = var5.length;

                        for(var7 = 0; var7 < var6; ++var7) {
                            var8 = var5[var7];
                            this.voidPosts.put(new MethodSignature(var8.name(), var8.args(), (Class)null), var1);
                        }
                    } else {
                        if (null != this.voidPost) {
                            throw AnnotationsRegistry.SyntaxError.onlyOneMethodslessAllowed;
                        }

                        this.voidPost = var1;
                    }
                } else {
                    if (Void.TYPE.equals(var2) || !Arrays.deepEquals(new Class[]{Method.class, var2}, var3)) {
                        throw AnnotationsRegistry.SyntaxError.wrongPost;
                    }

                    if (var1.isAnnotationPresent(Methods.class)) {
                        var5 = ((Methods)var1.getAnnotation(Methods.class)).signatures();
                        var6 = var5.length;

                        for(var7 = 0; var7 < var6; ++var7) {
                            var8 = var5[var7];
                            MethodSignature var9 = new MethodSignature(var8.name(), var8.args(), (Class)null);
                            this.checkReturnTypesMismatch(var9, var1);
                            this.returningPosts.put(var9, var1);
                        }
                    } else {
                        this.checkReturnTypesMismatch(var1);
                        if (null != this.returningPost) {
                            throw AnnotationsRegistry.SyntaxError.onlyOneMethodslessAllowed;
                        }

                        this.returningPost = var1;
                    }
                }
            }

        }

        private void parseAnnotationOnError(Method var1) {
            if (var1.isAnnotationPresent(OnError.class)) {
                this.checkIsSingle(var1, OnError.class);
                Class var2 = var1.getReturnType();
                Class[] var3 = var1.getParameterTypes();
                Class[] var4 = var1.getExceptionTypes();
                OnError var5 = (OnError)var1.getAnnotation(OnError.class);
                Class var6 = var5.value();
                Signature[] var7;
                int var8;
                int var9;
                Signature var10;
                MethodSignature var11;
                Object var12;
                if (Arrays.deepEquals(new Class[]{Method.class, var6}, var3) && Arrays.deepEquals(new Class[]{var6}, var4) && Void.TYPE.equals(var2)) {
                    if (var1.isAnnotationPresent(Methods.class)) {
                        var7 = ((Methods)var1.getAnnotation(Methods.class)).signatures();
                        var8 = var7.length;

                        for(var9 = 0; var9 < var8; ++var9) {
                            var10 = var7[var9];
                            var11 = new MethodSignature(var10.name(), var10.args(), (Class)null);
                            var12 = (Map)this.voidOnErrors.get(var11);
                            if (null == var12) {
                                var12 = new HashMap();
                                this.voidOnErrors.put(var11, ((Map)var12));
                            }

                            if (null != ((Map)var12).put(var6, var1)) {
                                throw AnnotationsRegistry.SyntaxError.onlyOneOnErrorExceptionTypeAllowed;
                            }
                        }
                    } else if (null != this.voidOnErrorsMap.put(var6, var1)) {
                        throw AnnotationsRegistry.SyntaxError.onlyOneMethodslessAllowed;
                    }
                } else {
                    if (!Arrays.deepEquals(new Class[]{Method.class, var6}, var3) || !Arrays.deepEquals(new Class[]{var6}, var4) || Void.TYPE.equals(var2)) {
                        throw AnnotationsRegistry.SyntaxError.wrongOnError;
                    }

                    if (var1.isAnnotationPresent(Methods.class)) {
                        var7 = ((Methods)var1.getAnnotation(Methods.class)).signatures();
                        var8 = var7.length;

                        for(var9 = 0; var9 < var8; ++var9) {
                            var10 = var7[var9];
                            var11 = new MethodSignature(var10.name(), var10.args(), (Class)null);
                            this.checkReturnTypesMismatch(var11, var1);
                            var12 = (Map)this.returningOnErrors.get(var11);
                            if (null == var12) {
                                var12 = new HashMap();
                                this.returningOnErrors.put(var11, ((Map)var12));
                            }

                            if (null != ((Map)var12).put(var6, var1)) {
                                throw AnnotationsRegistry.SyntaxError.onlyOneOnErrorExceptionTypeAllowed;
                            }
                        }
                    } else {
                        this.checkReturnTypesMismatch(var1);
                        if (null != this.returningOnErrorsMap.put(var6, var1)) {
                            throw AnnotationsRegistry.SyntaxError.onlyOneMethodslessAllowed;
                        }
                    }
                }
            }

        }

        private void parseAnnotationGetCreator(Method var1) {
            if (var1.isAnnotationPresent(GetCreator.class)) {
                this.checkIsSingle(var1, GetCreator.class);
                if (var1.isAnnotationPresent(Methods.class)) {
                    throw AnnotationsRegistry.SyntaxError.wrongMethodsContext;
                }

                int var2 = var1.getModifiers();
                if (!Modifier.isProtected(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetCreatorMustBeProtected;
                }

                if (!Modifier.isAbstract(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetCreatorMustBeAbstract;
                }

                if (!Arrays.deepEquals(new Class[0], var1.getParameterTypes())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetCreator;
                }

                if (!Object.class.equals(var1.getReturnType())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetCreator;
                }

                this.methodGetCreator = var1;
            }

        }

        private void parseAnnotationGetProxy(Method var1) {
            if (var1.isAnnotationPresent(GetProxy.class)) {
                this.checkIsSingle(var1, GetProxy.class);
                if (var1.isAnnotationPresent(Methods.class)) {
                    throw AnnotationsRegistry.SyntaxError.wrongMethodsContext;
                }

                int var2 = var1.getModifiers();
                if (!Modifier.isProtected(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetProxyMustBeProtected;
                }

                if (!Modifier.isAbstract(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetProxyMustBeAbstract;
                }

                if (!Arrays.deepEquals(new Class[]{Object.class, Object.class}, var1.getParameterTypes())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetProxy;
                }

                if (!Object.class.equals(var1.getReturnType())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetProxy;
                }

                this.methodGetProxy = var1;
            }

        }

        private void parseAnnotationGetDelegate(Method var1) {
            if (var1.isAnnotationPresent(GetDelegate.class)) {
                this.checkIsSingle(var1, GetDelegate.class);
                if (var1.isAnnotationPresent(Methods.class)) {
                    throw AnnotationsRegistry.SyntaxError.wrongMethodsContext;
                }

                int var2 = var1.getModifiers();
                if (!Modifier.isProtected(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetDelegateMustBeProtected;
                }

                if (!Modifier.isAbstract(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetDelegateMustBeAbstract;
                }

                if (!Arrays.deepEquals(new Class[0], var1.getParameterTypes())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetDelegate;
                }

                if (Void.TYPE.equals(var1.getReturnType())) {
                    throw AnnotationsRegistry.SyntaxError.wrongGetDelegate;
                }

                this.methodGetDelegate = var1;
            }

        }

        private void parseAnnotationSetDelegate(Method var1) {
            if (var1.isAnnotationPresent(SetDelegate.class)) {
                this.checkIsSingle(var1, SetDelegate.class);
                if (var1.isAnnotationPresent(Methods.class)) {
                    throw AnnotationsRegistry.SyntaxError.wrongMethodsContext;
                }

                int var2 = var1.getModifiers();
                if (!Modifier.isProtected(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongSetDelegateMustBeProtected;
                }

                if (!Modifier.isAbstract(var2)) {
                    throw AnnotationsRegistry.SyntaxError.wrongSetDelegateMustBeAbstract;
                }

                if (1 != var1.getParameterTypes().length) {
                    throw AnnotationsRegistry.SyntaxError.wrongSetDelegate;
                }

                if (!Void.TYPE.equals(var1.getReturnType())) {
                    throw AnnotationsRegistry.SyntaxError.wrongSetDelegate;
                }

                this.methodSetDelegate = var1;
            }

        }

        private AnnotationsRegistry.Value.Rest parseAnnotations() {
            this.parseAnnotationProxyFor();
            this.parseAnnotationProxyAccess();
            this.parseAnnotationProxyLocale();
            this.parseAnnotationTypeProxyResult();
            Method[] var1 = this.superclass.getDeclaredMethods();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Method var4 = var1[var3];
                this.parseAnnotationPre(var4);
                this.parseAnnotationPost(var4);
                this.parseAnnotationOnError(var4);
                this.parseAnnotationGetCreator(var4);
                this.parseAnnotationGetProxy(var4);
                this.parseAnnotationGetDelegate(var4);
                this.parseAnnotationSetDelegate(var4);
            }

            if (null != this.proxyAccessIface) {
                Iterator var6 = this.ifacesToProxy.iterator();

                while(var6.hasNext()) {
                    Class var7 = (Class)var6.next();

                    try {
                        var7.asSubclass(this.proxyAccessIface);
                    } catch (ClassCastException var5) {
                        throw AnnotationsRegistry.SyntaxError.mustExtendProxyAccessIface(var7, this.proxyAccessIface);
                    }
                }
            }

            return new AnnotationsRegistry.Value.Rest(this.pre, this.voidPost, this.returningPost, this.voidOnErrorsMap, this.returningOnErrorsMap);
        }

        boolean belongsToIfaceToProxy(Class var1, MethodSignature var2) {
            Iterator var3 = this.ifacesToProxy.iterator();

            while(var3.hasNext()) {
                Class var4 = (Class)var3.next();

                try {
                    var1.asSubclass(var4);
                    if (this.isMethodDeclared(var4, var2)) {
                        return true;
                    }
                } catch (ClassCastException var6) {
                }
            }

            return false;
        }

        private boolean isMethodDeclared(Class var1, MethodSignature var2) {
            try {
                if (null != var1.getDeclaredMethod(var2.getName(), var2.getParameterTypes())) {
                    return true;
                }
            } catch (NoSuchMethodException var7) {
            }

            Class[] var3 = var1.getInterfaces();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Class var6 = var3[var5];
                if (this.isMethodDeclared(var6, var2)) {
                    return true;
                }
            }

            return false;
        }

        Method getMethodPre(Class var1, MethodSignature var2) {
            Method var3 = (Method)this.pres.get(var2);
            if (null != var3) {
                return var3;
            } else {
                return this.belongsToIfaceToProxy(var1, var2) ? this.rest.getPre() : null;
            }
        }

        Method getMethodVoidPost(Class var1, MethodSignature var2) {
            Method var3 = (Method)this.voidPosts.get(var2);
            if (null != var3) {
                return var3;
            } else {
                return this.belongsToIfaceToProxy(var1, var2) ? this.rest.getVoidPost() : null;
            }
        }

        Method getMethodReturningPost(Class var1, MethodSignature var2) {
            Method var3 = (Method)this.returningPosts.get(var2);
            if (null != var3) {
                return var3;
            } else {
                return this.belongsToIfaceToProxy(var1, var2) ? this.rest.getReturningPost() : null;
            }
        }

        Map<Class, Method> getMapVoidOnError(Class var1, MethodSignature var2) {
            Map var3 = (Map)this.voidOnErrors.get(var2);
            if (null != var3) {
                return var3;
            } else {
                return this.belongsToIfaceToProxy(var1, var2) ? this.rest.getVoidOnError() : null;
            }
        }

        Map<Class, Method> getMapReturningOnError(Class var1, MethodSignature var2) {
            Map var3 = (Map)this.returningOnErrors.get(var2);
            if (null != var3) {
                return var3;
            } else {
                return this.belongsToIfaceToProxy(var1, var2) ? this.rest.getReturningOnError() : null;
            }
        }

        Method getMethodGetCreator() {
            return this.methodGetCreator;
        }

        Method getMethodGetDelegate() {
            return this.methodGetDelegate;
        }

        Method getMethodGetProxy() {
            return this.methodGetProxy;
        }

        Method getMethodSetDelegate() {
            return this.methodSetDelegate;
        }

        List<Class> getIfacesToProxy() {
            return this.ifacesToProxy;
        }

        Class getSuperclass() {
            return this.superclass;
        }

        boolean isProxyLocale() {
            return this.isProxyLocale;
        }

        ProxyResultPolicy getProxyResultPolicy() {
            return this.proxyResultPolicy;
        }

        ProxyResultPolicy getProxyResultPolicy(Method var1) {
            Method var2;
            try {
                var2 = this.superclass.getDeclaredMethod(var1.getName(), var1.getParameterTypes());
            } catch (NoSuchMethodException var4) {
                return this.proxyResultPolicy;
            }

            if (var2.isAnnotationPresent(ProxyResult.class)) {
                ProxyResult var3 = (ProxyResult)var2.getAnnotation(ProxyResult.class);
                return var3.value();
            } else {
                return this.proxyResultPolicy;
            }
        }

        Class getProxyAccessIface() {
            return this.proxyAccessIface;
        }

        Method getProxyAccessGetter() {
            return this.proxyAccessGetter;
        }

        Method getProxyAccessSetter() {
            return this.proxyAccessSetter;
        }

        private static class Rest {
            private final Method pre;
            private final Method voidPost;
            private final Method returningPost;
            private final Map<Class, Method> voidOnErrorsMap;
            private final Map<Class, Method> returningOnErrorsMap;

            Rest(Method var1, Method var2, Method var3, Map<Class, Method> var4, Map<Class, Method> var5) {
                this.pre = var1;
                this.voidPost = var2;
                this.returningPost = var3;
                this.voidOnErrorsMap = var4;
                this.returningOnErrorsMap = var5;
            }

            Method getPre() {
                return this.pre;
            }

            Map<Class, Method> getReturningOnError() {
                return this.returningOnErrorsMap;
            }

            Method getReturningPost() {
                return this.returningPost;
            }

            Map<Class, Method> getVoidOnError() {
                return this.voidOnErrorsMap;
            }

            Method getVoidPost() {
                return this.voidPost;
            }
        }

        private static class MethodSpecific<T> {
            private final Map<MethodSignature, T> ref;
            private final String annotationType;

            private MethodSpecific(String var1) {
                this.ref = new HashMap();
                this.annotationType = var1;
            }

            void put(MethodSignature var1, T var2) {
                if (null != this.ref.put(var1, var2)) {
                    throw AnnotationsRegistry.SyntaxError.annotationDefinedMoreThanOnce(this.annotationType);
                }
            }

            T get(MethodSignature var1) {
                return this.ref.get(var1);
            }

            static final class ReturningOnErrors extends AnnotationsRegistry.Value.MethodSpecific<Map<Class, Method>> {
                ReturningOnErrors() {
                    super("Returning @OnError");
                }
            }

            static final class VoidOnErrors extends AnnotationsRegistry.Value.MethodSpecific<Map<Class, Method>> {
                VoidOnErrors() {
                    super("Void @OnError");
                }
            }

            static final class ReturningPosts extends AnnotationsRegistry.Value.MethodSpecific<Method> {
                ReturningPosts() {
                    super("Returning @Post");
                }
            }

            static final class VoidPosts extends AnnotationsRegistry.Value.MethodSpecific<Method> {
                VoidPosts() {
                    super("Void @Post");
                }
            }

            static final class Pres extends AnnotationsRegistry.Value.MethodSpecific<Method> {
                Pres() {
                    super("@Pre");
                }
            }
        }
    }

    private static class SyntaxError extends RuntimeException {
        private static final AnnotationsRegistry.SyntaxError onlyOneAllowed = new AnnotationsRegistry.SyntaxError("only one @Pre/@Post/@OnError/@GetDelegate/@SetDelegate/@GetCreator/@GetProxy allowed");
        private static final AnnotationsRegistry.SyntaxError onlyOneMethodslessAllowed = new AnnotationsRegistry.SyntaxError("only one @Methods-less @Pre/@Post/@OnError allowed");
        private static final AnnotationsRegistry.SyntaxError wrongMethodsContext = new AnnotationsRegistry.SyntaxError("wrong context for @Methods");
        private static final AnnotationsRegistry.SyntaxError wrongPre = new AnnotationsRegistry.SyntaxError("wrong @Pre");
        private static final AnnotationsRegistry.SyntaxError wrongPost = new AnnotationsRegistry.SyntaxError("wrong @Post");
        private static final AnnotationsRegistry.SyntaxError wrongOnError = new AnnotationsRegistry.SyntaxError("wrong @OnError");
        private static final AnnotationsRegistry.SyntaxError onlyOneOnErrorExceptionTypeAllowed = new AnnotationsRegistry.SyntaxError("only one @OnError Exception type allowed for a given method");
        private static final AnnotationsRegistry.SyntaxError wrongGetCreator = new AnnotationsRegistry.SyntaxError("wrong @GetCreator");
        private static final AnnotationsRegistry.SyntaxError wrongGetCreatorMustBeProtected = new AnnotationsRegistry.SyntaxError("wrong @GetCreator: must be protected");
        private static final AnnotationsRegistry.SyntaxError wrongGetCreatorMustBeAbstract = new AnnotationsRegistry.SyntaxError("wrong @GetCreator: must be abstract");
        private static final AnnotationsRegistry.SyntaxError wrongGetDelegate = new AnnotationsRegistry.SyntaxError("wrong @GetDelegate");
        private static final AnnotationsRegistry.SyntaxError wrongGetDelegateMustBeProtected = new AnnotationsRegistry.SyntaxError("wrong @GetDelegate: must be protected");
        private static final AnnotationsRegistry.SyntaxError wrongGetDelegateMustBeAbstract = new AnnotationsRegistry.SyntaxError("wrong @GetDelegate: must be abstract");
        private static final AnnotationsRegistry.SyntaxError wrongGetProxy = new AnnotationsRegistry.SyntaxError("wrong @GetProxy");
        private static final AnnotationsRegistry.SyntaxError wrongGetProxyMustBeProtected = new AnnotationsRegistry.SyntaxError("wrong @GetProxy: must be protected");
        private static final AnnotationsRegistry.SyntaxError wrongGetProxyMustBeAbstract = new AnnotationsRegistry.SyntaxError("wrong @GetProxy: must be abstract");
        private static final AnnotationsRegistry.SyntaxError wrongSetDelegate = new AnnotationsRegistry.SyntaxError("wrong @SetDelegate");
        private static final AnnotationsRegistry.SyntaxError wrongSetDelegateMustBeProtected = new AnnotationsRegistry.SyntaxError("wrong @SetDelegate: must be protected");
        private static final AnnotationsRegistry.SyntaxError wrongSetDelegateMustBeAbstract = new AnnotationsRegistry.SyntaxError("wrong @SetDelegate: must be abstract");

        SyntaxError(String var1) {
            super(var1);
        }

        private static AnnotationsRegistry.SyntaxError mustBeClass(Class var0) {
            return new AnnotationsRegistry.SyntaxError(var0.getName() + " must be an abstract or concrete class");
        }

        private static AnnotationsRegistry.SyntaxError mustBeIface(Class var0) {
            return new AnnotationsRegistry.SyntaxError(var0.getName() + " must be an interface");
        }

        private static AnnotationsRegistry.SyntaxError mustNotImplementIfaces(Class var0) {
            return new AnnotationsRegistry.SyntaxError(var0.getName() + " must not implement interfaces");
        }

        private static AnnotationsRegistry.SyntaxError wrongProxyAccessIface(Class var0) {
            return new AnnotationsRegistry.SyntaxError(var0.getName() + " wrong @ProxyAccess argument.  " + "Must contain an interface with a simple getter and a simple setter and nothing else, like:\n" + "public interface Proxyable<T> {\n" + "  void setProxy(T proxy);\n" + "  T getProxy();\n" + "}");
        }

        private static AnnotationsRegistry.SyntaxError annotationDefinedMoreThanOnce(String var0) {
            return new AnnotationsRegistry.SyntaxError(var0 + " is defined more than once for the same method");
        }

        private static AnnotationsRegistry.SyntaxError mustExtendProxyAccessIface(Class var0, Class var1) {
            return new AnnotationsRegistry.SyntaxError(var0.getName() + " must extends @ProxyAccess interface " + var1.getName());
        }

        private static AnnotationsRegistry.SyntaxError noProxyForClass(Class var0) {
            return new AnnotationsRegistry.SyntaxError("no @ProxyFor for class " + var0.getName());
        }

        private static AnnotationsRegistry.SyntaxError returnTypeMismatch(Method var0, Method var1) {
            return new AnnotationsRegistry.SyntaxError("interceptor " + var0.getName() + " and interceptee " + var1.getName() + ": have different return types (" + var0.getReturnType().getName() + " and " + var1.getReturnType().getName() + ")");
        }
    }
}
