package org.n4d46t3m.classes;

/**
 * 
 * This is a dummy class that can be used for test custom object behavior
 * 
 * @version 1.0
 *
 */

public class DummyClass {
    
    private int firstParam;
    private int seconParam;
    
    public DummyClass() {
        this.firstParam = 23;
        this.seconParam = 32;
    }
    
    public int get_firstParam() {
        return this.firstParam;
    }
    
    public int get_secondParam() {
        return this.seconParam;
    }

    public void set_firstParam(int firstParam) {
        this.firstParam = firstParam;
    }

    public void set_secondParam(int secondParam) {
        this.seconParam = secondParam;
    }

}
