package com.Assignment6;

import java.util.Arrays;

public class Vampire {
    final static int START = 11, END = 1000;
    public void printVampireNumbers() {
        char[] kChar, checkChar;
        String kStr, checkStr;
        int k;
        for(int i=START; i<END; i++) {
            for(int i1=i; i1<100; i1++) {

                k = i * i1;

                kStr = Integer.toString(k);
                checkStr = Integer.toString(i) + Integer.toString(i1);


                kChar = kStr.toCharArray();
                checkChar = checkStr.toCharArray();

                Arrays.sort(kChar);
                Arrays.sort(checkChar);

                if(Arrays.equals(kChar, checkChar) ) {
                    System.out.println(i + " * " + i1 + " = " + k);
                }
            }
        }

    }
}
