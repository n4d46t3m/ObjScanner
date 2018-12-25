package org.n4d46t3m.classes;

import org.n4d46t3m.classes.ObjScanner;

public class ObjScanViewController {

    /**
     * 
     * Given two object obj1 and obj2, perform obj1=obj2 and print 
     * to video what is happening
     * 
     * @param obj1
     * @param obj2
     * @param obj1Name
     * @param obj2Name
     * @return the modified object obj1
     */
    public Object setEquality(Object obj1, Object obj2, 
            String obj1Name, String obj2Name) {
        StringBuilder text = new StringBuilder();
        try {
        text.append("PERFORMING ===== ")
            .append(obj1Name)
            .append("=")
            .append(obj2Name)
            .append(" =====\n");
        System.out.println(text.toString());
        obj1=obj2;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return obj1;
    }
    
    /**
     * 
     * Print on console memory and hashing info of an objects
     * 
     * @param objNamePrefix
     * @param objs can be one or more objects or an array of objects
     */
    @SuppressWarnings("static-access")
    public void printObjInfos(String objNamePrefix, Object... objs) {
        
        int counter=0;
        ObjScanner myScan = new ObjScanner();
        StringBuilder objInfoText = new StringBuilder();
        for(Object obj: objs) {
            objInfoText.append("\\\\\\\\\\\\\\\\ ")
                .append(objNamePrefix)
                .append(counter)
                .append(": ")
                .append(obj)
                .append(" ////////")
                .append("\n")
                .append("Type of object: ")
                .append(myScan.getType(obj))
                .append("\n")
                .append("Memory address: ")
                .append(myScan.getMemAddr(obj))
                .append("\n")
                .append("Identity HashCode: ")
                .append(myScan.getIdentityHash(obj))
                .append("\n")
                .append("Identity HashCode HEX: ")
                .append(myScan.getIdentityHashHex(obj))
                .append("\n")
                .append("HashCode: ")
                .append(myScan.getHash(obj))
                .append("\n")
                .append("///////////////////////////////////")
                .append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
                //This is ugly...
                .append("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
                .append("\n");
            counter++;
        }
        System.out.println(objInfoText.toString());
    }
    
    /**
     * 
     * Invoke equals() on two objects and then perform an == comparison
     * 
     * @param a is the first Object
     * @param b is the second Object
     * @param aName is the name of the first Object
     * @param bName is the name of the second Object
     * 
     */
    public void printObjComparations(Object a, Object b, 
            String aName, String bName) {
        StringBuilder text = new StringBuilder();
        text.append(aName)
            .append(".equals(")
            .append(bName)
            .append(") returns ")
            .append(a.equals(b))
            .append("\n")
            .append(aName)
            .append("==")
            .append(bName)
            .append(" returns ")
            .append(a==b);
        System.out.println(text.toString());
    }
    
}
