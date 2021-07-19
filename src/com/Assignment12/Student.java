package com.Assignment12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int year_of_enrollment;
    private double perTillDate;

    Student(int id, String name, int age, String gender, String engDepartment, int year_of_enrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.year_of_enrollment = year_of_enrollment;
        this.perTillDate = perTillDate;
    }

    public static void task1(ArrayList<Student> list){
        list.stream().map(x->x.engDepartment).distinct().forEach(System.out::println);
    }

    public static void task2(ArrayList<Student> list) {
        list.stream().filter(x->x.year_of_enrollment>2018).forEach(x->System.out.println(x.name));
    }

    public static void task3(ArrayList<Student> list) {
        list.stream().filter(x->x.engDepartment=="Computer Science" && x.gender=="Male").forEach(x->System.out.println(x.name));
    }

    public static void task4(ArrayList<Student> list) {
        list.stream().collect(groupingBy(Student::getGender)).forEach((x,y)-> System.out.println("Count of "+x+" is "+y.size()));
    }

    public static void task5(ArrayList<Student> list) {
        list.stream().collect(groupingBy(Student::getGender,averagingInt(Student::getAge))).forEach((x,y)-> System.out.println("Average age of "+ x +" is "+y));
    }

    public static String task6(ArrayList<Student> list) {
        return list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Student :: getMarks))).toString();
    }

    public static void task7(ArrayList<Student> list) {
        list.stream()
                .collect(groupingBy(Student::getDept))
                .forEach((x, y) -> System.out.println("Count of " + x + " is " + y.size()));
    }

    public static void task8(ArrayList<Student> list) {
        list.stream()
                .collect(groupingBy(Student::getDept, averagingDouble(Student::getMarks)))
                .forEach((x, y) -> System.out.println("average percentage of " + x + " is " + y));
    }

    public static String task9(ArrayList<Student> list) {
        return list.stream()
                .filter(x -> x.gender.equals("Male"))
                .filter(x -> x.engDepartment.equalsIgnoreCase("Electronic"))
                .collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))).toString();
    }

    public static void task10(ArrayList<Student> list) {
        list.stream()
                .filter(x -> x.engDepartment.equalsIgnoreCase("computer science"))
                .collect(Collectors.groupingBy(Student::getGender))
                .forEach((x, y) -> System.out.println("No of " + x + " in Computer Science is " + y.size()));
    }
    public double getMarks() {
        return this.perTillDate;
    }

    public String toString() {
        return this.name + " " + this.engDepartment + " " + this.age + " " + this.gender;
    }

    public String getName() {
        return this.name;
    }

    private String getDept() {
        return this.engDepartment;
    }

    private  int getAge( ) {
        return  this.age;
    }

    private String getGender() {
        return this.gender;
    }
}