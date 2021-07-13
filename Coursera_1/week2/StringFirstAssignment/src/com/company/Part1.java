package com.company;
//@author Duke Software Team
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna){
        String result="Not Valid Gene";
        int startIndex=dna.indexOf("ATG");
        int stopIndex=dna.indexOf("TAA",startIndex+3);
        if(startIndex == -1 || stopIndex == -1) {
            return result;
        }
        if((stopIndex - startIndex)%3 == 0 ){
            result=dna.substring(startIndex,stopIndex);

        }
        return result;
    }
    public void testSimpleGene(){
        String dna = "ATCTAACATC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));

        dna = "ATTATCATGTTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));

        dna = "ATTAGTGTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));

        dna = "GAAATGGATAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));

        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
    }

}
class Main{
    public static void main(String args[]){
        System.out.println("part 1");
        Part1 object = new Part1();
        object.testSimpleGene();
        System.out.println("");

        System.out.println("part 2");
        Part2 object2=new Part2();
        object2.testSimpleGene();

        System.out.println("part 3");
        Part3 object3=new Part3();
        object3.testing();

        System.out.println("part 4");
        Part4 object4=new Part4();
        object4.test();






    }
}