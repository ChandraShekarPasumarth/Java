package com.Assignment12;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> list;
        list = new ArrayList<>();
        list.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        list.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        list.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        list.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        list.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        list.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        list.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        list.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        list.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        list.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        list.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        list.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        list.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        list.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        list.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        list.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        list.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        System.out.println("1. Print the name of all departments in the college");
        Student.task1(list);//1. Print the name of all departments in the college?
        System.out.println("2.Get the names of all students who have enrolled after 2018?");
        Student.task2(list);//2.Get the names of all students who have enrolled after 2018?
        System.out.println("3. Get the details of all male student in the computer sci department?");
        Student.task3(list);//3. Get the details of all male student in the computer sci department?
        System.out.println("4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)");
        Student.task4(list);
        System.out.println("5.What is the average age of male and female students");
        Student.task5(list);
        System.out.println("6.Get the details of highest student having highest percentage ");
        System.out.println(Student.task6(list).substring(8));
        System.out.println("7.Count the number of students in each department? (Hint :use Collectors.groupingBy())");
        Student.task7(list);
        System.out.println("8. What is the average percentage achieved in each department?");
        Student.task8(list);
        System.out.println("9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)");
        System.out.println(Student.task9(list));
        System.out.println("10.How many male and female students are there in the computer science department?");
        Student.task10(list);

    }
}