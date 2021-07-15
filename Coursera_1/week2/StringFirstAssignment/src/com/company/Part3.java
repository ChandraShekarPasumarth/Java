package com.Assignment1;

public class Part3 {
    public boolean twoOccurrences(String stringa , String stringb ){
        int firstIndex=stringb.indexOf(stringa);
        int lastIndex=stringb.lastIndexOf(stringa);
        if(firstIndex != lastIndex)
            return true;
        else
            return false;
    }
    public void testing(){
        String stringa="by";
        String stringb="A story by Abby Long";
        System.out.println(stringa+" appears at least twice in  "+ stringb +"="+twoOccurrences(stringa,stringb));

        stringa="a";
        stringb="banana";
        System.out.println(stringa+" appears at least twice in "+ stringb +"="+twoOccurrences(stringa,stringb));

        stringa="atg";
        stringb="ctgtatgta";
        System.out.println(stringa+" appears at least twice in  "+ stringb +"="+twoOccurrences(stringa,stringb));

        stringa="an";
        stringb="banana";
        System.out.println("The last part of "+ stringa +" in " +stringb +" is " +lastPart(stringa,stringb));

        stringa="zoo";
        stringb="forest";
        System.out.println("The last part of "+ stringa +" in " +stringb +" is " +lastPart(stringa,stringb));

    }
    public String lastPart(String stringa, String stringb){
        int index=stringb.indexOf(stringa);

        if(index==-1)
            return stringb;
        else {
            return stringb.substring(index+stringa.length());
        }


    }
}
