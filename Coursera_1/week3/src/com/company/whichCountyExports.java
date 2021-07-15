package com.Assignment1;
import edu.duke.*;
import org.apache.commons.csv.*;

public class whichCountyExports {
    public void tester() {
        FileResource fr = new FileResource();
        org.apache.commons.csv.CSVParser parser=fr.getCSVParser();
        System.out.println(countryInfo(parser,"germany"));
        String exportItem1="gold";
        String exportItem2="diamonds";
        parser=fr.getCSVParser();
        System.out.println("The countries exports "+exportItem1 +" and "+exportItem2+" are :"+" ");
        listExportersTwoProducts(parser,exportItem1,exportItem2);
        String exportItem="gold";
        System.out.print("Number of exporters  "+exportItem+" are :");
        parser=fr.getCSVParser();
        numberOfExporters(parser,exportItem);
        parser=fr.getCSVParser();
        System.out.println("Big Exporters :");
        bigExporters(parser,"$999,999,999");


    }

    private void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record:parser){
            String currAmount = record.get("Value (dollars)");
            if(currAmount.length() > amount.length()){
                String country=record.get("Country");
                System.out.println(country+" "+currAmount);
            }
        }
        return;
    }

    private void numberOfExporters(CSVParser parser, String exportItem) {
        int totalCountry=0;
        for(CSVRecord record:parser){
            String exports=record.get("Exports");
            if(exports.contains(exportItem)){
                totalCountry++;
            }
        }
        System.out.println(totalCountry);
    }

    private void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record:parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                String country=record.get("Country");
                System.out.println(country);
            }
        }
    }

    private String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record: parser){
            String currCountry= record.get("Country");
            if(currCountry.equalsIgnoreCase(country)){
                String exports=record.get("Exports");
                String value = record.get("Value (dollars)");

                String result = currCountry + ": " + exports + ": " + value;
                return result;
            }
        }
        return "NOT FOUND";

    }


}

class Main{
    public static void main(String args[]){
        whichCountyExports object=new whichCountyExports();
        object.tester();

    }
}
