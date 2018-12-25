package org.n4d46t3m.test;

import java.util.Scanner;

import org.n4d46t3m.classes.DummyClass;
import org.n4d46t3m.classes.ObjScanViewController;

/**
 * 
 * You can play with the main of this test class to study Object hashing and 
 * memory behavior, you can make the infinite and perform fuzzy tests. 
 * 
 * @author crash
 * @version 1.0
 *
 */
public class ObjScanTests {
    
    /**
     * 
     * Set the first or the second param of an object of type DummyClass
     * and print on console what is happening.
     * Ok, this function should be placed in ObjScannerViewController
     * but is still very related with tests on DummyClass.
     * 
     * @param obj
     * @param objName
     * @param param can be 1 or 2. 1 to modify 1st param, 2 to modify 2nd param
     * @param valueInt is the value that should replace the old one
     * @return DummyClass object with modified param
     */
    private Object setObjParam(Object obj,String objName,
            int param,int valueInt) {
        StringBuilder text = new StringBuilder();
        if(param==1) {
            text.append("SETTING ")
                .append(objName)
                .append(".set_firstParam(")
                .append(valueInt)
                .append(")");
            ((DummyClass) obj).set_firstParam(valueInt);
        } else if(param==2) {
            text.append("SETTING ")
                .append(objName)
                .append(".set_secondParam(")
                .append(valueInt)
                .append(")");
            ((DummyClass) obj).set_secondParam(valueInt);
        }
        System.out.println(text.toString());
        return obj;
    }
    
    /**
     * 
     * Print on console all parameters of DummyClass objects.
     * Ok, this function should be placed in ObjScannerViewController
     * but is still very related with tests on DummyClass.
     * 
     * @param objNamePrefix
     * @param objs can be one or more objects or an array of objects
     */
    private void printObjParams(String objNamePrefix, Object... objs) {
        int counter=0;
        StringBuilder text = new StringBuilder();
        for(Object obj: objs) {
            text.append(objNamePrefix)
                .append(counter)
                .append(".get_firstParam(): ")
                .append(((DummyClass) obj).get_firstParam())
                .append("\n")
                .append(objNamePrefix)
                .append(counter)
                .append(".get_secondParam(): ")
                .append(((DummyClass) obj).get_secondParam())
                .append("\n");
            counter++;
        }
        System.out.println(text.toString());
    }
    
    public static void main(String[] args) {
        
        ObjScanTests objParams = new ObjScanTests();
        ObjScanViewController memPointerTests = new ObjScanViewController();
        
        Scanner userIn = null;
        TestsOptsManagerController optController = 
                new TestsOptsManagerController(userIn);
        
        optController.optController(args);
        boolean userWait = optController.getUserWait();
        userIn=optController.getUserIn();
        
        String objNamePrefix = "dummyObj";
        
        DummyClass dummyObj0 = new DummyClass();
        DummyClass dummyObj1 = new DummyClass();
        DummyClass dummyObj2 = new DummyClass();
        
        int valueInt;
        
        valueInt = 3;
        objParams.setObjParam(dummyObj1,objNamePrefix+"1",1,valueInt);
        valueInt = 777;
        objParams.setObjParam(dummyObj2,objNamePrefix+"2",2,valueInt);
        System.out.println();
        
        objParams.printObjParams(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjInfos(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjComparations(dummyObj0, dummyObj1, 
                objNamePrefix+"0", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj2, dummyObj1, 
                objNamePrefix+"2", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj0, dummyObj2, 
                objNamePrefix+"0", objNamePrefix+"2");
        
        if(userWait) {
            System.out.println("\nPress a key to continue test");
            userIn.nextLine();
        }
        
        System.out.println();
        dummyObj0=(DummyClass) memPointerTests.setEquality(dummyObj0,dummyObj1,
                objNamePrefix+"0", objNamePrefix+"1");
        dummyObj0=(DummyClass) memPointerTests.setEquality(dummyObj0,dummyObj2,
                objNamePrefix+"0", objNamePrefix+"2");
        System.out.println();
        
        objParams.printObjParams(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjInfos(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjComparations(dummyObj0, dummyObj1, 
                objNamePrefix+"0", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj2, dummyObj1, 
                objNamePrefix+"2", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj0, dummyObj2, 
                objNamePrefix+"0", objNamePrefix+"2");
        
        if(userWait) {
            System.out.println("\nPress a key to continue test");
            userIn.nextLine();
        }
        
        System.out.println();
        valueInt = 6969;
        objParams.setObjParam(dummyObj0,objNamePrefix+"0",1,valueInt);
        System.out.println();
        
        objParams.printObjParams(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjInfos(objNamePrefix, 
                dummyObj0, dummyObj1, dummyObj2);
        memPointerTests.printObjComparations(dummyObj0, dummyObj1, 
                objNamePrefix+"0", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj2, dummyObj1, 
                objNamePrefix+"2", objNamePrefix+"1");
        memPointerTests.printObjComparations(dummyObj0, dummyObj2, 
                objNamePrefix+"0", objNamePrefix+"2");
        
        optController.inputScanClose();
        System.exit(0);

    }

}
