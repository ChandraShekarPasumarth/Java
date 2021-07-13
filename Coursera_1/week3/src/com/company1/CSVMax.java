/*

Assignment
You will write a program to find the coldest day of the year and other interesting facts about the temperature and humidity in a day. To test your program, you will use the nc_weather data folder that has a folder for each year; you can download a .zip folder with these files by clicking here. In the year folder there is a CSV file for every day of the year; each file has the following information. For example, in the 2014 folder, we show parts of the file weather-2014-01-08.csv, the weather data from January 8, 2014.

You will write a program with several methods and  tester methods to test each method you write. You should start with the methods from the lesson to find the hottest temperature in a day (and thus in a file) and the hottest temperature in many files and their tester methods. You can use these to write similar methods to find the coldest temperatures.
Specifically you should write the following methods.

1. Write a method named coldestHourInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. You should also write a void method named testColdestHourInFile() to test this method and print out information about that coldest temperature, such as the time of its occurrence.

NOTE: Sometimes there was not a valid reading at a specific hour, so the temperature field says -9999. You should ignore these bogus temperature values when calculating the lowest temperature.



2. Write the method fileWithColdestTemperature that has no parameters. This method should return a string that is the name of the file from selected files that has the coldest temperature. You should also write a void method named testFileWithColdestTemperature() to test this method. Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day. When fileWithColdestTemperature runs and selects the files for January 1–3 in 2014, the method should print out
3. Write a method named lowestHumidityInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.

Note that sometimes there is not a number in the Humidity column but instead there is the string “N/A”. This only happens very rarely. You should check to make sure the value you get is not “N/A” before converting it to a number.

Also note that the header for the time is either TimeEST or TimeEDT, depending on the time of year. You will instead use the DateUTC field at the right end of the data file to  get both the date and time of a temperature reading.

You should also write a void method named testLowestHumidityInFile() to test this method that starts with these lines:
FileResource fr = new FileResource();
CSVParser parser = fr.getCSVParser();
CSVRecord csv = lowestHumidityInFile(parser);
and then prints the lowest humidity AND the time the lowest humidity occurred. For example, for the file weather-2014-01-20.csv, the output should be:
Lowest Humidity was 24 at 2014-01-20 19:51:00
NOTE: If you look at the data for January 20, 2014, you will note that the Humidity was also 24 at 3:51pm, but you are supposed to return the first such record that was found.

4. Write the method lowestHumidityInManyFiles that has no parameters. This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. You should also write a void method named testLowestHumidityInManyFiles() to test this method and to print the lowest humidity AND the time the lowest humidity occurred. Be sure to test this method on two files so you can check if it is working correctly. If you run this program and select the files for January 19, 2014 and January 20, 2014, you should get
Lowest Humidity was 24 at 2014-01-20 19:51:00

5. Write the method averageTemperatureInFile that has one parameter, a CSVParser named parser. This method returns a double that represents the average temperature in the file. You should also write a void method named testAverageTemperatureInFile() to test this method. When this method runs and selects the file for January 20, 2014, the method should print out
Average temperature in file is 44.93333333333334

6. Write the method averageTemperatureWithHighHumidityInFile that has two parameters, a CSVParser named parser and an integer named value. This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. You should also write a void method named testAverageTemperatureWithHighHumidityInFile() to test this method. When this method runs checking for humidity greater than or equal to 80 and selects the file for January 20, 2014, the method should print out
No temperatures with that humidity

If you run the method checking for humidity greater than or equal to 80 and select the file March 20, 2014, a wetter day, the method should print out

Average Temp when high Humidity is 41.78666666666667

 */
package com.company1;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    private static String TEMPERATURE_COLUMN = "TemperatureF";
    private static String DATE_COLUMN = "DateUTC";
    private static String HUMIDITY_COLUMN = "Humidity";

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestRecord = null;

        for (CSVRecord record : parser) {
            double temperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

            if (coldestRecord == null && temperature != -9999) {
                coldestRecord = record;
            } else {
                double coldestTemperature = Double.parseDouble(coldestRecord.get(TEMPERATURE_COLUMN));

                if (temperature < coldestTemperature && temperature != -9999) {
                    coldestRecord = record;
                }
            }
        }

        return coldestRecord;
    }

    public File fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        File file = null;
        CSVRecord coldestRecord = null;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = coldestHourInFile(fr.getCSVParser());

            if (coldestRecord == null) {
                coldestRecord = currentRecord;
                file = f;
            } else {
                double coldestTemperature = Double.parseDouble(coldestRecord.get(TEMPERATURE_COLUMN));
                double currentTemperature = Double.parseDouble(currentRecord.get(TEMPERATURE_COLUMN));

                if (currentTemperature < coldestTemperature) {
                    coldestRecord = currentRecord;
                    file = f;
                }
            }
        }

        return file;
    }

    public void printAllRecordsInFile(CSVParser parser) {
        for (CSVRecord record : parser) {
            System.out.println(record.get(DATE_COLUMN) + " " + record.get(TEMPERATURE_COLUMN));
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;

        for (CSVRecord record : parser) {
            String humidityStr = record.get(HUMIDITY_COLUMN);

            if (!humidityStr.equals("N/A")) {
                int humidity = Integer.parseInt(humidityStr);

                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = record;
                } else {
                    int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HUMIDITY_COLUMN));

                    if (humidity < lowestHumidity) {
                        lowestHumidityRecord = record;
                    }
                }
            }
        }

        return lowestHumidityRecord;
    }


    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());

            if (lowestHumidityRecord == null) {
                lowestHumidityRecord = currentRecord;
            } else {
                int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HUMIDITY_COLUMN));
                int currentHumidity = Integer.parseInt(currentRecord.get(HUMIDITY_COLUMN));

                if (currentHumidity < lowestHumidity) {
                    lowestHumidityRecord = currentRecord;
                }
            }
        }

        return lowestHumidityRecord;
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemperature = 0;
        int recordCount = 0;

        for (CSVRecord record : parser) {
            double currentTemperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

            if (currentTemperature != -9999) {
                totalTemperature += currentTemperature;
                recordCount++;
            }

        }

        return totalTemperature / recordCount;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemperature = 0;
        int recordCount = 0;

        for (CSVRecord record : parser) {
            int currentHumidity = Integer.parseInt(record.get(HUMIDITY_COLUMN));

            if (currentHumidity >= value) {
                double currentTemperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

                if (currentTemperature != -9999) {
                    totalTemperature += currentTemperature;
                    recordCount++;
                }
            }
        }

        if (recordCount == 0) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return totalTemperature / recordCount;
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        CSVRecord coldestRecord = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + coldestRecord.get(TEMPERATURE_COLUMN) + " at " + coldestRecord.get(DATE_COLUMN));

        File file = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + file.getName());

        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get(HUMIDITY_COLUMN) + " at " + lowestHumidityRecord.get(DATE_COLUMN));

        CSVRecord lowestHumidityRecordInManyFile= lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityRecordInManyFile.get(HUMIDITY_COLUMN) + " at " + lowestHumidityRecordInManyFile.get(DATE_COLUMN));

        double averageTemperature = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperature);

        double averageTemperatureWithHighHumidityInFile = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);

        if (averageTemperatureWithHighHumidityInFile == Double.NEGATIVE_INFINITY) {
            System.out.println("No temperature with that humidity");
        } else {
            System.out.println("Average temperature when high humidity is " + averageTemperatureWithHighHumidityInFile);
        }
    }
}
class Main{
    public static void main(String args[]){
        CSVMax object = new CSVMax();
        object.tester();
    }
}