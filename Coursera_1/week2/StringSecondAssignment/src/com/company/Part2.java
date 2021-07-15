package com.Assignment1;

public class Part2 {
    public int howMany(String stringa, String stringb){
        int totalOccurences=0;
        int start=0;
        while(true) {
            int index = stringb.indexOf(stringa, start);
            if (index != -1) {
                totalOccurences++;
                start = index + stringa.length();
            } else {
                break;
            }
        }
        return totalOccurences;
    }
    public void testHowMany(){
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));

        stringa = "AA";
        stringb = "ATAAAA";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));

    }
}
