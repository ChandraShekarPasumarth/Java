package com.Assignment9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asssignment9 {
    public void tester() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the inputa");
        String input = scanner.nextLine();

        String regex="^[A-Z][A-Z a-z 0-9_!@#\\S%\\^\\)\\(+=.\\s+]*[.]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println("Pattern Matched");
        }
        else
            System.out.println("Pattern not found");

    }
}
class Main{
    public static void main(String args[]){
        Asssignment9 object=new Asssignment9();
        object.tester();
    }
}