package org.n4d46t3m.test;

import java.util.Scanner;

import org.n4d46t3m.classes.ObjScanViewController;

/**
 * 
 * You can play with the main of this test class to study String hashing and 
 * memory behavior, you can make the infinite and perform fuzzy tests. 
 * 
 * @author crash
 * @version 1.0
 *
 */
public class StringScanTests {
    
    /**
     * 
     * Set the value of a String object and print on console what is happening.
     * This function should be placed in ObjScannerViewController?
     * 
     * @param obj
     * @param objName
     * @param newText is the text that should replace the old one
     * @param newOrNot is a boolean, false to perform obj = someString,
     * true to perform obj = new String(soneString)
     * @return String object with modified param
     */
    private Object setObjParam(Object obj,String objName, String newText, boolean newOrNot) {
        StringBuilder text = new StringBuilder();
        if(newOrNot) {
            text.append("SETTING ")
                .append(objName)
                .append("= new String(\"")
                .append(newText)
                .append("\")");
            obj=newText;
        } else {
            text.append("SETTING ")
                .append(objName)
                .append("=\"")
                .append(newText)
                .append("\"");
            obj=new String(newText);
        }
        System.out.println(text.toString());
        System.out.println("====== NOW "+objName+"=\""+obj+"\" ======");
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
                .append(" value is ")
                .append(obj)
                .append("\n");
            counter++;
        }
        System.out.println(text.toString());
    }
    
    public static void main(String[] args) {
        
        StringScanTests strVal = new StringScanTests();
        ObjScanViewController memPointerTests = new ObjScanViewController();
        
        Scanner userIn = null;
        TestsOptsManagerController optController = 
                new TestsOptsManagerController(userIn);
        
        optController.optController(args);
        boolean userWait = optController.getUserWait();
        userIn=optController.getUserIn();
        
        String strNamePrefix = "text";
        
        // You can try this...
        /*
        String text0 = "dreams";//xxx
        String text1 = "pretty";//yyy
        String text2 = "dreams";//zzz
        */
        // Or you can try this to see different behavior
        String text0 = new String("dreams");//xxx
        String text1 = new String("pretty");//yyy
        String text2 = new String("dreams");//zzz
        
        
        String newText;
        
        strVal.printObjParams(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjInfos(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjComparations(text0, text1, 
                strNamePrefix+"0", strNamePrefix+"1");
        memPointerTests.printObjComparations(text2, text1, 
                strNamePrefix+"2", strNamePrefix+"1");
        memPointerTests.printObjComparations(text0, text2, 
                strNamePrefix+"0", strNamePrefix+"2");

        if(userWait) {
            System.out.println("\nPress a key to continue test");
            userIn.nextLine();
        }
        
        System.out.println();
        text0=(String)memPointerTests.setEquality(text0, text1,
                strNamePrefix+"0", strNamePrefix+"1");
        System.out.println();
        
        strVal.printObjParams(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjInfos(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjComparations(text0, text1, 
                strNamePrefix+"0", strNamePrefix+"1");
        memPointerTests.printObjComparations(text2, text1, 
                strNamePrefix+"2", strNamePrefix+"1");
        memPointerTests.printObjComparations(text0, text2, 
                strNamePrefix+"0", strNamePrefix+"2");
        
        if(userWait) {
            System.out.println("\nPress a key to continue test");
            userIn.nextLine();
        }
        
        //text1 = "dreams";
        System.out.println();
        newText = "dreams";
        text1=(String)strVal.setObjParam(text1,strNamePrefix+"1",newText,false);
        System.out.println();
        
        strVal.printObjParams(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjInfos(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjComparations(text0, text1, 
                strNamePrefix+"0", strNamePrefix+"1");
        memPointerTests.printObjComparations(text2, text1, 
                strNamePrefix+"2", strNamePrefix+"1");
        memPointerTests.printObjComparations(text0, text2, 
                strNamePrefix+"0", strNamePrefix+"2");
        
        if(userWait) {
            System.out.println("\nPress a key to continue test");
            userIn.nextLine();
        }
        
        //text1 = new String("dreams");
        System.out.println();
        newText = "dreams";
        text1=(String)strVal.setObjParam(text1,strNamePrefix+"1",newText,true);
        System.out.println();
        
        strVal.printObjParams(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjInfos(strNamePrefix, text0, text1, text2);
        memPointerTests.printObjComparations(text0, text1, 
                strNamePrefix+"0", strNamePrefix+"1");
        memPointerTests.printObjComparations(text2, text1, 
                strNamePrefix+"2", strNamePrefix+"1");
        memPointerTests.printObjComparations(text0, text2, 
                strNamePrefix+"0", strNamePrefix+"2");

        optController.inputScanClose();
        System.exit(0);
        
    }

}
