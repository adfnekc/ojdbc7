//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

class Utils {
    Utils() {
    }

    static String makeSlashed(Class var0) {
        return makeSlashed(var0.getName());
    }

    static String makeSlashed(String var0) {
        return var0.replace('.', '/');
    }

    static String makeSlashed(String var0, String var1) {
        return makeSlashed(var0) + '/' + var1;
    }

    static String makeType(Class var0) {
        return makeType(var0.getName());
    }

    static String makeType(String var0) {
        String var1 = makeSlashed(var0);
        if ("boolean".equals(var1)) {
            return "Z";
        } else if ("char".equals(var1)) {
            return "C";
        } else if ("byte".equals(var1)) {
            return "B";
        } else if ("short".equals(var1)) {
            return "S";
        } else if ("int".equals(var1)) {
            return "I";
        } else if ("long".equals(var1)) {
            return "J";
        } else if ("float".equals(var1)) {
            return "F";
        } else if ("double".equals(var1)) {
            return "D";
        } else if ("void".equals(var1)) {
            return "V";
        } else {
            return var1.startsWith("[") ? var1 : 'L' + var1 + ';';
        }
    }

    static String makeSignature(Class[] var0, Class var1) {
        StringBuilder var2 = new StringBuilder();
        var2.append('(');
        Class[] var3 = var0;
        int var4 = var0.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Class var6 = var3[var5];
            var2.append(makeType(makeSlashed(var6.getName())));
        }

        var2.append(')').append(makeType(makeSlashed(var1.getName())));
        return var2.toString();
    }

    static String[] makeThrowables(Class[] var0) {
        int var1 = var0.length;
        String[] var2;
        if (0 == var1) {
            var2 = null;
        } else {
            var2 = new String[var1];

            for(int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = makeSlashed(var0[var3].getName());
            }
        }

        return var2;
    }

    static int loadOpcode(Class var0) {
        String var1 = var0.getName();
        if (!"boolean".equals(var1) && !"byte".equals(var1) && !"char".equals(var1) && !"short".equals(var1) && !"int".equals(var1)) {
            if ("long".equals(var1)) {
                return 22;
            } else if ("float".equals(var1)) {
                return 23;
            } else {
                return "double".equals(var1) ? 24 : 25;
            }
        } else {
            return 21;
        }
    }

    static int storeOpcode(Class var0) {
        String var1 = var0.getName();
        if (!"boolean".equals(var1) && !"byte".equals(var1) && !"char".equals(var1) && !"short".equals(var1) && !"int".equals(var1)) {
            if ("long".equals(var1)) {
                return 55;
            } else if ("float".equals(var1)) {
                return 56;
            } else {
                return "double".equals(var1) ? 57 : 58;
            }
        } else {
            return 54;
        }
    }

    static int returnOpcode(Class var0) {
        String var1 = var0.getName();
        if (!"boolean".equals(var1) && !"byte".equals(var1) && !"char".equals(var1) && !"short".equals(var1) && !"int".equals(var1)) {
            if ("long".equals(var1)) {
                return 173;
            } else if ("float".equals(var1)) {
                return 174;
            } else if ("double".equals(var1)) {
                return 175;
            } else {
                return "void".equals(var1) ? 177 : 176;
            }
        } else {
            return 172;
        }
    }

    static int varSize(Class var0) {
        String var1 = var0.getName();
        return !"double".equals(var1) && !"long".equals(var1) ? 1 : 2;
    }

    static void cast(MethodVisitor var0, Class var1, Class var2) {
        boolean var3 = isPrimitive(var1);
        boolean var4 = isPrimitive(var2);
        if (!var3 && var4) {
            autoUnbox(var0, var2);
        } else if (var3 && !var4) {
            autoBox(var0, var1);
        } else if (!var3 && !var4 && !var1.equals(var2)) {
            var0.visitTypeInsn(192, makeSlashed(var2));
        }

    }

    static boolean isPrimitive(Class var0) {
        return Boolean.TYPE.equals(var0) || Character.TYPE.equals(var0) || Byte.TYPE.equals(var0) || Short.TYPE.equals(var0) || Integer.TYPE.equals(var0) || Long.TYPE.equals(var0) || Float.TYPE.equals(var0) || Double.TYPE.equals(var0);
    }

    static void autoBox(MethodVisitor var0, Class var1) {
        if (Boolean.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (Character.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (Byte.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (Short.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (Integer.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (Long.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (Float.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (Double.TYPE.equals(var1)) {
            var0.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        }

    }

    static void autoUnbox(MethodVisitor var0, Class var1) {
        if (Boolean.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Boolean");
            var0.visitMethodInsn(182, "java/lang/Boolean", "booleanValue", "()Z");
        } else if (Character.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Character");
            var0.visitMethodInsn(182, "java/lang/Character", "charValue", "()C");
        } else if (Byte.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Byte");
            var0.visitMethodInsn(182, "java/lang/Byte", "byteValue", "()B");
        } else if (Short.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Short");
            var0.visitMethodInsn(182, "java/lang/Short", "shortValue", "()S");
        } else if (Integer.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Integer");
            var0.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I");
        } else if (Long.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Long");
            var0.visitMethodInsn(182, "java/lang/Long", "longValue", "()J");
        } else if (Float.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Float");
            var0.visitMethodInsn(182, "java/lang/Float", "floatValue", "()F");
        } else if (Double.TYPE.equals(var1)) {
            var0.visitTypeInsn(192, "java/lang/Double");
            var0.visitMethodInsn(182, "java/lang/Double", "doubleValue", "()D");
        } else {
            var0.visitTypeInsn(192, makeSlashed(var1));
        }

    }

    static void loadClass(MethodVisitor var0, Class var1) {
        String var2 = var1.getName();
        if ("boolean".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
        } else if ("char".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Character", "TYPE", "Ljava/lang/Class;");
        } else if ("byte".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Byte", "TYPE", "Ljava/lang/Class;");
        } else if ("short".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Short", "TYPE", "Ljava/lang/Class;");
        } else if ("int".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
        } else if ("long".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Long", "TYPE", "Ljava/lang/Class;");
        } else if ("float".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Float", "TYPE", "Ljava/lang/Class;");
        } else if ("double".equals(var2)) {
            var0.visitFieldInsn(178, "java/lang/Double", "TYPE", "Ljava/lang/Class;");
        } else {
            var0.visitLdcInsn(Type.getType(var1));
        }

    }

    static void loadConst(MethodVisitor var0, int var1) {
        switch(var1) {
            case 0:
                var0.visitInsn(3);
                return;
            case 1:
                var0.visitInsn(4);
                return;
            case 2:
                var0.visitInsn(5);
                return;
            case 3:
                var0.visitInsn(6);
                return;
            case 4:
                var0.visitInsn(7);
                return;
            case 5:
                var0.visitInsn(8);
                return;
            default:
                if (var1 >= -128 && var1 <= 127) {
                    var0.visitIntInsn(16, var1);
                } else {
                    throw new RuntimeException("do not know how to load " + var1);
                }
        }
    }
}
