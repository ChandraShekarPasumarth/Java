/*
Create a java program to search through the home directory and look for files that match a regular expression. The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
 */
package com.Assignment1;

import java.io.File;
import java.util.Scanner;

public class Assignment1 {

    public void findFile() {
        File file = new File("/home/chansp/Downloads");
        //string to store the name of the file
        String str ;
        //  Scanner is declare
        Scanner in = new Scanner(System.in);
        // do while is used to run the program again and again
        do{
            int ab =0;
            System.out.println("ENTER THE NAME OF FILE OR FOLDER");
            //take input
            str =in.nextLine();
            //list of file is stored in string
            String[] files = file.list();
            //continous check each file or folder
            for (String string : files){
                //check the name of file present or not and store in boolean str1
                Boolean str1 = str.equals(string);
                // str1 is true than print the following
                if (str1){
                    ab = 1;
                    System.out.println("File Found : ");
                    System.out.println(string);
                    //print the address of the file
                    System.out.println("Path : "+ file.getAbsolutePath());
                }
            }
            //if file not found
            if(ab == 0)
            {
                System.out.println("File not find : Reenter the name of the file.");
            }
        } while(true);
    }
}

class Main {

    public static void main(String[] args) {
        // Object of Assignment1 class is created
        Assignment1 object=new Assignment1();
        //After Instatiating the objec of the assignment class , find File is called.
        object.findFile();

    }
}
