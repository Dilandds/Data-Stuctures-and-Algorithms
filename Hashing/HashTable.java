import java.util.*;

public class HashTable {
    private Entry[] entryList; //array to store entries
    private int capacity;       // capacity of the hash table (N)
    private int currentSize;    // current size of the hash table

    public HashTable(int capacity){ //constructor
        this.capacity = capacity;
        this.entryList = new Entry[capacity];
        this.currentSize = 0;
    }

    // clears the hash table
    public void clearAll(){
        currentSize = 0;
        this.entryList = new Entry[capacity];
    }

    // returns the current size of the hashtable
    public int getCurrentSize(){
        return this.currentSize;
    }

    // checks whether the hashtable is full
    public boolean isFull(){
        return this.currentSize == capacity;
    }

    // checks whether the hashtable is empty
    public boolean isEmpty(){
        return this.currentSize == 0;
    }
    //checks whether the key contains
    public boolean containKey(int key){
        return get(key)!=null;
    }

    // first hash function h(k) = k % N
    public int hash1(int key){
        return key % capacity;
    }

    // second hash function
    public int hash2(int key){
        return 1 + (key % (capacity - 1));
    }

 public void insert(int key, String value){

 	if(currentSize>capacity-1){ //when the hash table is full
 		System.out.println("Hash Table is full now!");
 		return ;
 	} 
 	if(key< 0){ //when the key is negative.. print a error message
 		System.out.println("Enter a positive value for key");
 		return ;
 	}
 	Entry entryToInsert = new Entry(key,value); //new object entry
 	int h1 =hash1(key);
 	int i=1;
 	while(entryList[h1] != null){
 		if(entryList[h1].getKey()==key){ //when trying to add same key
 			System.out.println("key "+key+" already exists\n");
			return;
		}
	h1 =  (h1+i * hash2(key))% capacity; //move to next hash
    i = i+1;
 	}
 	entryList[h1] = entryToInsert; //add the entry to final hash
 	currentSize = currentSize +1;
 }
 public Entry[] getEntryList(){ //get full entry list
 	return this.entryList;
 }

 public String get(int key){
 	int h1 = hash1(key);
 	int i=1;
 	Entry readEntry =entryList[h1];
 	while (entryList[h1] != null && (entryList[h1].getKey()!= key)){ //key not found
        h1 =  (h1+i * hash2(key))% capacity; //change the hash
        i = i+1;
        readEntry =entryList[h1]; //assing entry
    }
    if(entryList[h1] != null){ //get the value of key
	    return entryList[h1].getValue();
    }else{ //when key is not there
    	System.out.println("Serched key is not there");
    	return null;
    }
 }
 
 public void remove(int key){
 	if (!containKey(key)) return; //searched key is not there

 	int h1 = hash1(key);
    int i=1;

 	Entry readEntry =entryList[h1];
 	while (entryList[h1] != null && (entryList[h1].getKey()!= key)){
        h1 =  (h1+i * hash2(key))% capacity; //change hash
        i = i+1;
        readEntry =entryList[h1]; //assign entry
    }
    System.out.println("key "+key+" is deleted");
	entryList[h1]= null;
	currentSize--;
 }

 public void printList(){ //to print the whole list to entries
 	Arrays.stream(entryList).forEach(entry ->{
 		if(entry != null){
 			System.out.println("key :"+ entry.getKey()+ " value :" + entry.getValue() );
 		}
 	});


 }
 
}



