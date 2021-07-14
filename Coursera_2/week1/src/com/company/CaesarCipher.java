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
