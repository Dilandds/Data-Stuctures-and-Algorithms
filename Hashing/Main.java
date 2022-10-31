//E/17/379

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        HashTable hashTable1 = new HashTable(6);
        System.out.println("___________Testing open addressing Hashfunction______________");
        hashTable1.insert(4," Value is 34534");
        hashTable1.insert(10," Value is 3453"); //to test the collision handling with 4
         hashTable1.insert(12," Value is s34534");
         hashTable1.insert(12," Value is sssw"); //neglecting same key
        hashTable1.insert(21," Value is 1");
        hashTable1.insert(6," Value is 77"); //to test the collision  with 12
       hashTable1.insert(1," Value is 4534");
       hashTable1.insert(123," Value is 4534"); //**7th item**  Hash Table is full test

        

        hashTable1.printList(); //Printing the final list 123 is not there



        System.out.println("___________Testing get function______________"); //Testing get function
        System.out.println(hashTable1.get(4));
        System.out.println(hashTable1.get(1));

        System.out.println("_____________Testing Remove function____________"); //Testing Remove function
        hashTable1.remove(12);
        System.out.println(hashTable1.get(12));

        System.out.println("_____________Testing other functions____________");
        System.out.println(hashTable1.isFull());
        hashTable1.clearAll();
        System.out.println(hashTable1.isEmpty());



       System.out.println("_____________Testing Chained Hash Table____________");
       LinkedHashTable hashTable2 = new LinkedHashTable(4);
       //Entered the example in Lecture slide
       hashTable2.insert(5,"test value xx");
       hashTable2.insert(19,"test value xccc");
       hashTable2.insert(7,"test value asdasda");
       hashTable2.insert(12,"test value xadsdasd");
       hashTable2.insert(10,"test value eqw4wq");
       hashTable2.insert(8,"test value xwqeweqg");
       hashTable2.insert(28,"test value asdawe");
       hashTable2.insert(34,"test value tyertuy");

       hashTable2.printLinkedList();

       System.out.println("_____________Testing chained get function____________");
       System.out.println(hashTable2.get(5));
       System.out.println(hashTable2.get(7));

       System.out.println("_____________Testing chained remove function____________"); //Testing Remove function
       hashTable2.remove(12);
       System.out.println(hashTable2.get(12));

       System.out.println("_____________Testing other chained functions____________");
       System.out.println(hashTable2.isFull()); //each row has at least one item
       hashTable2.clearAll();
       System.out.println(hashTable2.isEmpty());





    }
}