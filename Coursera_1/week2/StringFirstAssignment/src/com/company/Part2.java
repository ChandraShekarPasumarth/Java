package com.Assignment1;

public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon){
        String result="Not Valid Gene";
        int startIndex = dna.toUpperCase().indexOf(startCodon);
        int stopIndex = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);
        if(startIndex == -1 || stopIndex == -1) {
            return result;
        }
        if((stopIndex - startIndex)%3 == 0 ){
            result=dna.substring(startIndex,stopIndex);

        }
        return result;
    }
    public void testSimpleGene(){
        String startCodon="ATG";
        String stopCodon="TAA";

        String dna = "ATCTAACATC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna,startCodon,stopCodon));

        dna = "ATTATCATGTTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " +findSimpleGene(dna,startCodon,stopCodon));

        dna = "ATTAGTGTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna,startCodon,stopCodon));

        dna = "GAAATGGATAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna,startCodon,stopCodon));

        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna,startCodon,stopCodon));
    }

}
