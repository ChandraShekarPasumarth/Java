/*
I/O

Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument and counts the occurrence of all the different characters. Save the results in a text file.
*/
package com.Assignment11;

import java.io.*;
import java.util.HashMap;

public class Main {
    static HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/chansp/Documents/JAVA/src/com/Assignment11/input.txt"));
        String input = bufferedReader.readLine();
        while(input!=null){
            countCharacters(input);
            input=bufferedReader.readLine();
        }
        writeToFile();
    }

    private static void writeToFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/chansp/Documents/JAVA/src/com/Assignment11/output.txt"));
        for(Character c:counter.keySet()){
            bufferedWriter.append(c+" "+counter.get(c));
            bufferedWriter.append("\n");
        }
        bufferedWriter.close();
    }

    private static void countCharacters(String input) {
        for(Character c:input.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }
    }
}