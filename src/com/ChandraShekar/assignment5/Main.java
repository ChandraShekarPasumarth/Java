package com.ChandraShekar.assignment5;

import com.ChandraShekar.assignment5.Singleton.Demo;
import com.ChandraShekar.assignment5.data.DefaultInit;

import java.util.Scanner;


class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string :");
            Demo obj = Demo.getObject(sc.next());
            obj.print();
            System.out.println();
            DefaultInit defaultinit = new DefaultInit();
            defaultinit.display();
            defaultinit.methodDefault();
        }
    }
    

