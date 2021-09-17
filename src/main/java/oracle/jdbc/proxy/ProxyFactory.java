//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import oracle.jdbc.proxy.AnnotationsRegistry.Value;
import oracle.jdbc.proxy.GeneratedProxiesRegistry.Key;

public class ProxyFactory {
    final AnnotationsRegistry annotationsRegistry = new AnnotationsRegistry();
    private final GeneratedProxiesRegistry generatedRegistry = new GeneratedProxiesRegistry();
    private final Map<Class, Class> delegateClassToProxyClass = Collections.synchronizedMap(new HashMap());
    private final Map<Object, WeakReference<Object>> delegateToProxy = Collections.synchronizedMap(new WeakIdentityHashMap());
    private final Map<Class, Class> delegateToMostSuitableIface = Collections.synchronizedMap(new HashMap());
    private static final Object STALE_DELEGATE = new Object();
    private static final Class EMPTY_VALUE = ProxyFactory.EMPTY_CLASS.class;
    private static final ExtractDelegatePermission EXTRACT_DELEGATE_PERMISSION = new ExtractDelegatePermission();

    private ProxyFactory() {
    }

    public static ProxyFactory createProxyFactory(Class... var0) {
        ProxyFactory var1 = new ProxyFactory();
        var1.annotationsRegistry.register(var0);
        return var1;
    }

    public static ProxyFactory createJDBCProxyFactory(Class... var0) {
        ProxyFactory var1 = new ProxyFactory();
        var1.annotationsRegistry.register(new Class[]{NullProxy.class});
        var1.annotationsRegistry.register(var0);
        return var1;
    }

    public final boolean isProxied(Class var1) {
        return this.annotationsRegistry.containsKey(var1);
    }

    public final <T> T proxyFor(T var1) {
        return this.proxyFor(var1, this);
    }

    public final <T> T proxyFor(T var1, Object var2) {
        return (T) this.proxyForCache(var1, var2, (Map)null, (Method)null);
    }

    public final <T> T proxyForCreate(T var1, Object var2, Map<Object, WeakReference<Object>> var3, Method var4) {
        if (null == var1) {
            return null;
        } else if (var1 instanceof _Proxy_) {
            return var1;
        } else {
            Class var5 = var1.getClass();
            Class var6 = this.findMostSuitableIface(var5);
            if (null != var4 && null != var6 && !var4.getReturnType().isAssignableFrom(var6)) {
                return var1;
            } else {
                Value var7 = this.annotationsRegistry.get(var6);
                if (null == var7) {
                    return var1;
                } else {
                    if (null == var3) {
                        var3 = var7.isProxyLocale() ? new WeakIdentityHashMap() : this.delegateToProxy;
                    }

                    Class var8 = this.getProxyClass(var6, var5);
                    if (null == var8) {
                        return (T) this.createProxy(var6, var1, var2, (Map)var3);
                    } else {
                        try {
                            return (T) var8.getConstructor(var6, Object.class, ProxyFactory.class, Map.class).newInstance(var1, var2, this, var3);
                        } catch (NoSuchMethodException var10) {
                            throw new RuntimeException(var10);
                        } catch (IllegalAccessException var11) {
                            throw new RuntimeException(var11);
                        } catch (InvocationTargetException var12) {
                            throw new RuntimeException(var12);
                        } catch (InstantiationException var13) {
                            throw new RuntimeException(var13);
                        }
                    }
                }
            }
        }
    }

