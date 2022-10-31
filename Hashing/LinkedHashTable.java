import java.util.*;

public class LinkedHashTable{
	private LinkedList <Entry>[] linkedEntryList; //Entry type linked list
	private int capacity;
	private int currentSize; //number of current Linked lists

	public LinkedHashTable(int capacity){
		this.capacity = capacity;
		this.currentSize=0;
		linkedEntryList = new LinkedList [capacity]; //consturucting the head colomn 
		for( int i=0; i<capacity; i++){
			linkedEntryList[i] = new LinkedList<Entry>(); //constructing row linked lists
		}
	}
	// first hash function h(k) = k % N
	public int hash(int key){
        return key % capacity;
    }
    //check whether key exists on table
    public boolean containKey(int key){
        return get(key)!=null;
    }
    //chech whether table is empty
    public boolean isEmpty(){
        return this.currentSize == 0;
    }
    //cleaing hash table 
    public void clearAll(){
        currentSize = 0;
        this.linkedEntryList = new LinkedList[capacity];
    }
    // returns the current size of the hashtable
    public int getCurrentSize(){
        return this.currentSize;
    }
     // checks whether the all the rows have at least one value ( head colomn is full)
    public boolean isFull(){
        return this.currentSize == capacity;
    }
    // checks whether the hashtable is empty
   

	public void insert(int key, String value){
		if (containKey(key)) { //whe key already exists
            System.out.println("Key "+ key + " is already available!");
            return;
        }
		if(key< 0){ //error for negative keys
 		    System.out.println("Enter a positive value for key");
 		return ;
 	    }
		Entry entryToInsert = new Entry(key,value); //New entry object
		int h =hash(key);
		if(linkedEntryList[h].isEmpty()) currentSize++; //if the Entry is adding in to a empty linked list then make a count

		linkedEntryList[h].add(entryToInsert);    //add the rentry to the releavent linked list according to the hash value
	}
    public String get(int key){
    	if(key< 0){ //error for negative search key
 		    System.out.println("Enter a positive value for key");
 		    return null;
 	    }
        int h = hash(key);
        LinkedList<Entry> row = linkedEntryList[h]; //get the relevant linked list according to the hash value, to row

        for (Entry item : row){ //Iterate through row linked list
            if (item.getKey() == key) return item.getValue(); //when the key matches return the value
        }
        System.out.println("Searched key is not there"); //when key is not there
        return null;
    }
    public void remove(int key){
    	 
        int h = hash(key);
        LinkedList<Entry> row = linkedEntryList[h]; //get the relevant linked list according to the hash value, to row

        for (Entry item : row){ //Iterate through row
            if (item.getKey() == key){
                System.out.println("Removed "+ key); //when key font in a item
                row.remove(item); //remove it
                if (linkedEntryList[h].isEmpty()) --currentSize; //if a whole row is empty reduce size count by one
                return;
            }
        }
        System.out.println("Key "+ key + " is not available!");//searched key is not there
    }
    public void printLinkedList(){  //print the whole hash table row by row
    	int i;
    	for(i=0; i<capacity;i++){
    		System.out.println("ROW" + i);
    		LinkedList<Entry> row = linkedEntryList[i];
    		for (Entry item : row){
            if (item != null){
                System.out.println("key "+ item.getKey() + " Value ="+ item.getValue());
            }
        }
        System.out.println("______________________");

    	}
    }

}