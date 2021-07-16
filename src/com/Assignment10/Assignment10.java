/*Generics, Arrays and Containers

Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
*/
package com.Assignment10;

import java.util.Iterator;
import java.util.LinkedList;

public class Assignment10 {
    public void tester() {
        //Creating the linked list of type of string
        LinkedList<String>Slist=new LinkedList<>();

        //iterating over the loop to insert the values
        for(int counter=0;counter<=10;counter++) {
            Slist.add("String" + counter);
        }

        //Printing the linked list

        System.out.println("Elements in linked list"+ Slist);
        
        //Removing the elements

        Slist.remove("String5");
        Slist.removeFirst();
        Slist.removeLast();
        //iterator is used to traverse the linked list
        
        Iterator listIterator=  Slist.iterator();
        
        //Loop over the list to print the elements in the list.
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }
}
class Main{
    public static void main(String[] args){
        Assignment10 object = new Assignment10();
        object.tester();
    }
}
