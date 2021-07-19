package com.company;

import static com.company.LinkedList.insert;
import static com.company.LinkedList.printList;

public class Main {
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list,6);
        list = insert(list, 7);
        list = insert(list, 8);
        printList(list);
        System.out.println();
        list.deleteByKey(list,2);
        System.out.println();
        printList(list);

    }
}
