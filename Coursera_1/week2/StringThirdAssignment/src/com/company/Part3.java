package com.company;
import edu.duke.*;
import java.io.*;
public class Part3 {


    public void testProcessGenes() {

        StorageResource sr=new StorageResource();
        sr.add("ATGCCATAG");
        sr.add("ATGTAGTGATAA");
        sr.add("ATTATGTAA");
        ProcessGenes(sr);
        
    }

    private void ProcessGenes(StorageResource sr) {
        StorageResource resource=new StorageResource(sr);
        int longerStringCount=0;
        int higherCg=0;
        int longestGene=0;
        float cgCount= 0.0F;
        for(String s:resource.data()){
            if(s.length()>9){
                System.out.println("String length greater than 9 characters"+s);
                longerStringCount = longerStringCount + 1;
            }
             cgCount= countCTG(s);
            if(cgCount>0.35) {
                higherCg++;
                System.out.println(s);
            }
            if(s.length()>longestGene){
                longestGene=s.length();
            }

        }
        System.out.println("Total count of strings greater than 9 are "+longerStringCount);
        System.out.println("Total count of strings whose cg is greater than 0.35 are " +higherCg);
        System.out.println("Longest gene in storage source is "+longestGene);
    }
    private float countCTG(String dna){
        int count=0;
        for( int i=0;i<dna.length();i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                count++;
            }
        }
        final float v = (float) count / dna.length();
        return v;
    }

}