    public final <T> T proxyForCache(T var1, Object var2, Map<Object, WeakReference<Object>> var3, Method var4) {
        if (null == var1) {
            return null;
        } else if (var1 instanceof _Proxy_) {
            return var1;
        } else {
            Class var5 = var1.getClass();
            Class var6 = this.findMostSuitableIface(var5);
            if (null != var4 && null != var6 && !var4.getReturnType().isAssignableFrom(var6)) {
                return var1;
            } else {
                Value var7 = this.annotationsRegistry.get(var6);
                if (null == var7) {
                    return var1;
                } else {
                    Method var8 = var7.getProxyAccessGetter();
                    Method var9 = var7.getProxyAccessSetter();
                    if (null == var3) {
                        var3 = var7.isProxyLocale() ? new WeakIdentityHashMap() : this.delegateToProxy;
                    }

                    try {
                        Object var11;
                        if (null != var8) {
                            Object var10 = var8.invoke(var1);
                            if (null != var10) {
                                return (T) var10;
                            }
                        } else {
                            WeakReference var16 = (WeakReference)((Map)var3).get(var1);
                            if (null != var16) {
                                var11 = var16.get();
                                if (null != var11) {
                                    if (STALE_DELEGATE == var11) {
                                        throw new RuntimeException("stale delegate");
                                    }

                                    return (T) var11;
                                }
                            }
                        }

                        Class var17 = this.getProxyClass(var6, var5);
                        if (null == var17) {
                            var11 = this.createProxy(var6, var1, var2, (Map)var3);
                            if (null != var9) {
                                var9.invoke(var1, var11);
                            } else {
                                ((Map)var3).put(var1, new WeakReference(var11));
                            }

                            return (T) var11;
                        } else {
                            var11 = var17.getConstructor(var6, Object.class, ProxyFactory.class, Map.class).newInstance(var1, var2, this, var3);
                            if (null != var9) {
                                var9.invoke(var1, var11);
                            } else {
                                ((Map)var3).put(var1, new WeakReference(var11));
                            }

                            return (T) var11;
                        }
                    } catch (NoSuchMethodException var12) {
                        throw new RuntimeException(var12);
                    } catch (IllegalAccessException var13) {
                        throw new RuntimeException(var13);
                    } catch (InvocationTargetException var14) {
                        throw new RuntimeException(var14);
                    } catch (InstantiationException var15) {
                        throw new RuntimeException(var15);
                    }
                }
            }
        }
    }

    public final <T> T proxyForCreateCache(T var1, Object var2, Map<Object, WeakReference<Object>> var3, Method var4) {
        if (null == var1) {
            return null;
        } else if (var1 instanceof _Proxy_) {
            return var1;
        } else {
            Class var5 = var1.getClass();
            Class var6 = this.findMostSuitableIface(var5);
            if (null != var4 && null != var6 && !var4.getReturnType().isAssignableFrom(var6)) {
                return var1;
            } else {
                Value var7 = this.annotationsRegistry.get(var6);
                if (null == var7) {
                    return var1;
                } else {
                    if (null == var3) {
                        var3 = var7.isProxyLocale() ? new WeakIdentityHashMap() : this.delegateToProxy;
                    }

                    Method var8 = var7.getProxyAccessSetter();
                    Class var9 = this.getProxyClass(var6, var5);

                    try {
                        Object var10;
                        if (null == var9) {
                            var10 = this.createProxy(var6, var1, var2, (Map)var3);
                            if (null != var8) {
                                var8.invoke(var1, var10);
                            } else {
                                ((Map)var3).put(var1, new WeakReference(var10));
                            }

                            return (T) var10;
                        } else {
                            var10 = var9.getConstructor(var6, Object.class, ProxyFactory.class, Map.class).newInstance(var1, var2, this, var3);
                            if (null != var8) {
                                var8.invoke(var1, var10);
                            } else {
                                ((Map)var3).put(var1, new WeakReference(var10));
                            }

                            return (T) var10;
                        }
                    } catch (NoSuchMethodException var11) {
                        throw new RuntimeException(var11);
                    } catch (IllegalAccessException var12) {
                        throw new RuntimeException(var12);
                    } catch (InvocationTargetException var13) {
                        throw new RuntimeException(var13);
                    } catch (InstantiationException var14) {
                        throw new RuntimeException(var14);
                    }
                }
            }
        }
    }

    public <T> void updateDelegate(Object var1, T var2, T var3) {
        this.delegateToProxy.put(var2, new WeakReference(STALE_DELEGATE));
        this.delegateToProxy.put(var3, new WeakReference(var1));
    }

    public static final Object extractDelegate(_Proxy_ var0) {
        SecurityManager var1 = System.getSecurityManager();
        if (null != var1) {
            var1.checkPermission(EXTRACT_DELEGATE_PERMISSION);
        }

        return var0._getDelegate_();
    }

