/*
Assignment
For this assignment, we are providing data on baby names from the United States and you will answer questions about this data. The data files give information on the first names of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names. You can download a .zip folder of all baby name data by clicking here.

For example, below are two pictures of parts of the  file "yob2014.csv", for names of babies born in 2014. On the left is the top of the file which shows that Emma is the most popular name, the F is for female and the 20799 indicates the number of Emma’s born in 2014. The file lists all the girls first, and they are listed in order based on the number of births, from largest numbers to smallest numbers. On the right is another snapshot of the file, showing the end of the girls and the start of the boys. You can see that Noah was the most popular boys name in 2014, the M indicates a male, and 19144 is the number of boys named Noah that year. Also notice there are no headers in this file. The video showed you how to access the fields in a .csv file when there are no headers.
Since these data files are quite large, we will also provide three small files with fake data for testing. We show the three files called "yob2012short.csv", "yob2013short.csv" and "yob2014short.csv" below in that order. The three files have only ten lines each, 5 girls and 5 boys names, and smaller numbers to work with. You can download a .zip folder of the shortened baby name data by clicking here.
You will write a program with several methods and tester methods to test each method you write. You should start with understanding the methods shown in the video. Specifically you should write the following methods.

Modify the method totalBirths (shown in the video for this project) to also print the number of girls names , the number of boys names and the total names in the file.
Write the method named getRank that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). This method returns the rank of the name in the file for the given gender,  where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.  For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’, the number returned is 2, as Mason is the boys name with the second highest number of births. Given the name Mason, the year 2012 and the gender ‘F’, the number returned is -1 as Mason does not appear with an F in that file.
Write the method named getName that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male). This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME”  is returned.
What would your name be if you were born in a different year? Write the void method named whatIsNameInYear that has four parameters: a string name, an integer named year representing the year that name was born,  an integer named newYear and a string named gender (F for female and M for male). This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name. If Isabella was born in 2014 instead, she would have been named Sophia, the third most popular girl's name that year. The output might look like this:
Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender (F for female and M for male). This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. If the name and gender are not in any of the selected files, it should return -1. For example, calling yearOfHighestRank with name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012. That is because Mason was ranked the  2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.
Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. It should return -1.0 if the name is not ranked in any of the selected files. For example calling getAverageRank with name Mason and gender ‘M’ and selecting the three test files above results in returning 3.0, as he is rank 2 in the year 2012, rank 4 in 2013 and rank 3 in 2014.  As another example, calling   getAverageRank with name Jacob and gender ‘M’ and selecting the three test files above results in returning 2.66.
Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name. For example, if getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to “Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.

 */
package com.Assignment1;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirth {

    public void printNames(FileResource fr) {
        fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data/yob2014.csv");
        totalBirths(fr);
    }
    public long getRank(int year, String name, String gender)
    {

        int total=-1;
        //int numBoys=0,numGirls=0;
        FileResource fr = new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false))
        {

            if(rec.get(1).equals(gender))
            {
                total+=1;
                if(rec.get(0).equals(name))
                {
                    System.out.println("Rank is"+total);
                    break;
                }


            }
        }
        return total;
    }

    public String getName(int year, int rank, String gender) {
        String name = "";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord record : parser) {
            long currRank = record.getRecordNumber();
            String currGender = record.get(1);
            String currName = record.get(0);

            if(currRank == rank && currGender.equals(gender)) {
                name = currName;
            }
        }

        if(name != "") {
            return name;
        }
        else {
            return "NO NAME";
        }
    }
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        FileResource fr = new FileResource();
        FileResource newFr = new FileResource();
        CSVParser parserOld = fr.getCSVParser(false);
        CSVParser parserNew = newFr.getCSVParser(false);
        String newName = "";
        long popularity = 0;

        for(CSVRecord record : parserOld) {
            String currName = record.get(0);
            String currGender = record.get(1);

            if(currName.equals(name) && currGender.equals(gender)) {
                popularity = record.getRecordNumber();
            }
        }

        for(CSVRecord record : parserNew) {
            String currGender = record.get(1);
            long currPopularity = record.getRecordNumber();

            if(currGender.equals(gender) && popularity == currPopularity) {
                newName = record.get(0);
            }
        }

        System.out.println(name + " born in " + year + " would be " + newName + " if he/she was born in " + newYear);
    }

    public String yearOfHighestRank(String name, String gender) {
        long highestRank = 0;
        int yearOfHighestRank = -1;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);
                if(currName.equals(name) && currGender.equals(gender)) {
                    long currRank = record.getRecordNumber();
                    if(highestRank == 0) {
                        highestRank = currRank;
                        fileName = f.getName();
                    }
                    else {
                        if(highestRank > currRank) {
                            highestRank = currRank;
                            fileName = f.getName();
                        }
                    }
                }
            }
        }

        return fileName;
    }



    /*
     * This method returns the average rank of a name in multiple files
     */
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double rankTotal = 0.0;
        int howMany = 0;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);
                if(currName.equals(name) && currGender.equals(gender)){
                    long currRank = record.getRecordNumber();
                    rankTotal += (double)currRank;
                    howMany += 1;
                }
            }
        }
        double avgRank = rankTotal / (double)howMany;
        return avgRank;
    }


    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int numBorn = 0;
        long rank = getRank(year, name, gender);
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser) {
            int currBorn = Integer.parseInt(record.get(2));
            String currGender = record.get(1);
            long currRank = record.getRecordNumber();
            if(gender.equals(currGender) && rank > currRank) {
                numBorn += currBorn;
            }
        }
        return numBorn;
    }

    public void testing()
    {
        FileResource fr=new FileResource();
        printNames(fr);
        totalBirths(fr);
        getRank(1997,"Mason","M");
        getName(1997,5,"M");
        whatIsNameInYear("Manson",1997,2005,"M");
        System.out.println(yearOfHighestRank("Manson","M"));
        System.out.println(getAverageRank("Elgin","M"));
        System.out.println(getTotalBirthsRankedHigher(2000,"Erick","M"));

    }
}
class Main{
    public static void main(String args[]){
        BabyBirth object=new BabyBirth();
        object.testing();
    }
}
