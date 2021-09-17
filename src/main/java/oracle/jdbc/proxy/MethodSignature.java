//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

class MethodSignature {
    private final String name;
    private final Class[] parameterTypes;
    private final Class returnType;
    private Integer hashCode = null;

    MethodSignature(Method var1) {
        this.name = var1.getName();
        this.parameterTypes = var1.getParameterTypes();
        this.returnType = var1.getReturnType();
    }

    MethodSignature(String var1, Class[] var2, Class var3) {
        this.name = var1;
        this.parameterTypes = var2;
        this.returnType = var3;
    }

    public boolean equals(Object var1) {
        if (null == var1) {
            return false;
        } else if (!(var1 instanceof MethodSignature)) {
            return false;
        } else {
            MethodSignature var2 = (MethodSignature)var1;
            if (this == var2) {
                return true;
            } else if (!this.name.equals(var2.name)) {
                return false;
            } else if (!Arrays.deepEquals(this.parameterTypes, var2.parameterTypes)) {
                return false;
            } else if (null != this.returnType && null != var2.returnType && !this.returnType.equals(var2.returnType)) {
                throw new RuntimeException("methods \"" + this.name + "\" have the same signature \"" + this.parameterTypes + "\" but different return types: \"" + this.returnType + "\" and \"" + var2.returnType + '"');
            } else {
                return true;
            }
        }
    }

    public int hashCode() {
        if (null == this.hashCode) {
            this.hashCode = new Integer(23);
            this.hashCode = HashUtil.hash(this.hashCode, this.name);
            this.hashCode = HashUtil.hash(this.hashCode, this.parameterTypes);
        }

        return this.hashCode;
    }

    String getName() {
        return this.name;
    }

    Class[] getParameterTypes() {
        return this.parameterTypes;
    }

    Class getReturnType() {
        return this.returnType;
    }
}
