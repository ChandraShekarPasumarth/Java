/*
Error Handling

Create three new types of exceptions. Write a class with a method that throws all three. In main( ), call the method but only use a single catch clause that will catch all three types of exceptions. Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
 */
package com.Assignment8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            run();
        }
        catch (Exception exception){
            System.out.println("Execution caught is : "+ exception.getMessage());
        }
        finally {
            System.out.println("This finally block is execute must and most");
        }
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        int firstnumber = scanner.nextInt();
        int secondnumber = scanner.nextInt();
        int answer = firstnumber/secondnumber;//cannot divide by zero

        int[] arr = new int[3];
        for(int pointer=0;pointer<3;pointer++)
            arr[pointer]=pointer;

        //System.out.println(arr[5]);//ArrayIndexOutOfBounds

        Main main = new Main();
        main=null;
        main.call();//Null Pointer Execption
    }

    private void call() {
        System.out.println("Calling......");
    }

}