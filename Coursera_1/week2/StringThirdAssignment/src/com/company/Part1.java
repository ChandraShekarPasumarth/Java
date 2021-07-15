package com.Assignment1;
import edu.duke.*;
import java.io.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;

        while(true) {
            index = dna.indexOf(stopCodon, startIndex + 3);

            if (index == -1 || (index - startIndex) % 3 == 0) {
                break;
            }

            startIndex += 3;
        }

        if (index != -1) {
            return index;
        } else {
            return dna.length();
        }
    }

    public void testFindStopCodon() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";

        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 9, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 1, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 0, "TAG");
        System.out.println("Index = " + index);
    }

    public String findGene(String dna, int start) {
        final String START_CODON = "ATG";
        int startIndex = dna.indexOf(START_CODON, start);

        if (startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));

        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public void testFindGene() {
        String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
        System.out.println("Gene: " + findGene(dna, 0));
    }

    public void printAllGenes(String dna) {
        int start = 0;

        while (true) {
            String gene = findGene(dna, start);

            if (gene.isEmpty()) {
                break;
            }

            System.out.println("Gene: " + gene);

            start = dna.indexOf(gene, start) + gene.length();
        }
    }
    public StorageResource getAllGenes(String dna){
        StorageResource sr=new StorageResource();
        int start=0;
        while(true){
            String gene=findGene(dna,start);
            if(gene.isEmpty()){
                break;
            }
            sr.add(gene);
            start = dna.indexOf(gene,start) + gene.length();
        }
        final StorageResource sr1 = sr;
        return sr1;
    }

    public void testPrintAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }
    public void testGetAllGenes(){
        String dna="ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource allGenes = getAllGenes(dna);
        for(String s:allGenes.data()){
            System.out.println(s);
        }
    }



}
class Main{
    public static void main(String args[]){
        Part1 object=new Part1();
        System.out.println("Part1");
        object.testGetAllGenes();

        Part2 object2=new Part2();
        System.out.println("Part2");
        object2.testCTG();

        Part3 object3=new Part3();
        System.out.println("Part3");
        object3.testProcessGenes();

    }
}
