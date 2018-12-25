package org.n4d46t3m.classes;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * 
 * This class provide some methods useful to get objects hashes and 
 * memory addresses
 * 
 * @author crash
 * @version 1.0
 *
 */

public class ObjScanner {
    
    /**
     * 
     * Return the type of an object.
     * 
     * @param obj
     * @return class name of an object
     */
    public String getType(Object obj) {
        return obj != null ? obj.getClass().getName() : "null";
    }
    
    /**
     * 
     * Return the identity hash code of an object.
     * What the identity hash code represents is implementation-specific.
     * 
     * @param obj
     * @return identity hash code of the given object
     */
    public Long getIdentityHash(Object obj) {
        return Long.valueOf(System.identityHashCode(obj));
    }
    
    /**
     * 
     * Return the identity hash code of an object in hexadecimal.
     * What the identity hash code represents is implementation-specific 
     * but usually this is the string part after the @ when you try to 
     * print an object that don't override toString() method.
     * 
     * @param obj
     * @return identity hash code of the given object
     */
    public String getIdentityHashHex(Object obj) {
        return Long.toHexString(this.getIdentityHash(obj));
    }
    
    /**
     * 
     * Return the overridden hash code of an object.
     * It can be returned also negative number but this is a right behavior
     * because the only requirement of hash codes is to be equal for equal 
     * objects.
     * 
     * @param obj
     * @return overridden hash code of the given object
     */
    public int getHash(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }
    
    /**
     * 
     * Given one or more objects (or an array of objects) it will be returned
     * a string containing memory addresses of that objects.
     * Getting the memory addresses of variables is meaningless within Java 
     * since the JVM sometimes (garbage collection and so on..) move them as
     * it seems fit XD.
     * 
     * PS: Maybe this method is a shit and is wrong???
     * 
     * See:
     * stackoverflow.com/questions/8820164/is-there-a-way-to-get-a-reference-address
     * 
     * @param obj one or more objects or an array of objects
     * @return object memory address in hexadecimal format
     */
    public static String getMemAddr(Object... obj) {
        final Unsafe unsafe = getUnsafe();
        long last = 0;
        int offset = unsafe.arrayBaseOffset(obj.getClass());
        int scale = unsafe.arrayIndexScale(obj.getClass());
        String addresses = new String("0x");
        switch (scale) {
        case 4:
            long factor = 8; // 8 for 64bit - 1 for 32bit
            final long i1 = (unsafe.getInt(obj, offset) & 0xFFFFFFFFL) * factor;
            addresses+=Long.toHexString(i1);
            last = i1;
            for (int i = 1; i < obj.length; i++) {
                final long i2 = (unsafe.getInt(obj, offset + i * 4) & 0xFFFFFFFFL) * factor;
                if (i2 > last)
                    addresses+=", +" + Long.toHexString(i2 - last);
                else
                    addresses+=", -" + Long.toHexString(last - i2);
                last = i2;
            }
            break;
        case 8:
            throw new AssertionError("Not supported :(");
        }
        return addresses;
    }
    
    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

}
