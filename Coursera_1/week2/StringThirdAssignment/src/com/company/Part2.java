package com.company;

public class Part2 {
    public void testCTG(){
        String dna="ATGCCATAG";
        float count;
        count = countCTG(dna);
        System.out.println(count);


    }

    private float countCTG(String dna) {
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
