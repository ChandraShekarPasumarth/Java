package com.Assignment6;

public class Overloading {
    Overloading(){
        new Overloading(2);
    }
    Overloading(int value){
        System.out.println("Default construtor called another constructor with value "+value);
    }
}
