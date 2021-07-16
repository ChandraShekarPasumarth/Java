package com.Assignment6;

public class Main {
    public static void main(String[] args){
        System.out.println("Task1");
        Vampire vampire=new Vampire();
        vampire.printVampireNumbers();

        System.out.println("Task2");
        Overloading overloading = new Overloading();

        System.out.println("Task3");
        Verify arr[]=new Verify[3];
        for(int i=0;i<3;i++){
            arr[i]=new Verify("Message");
        }


    }
}
