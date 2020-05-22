package com.unitri.comp.ecommerce.model;

public class Singleton {

    private static String uniqueInstance = new String();

    private Singleton() {
    }

    public static String getInstance() {
        return uniqueInstance;
    }
}

