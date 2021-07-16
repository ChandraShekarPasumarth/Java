/*
Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.

 */
package com.Assignment3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Assignment3 {

    public void tester() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ip Address");
        String ipAddress=scanner.next();
        calaculateTime(ipAddress);
    }

    private void calaculateTime(String ipAddress) throws IOException {
        //Getting the current time in milli seconds
        long currentTime = System.currentTimeMillis();

        //getting the ip address with given input
        InetAddress address = InetAddress.getByName(ipAddress);

        System.out.println("Sending ping request to :" +ipAddress);

        if(address.isReachable(1000)){
            System.out.println("Host is up and running");

        }
        else{
            System.out.println("Host on is not reachable");
        }
        long timeTaken=System.currentTimeMillis()-currentTime;
        System.out.println("Time taken to ping the host: "+ ipAddress + " is "+timeTaken+" milliseconds" );


    }
}
class Main{
    public static void main(String[] args) throws IOException {
        //Object is created for the assignment class
        Assignment3 object = new Assignment3();
        //Calling the tester method by assignment3 class object
        object.tester();

    }
}
