package org.n4d46t3m.test;

import java.util.Scanner;

public class TestsOptsManagerController {
    
    private TestsOptsManager optMan = new TestsOptsManager();
    private boolean userWait = optMan.getUserWait();
    private Scanner userIn = null;
    
    public TestsOptsManagerController(Scanner userIn) {
        this.userIn=userIn;
    }

    protected void optController(String[] cliParam) {
        if (cliParam.length>0) {
            for(String arg: cliParam) {
                if(arg.equals("-h")) {
                    System.out.println(optMan.printUsage());
                    System.exit(0);
                }
                if(arg.equals("-v")) {
                    System.out.println(optMan.printVersion());
                    System.exit(0);
                }
                if(arg.equals("-w")) {
                    this.userIn = new Scanner(System.in);
                    this.userWait=true;
                }
                else {
                    System.out.println(optMan.printUncknown());
                    System.exit(1);
                }
            }
        }
    }
    
    protected void inputScanClose() {
        try {
            this.userIn.close();
        } catch(NullPointerException e) {
            // Nothing to do
        }
    }

    public Scanner getUserIn() {
        return this.userIn;
    }
    
    public boolean getUserWait() {
        return userWait;
    }

}
