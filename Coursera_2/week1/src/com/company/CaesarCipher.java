/*
Assignment 2: Caesar Cipher
You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.

Specifically, you should do the following:

Create a new class called CaesarCipher.
Write the method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call
        encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

    should return the string

        “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”

Write the void method testCaesar that has no parameters. This method should read a file and encrypt the complete file using the Caesar Cipher algorithm, printing the encrypted message. You may want to include the lines:
Modify the encrypt method to be able to handle both uppercase and lowercase letters. For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”.  Be sure to test the encrypt method.
Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method. 
 */
package com.company;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CaesarCipher {
    public void tester() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;

        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);

        int key2=17;

        String encrypted2=encryptTwoKeys(message,key,key2);
        System.out.println("Key1 is "+ key +" Key2 is "+key2 +"\n"+encrypted2);



    }

    private String encryptTwoKeys(String input, int key1, int key2) {
        String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String aplhabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder encrypt_two = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (i % 2 == 0) {
                if (curr >= 'A' && curr <= 'Z') {
                    int index = (curr - 'A' + key1) % 26;
                    encrypt_two.append(Alphabets.charAt(index));
                } else if (curr >= 'a' && curr <= 'z') {
                    int index = (curr - 'a' + key1) % 26;
                    encrypt_two.append(aplhabets.charAt(index));
                } else
                    encrypt_two.append(" ");
            } else {
                if (curr >= 'A' && curr <= 'Z') {
                    int index = (curr - 'A' + key2) % 26;
                    encrypt_two.append(Alphabets.charAt(index));
                } else if (curr >= 'a' && curr <= 'z') {
                    int index = (curr - 'a' + key2) % 26;
                    encrypt_two.append(aplhabets.charAt(index));
                } else
                    encrypt_two.append(" ");
            }
        }
        return encrypt_two.toString();
    }

    public String encrypt(String input,int key){
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr >= 'A' && curr <= 'Z') {
                int index = (curr - 'A' + key) % 26;
                encrypt.append(Alphabet.charAt(index));
            } else if (curr >= 'a' && curr <= 'z') {
                int index = (curr - 'a' + key) % 26;
                encrypt.append(alphabets.charAt(index));
            } else
                encrypt.append(" ");
        }
        return encrypt.toString();
    }

}