    private <T> T createProxy(Class var1, T var2, Object var3, Map<Object, WeakReference<Object>> var4) {
        if (null == var1) {
            return var2;
        } else {
            Value var5 = this.annotationsRegistry.get(var1);
            Class var6 = var5.getSuperclass();
            oracle.jdbc.proxy.GeneratedProxiesRegistry.Value var7 = this.generatedRegistry.get(var1, var6);
            Constructor var8 = null == var7 ? this.prepareProxy(var1, var6) : var7.getConstructor();

            try {
                return (T) var8.newInstance(var2, var3, this, var4);
            } catch (InvocationTargetException var10) {
                throw new RuntimeException(var10.getTargetException());
            } catch (IllegalAccessException var11) {
                throw new RuntimeException(var11);
            } catch (InstantiationException var12) {
                throw new RuntimeException(var12);
            }
        }
    }

    private Constructor prepareProxy(Class var1, Class var2) {
        Class var3 = null;

        try {
            var3 = Class.forName((new Key(var1, var2)).toString());
        } catch (ClassNotFoundException var7) {
            var3 = ClassGenerator.generate(var1, var2, this.annotationsRegistry);
        }

        Constructor var4;
        try {
            var4 = var3.getConstructor(var1, Object.class, ProxyFactory.class, Map.class);
        } catch (NoSuchMethodException var6) {
            throw new RuntimeException(var6);
        }

        this.generatedRegistry.put(var1, var2, new oracle.jdbc.proxy.GeneratedProxiesRegistry.Value((String)null, (String)null, var3, var4));
        return var4;
    }

    private Class getProxyClass(Class var1, Class var2) {
        if (null == var2) {
            return null;
        } else {
            Class var3 = (Class)this.delegateClassToProxyClass.get(var2);
            if (null != var3) {
                return EMPTY_VALUE != var3 ? var3 : null;
            } else if (null == var1) {
                return null;
            } else {
                oracle.jdbc.proxy.GeneratedProxiesRegistry.Value var5 = this.generatedRegistry.get(var1, this.annotationsRegistry.get(var1).getSuperclass());
                if (null == var5) {
                    return null;
                } else {
                    Class var4 = var5.getClazz();
                    this.delegateClassToProxyClass.put(var2, null != var4 ? var4 : EMPTY_VALUE);
                    return var4;
                }
            }
        }
    }

    private Class findMostSuitableIface(Class var1) {
        if (null == var1) {
            return null;
        } else {
            Class var2 = (Class)this.delegateToMostSuitableIface.get(var1);
            if (null != var2) {
                return EMPTY_VALUE != var2 ? var2 : null;
            } else {
                int var7 = -1;
                Class var3 = null;
                Iterator var4 = this.annotationsRegistry.keySet().iterator();

                while(var4.hasNext()) {
                    Class var5 = (Class)var4.next();
                    int var6 = this.intersectionCardinality(var1, var5);
                    if (var6 >= 1 && var6 > var7) {
                        var7 = var6;
                        var3 = var5;
                    }
                }

                this.delegateToMostSuitableIface.put(var1, null != var3 ? var3 : EMPTY_VALUE);
                return var3;
            }
        }
    }

    private int intersectionCardinality(Class var1, Class var2) {
        HashSet var3 = new HashSet();
        this.collectIfaces(var2, var3);
        HashSet var4 = new HashSet();
        this.collectIfaces(var1, var4);
        int var5 = var3.size();
        var3.removeAll(var4);
        return var3.size() > 0 ? -1 : var5;
    }

    private void collectIfaces(Class var1, Set<Class> var2) {
        if (var1.isInterface()) {
            var2.add(var1);
        }

        Class[] var3 = var1.getInterfaces();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Class var6 = var3[var5];
            this.collectIfaces(var6, var2);
        }

        Class var7 = var1.getSuperclass();
        if (null != var7) {
            this.collectIfaces(var7, var2);
        }

    }

    private static final class EMPTY_CLASS {
        private EMPTY_CLASS() {
        }
    }
}
