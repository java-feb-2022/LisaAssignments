package com.demo.interfaces;

public interface ACPowerable {
	//member variables - any classes using this will have this, it's a contract of things a class needs to have if they're implmenting this interface. 
    Integer voltage = 120;
    Integer frequency = 60;
    
    // lists requirements, no implementations, not defined, just declared. If you have electronics that are ACPowerable, they are required to implement these two. 
    abstract void unPlug();
    abstract boolean checkPluggedIn();
    
    //default method part of the ACPowerable, it's implemented below. If the class is implementing this interface and doesn't have this method it's fine.
    public default void hasPower() {
        String message = "The device is ";
        if(!checkPluggedIn()) {
            message += "not ";
        }
        System.out.println(message + "plugged in.");
    }
    
}
