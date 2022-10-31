/**
 * Simple sorting algorithms and their performance 
 * Reg: E/17/379
 *
 */

public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  { //without optimization

		for(int i=0 ; i<data.length ;i++){
			for(int j=0 ; j<data.length-1 ;j++){

				if(data[j] > data[j+1]){ //if 

					swap(data, j , j+1);	

				}
			}
		}
    }

    static void selection_sort(int [] data) {

    	for(int i=0 ; i<data.length-1 ;i++){

    		int min = i; //declaring the key of the smallest element

			for(int j=i+1 ; j<data.length ;j++){ //Iterating through array to find the smallest element

				if(data[min] > data[j]){ //if 

					min = j; //change the smallest element

				}
			}

			if(i != min) swap(data, i , min); //change the first elemnt wwith the smallest
		}


    }

    static void insertion_sort(int [] data) {
		
		for(int i=1 ; i<data.length ; i++){

			int element = data[i]; //selecting the i th item
			int j = i-1;
			while(j >=0 && element < data[j]){

				data[j+1] = data[j]; //changing the places of other elements
				j = j-1; 

			}

			data[j+1] = element; //replacing i th element in suitable place

		}
    }

		       
		
    
    
    

    public static void main(String [] args) {

    	int[] randomArray;
    	int[] bestArray;
    	int[] worstArray;
         
        //Testing Bubble sort
    	System.out.println("Testing Bubble Sort\n");
    	for(int n=1000; n<=8000 ; n*=2){ //creatimg random arrays with different sizes
    		randomArray = create_rand_data(n);
    		buble_sort(randomArray);
    		System.out.println("input = "+n+" random array bubble sort test passed? "+isSorted(randomArray));
    	}
    	bestArray = create_best_data(1000); //creating best array
    	worstArray = create_worst_data (1000); //creating worst array
    	buble_sort(bestArray); //bubble sorting arrays
    	buble_sort(worstArray);
    	System.out.println("input = 1000 best array bubble sort test passed? "+isSorted(bestArray)); //testing with isSorted
    	System.out.println("input = 1000 worst array bubble sort test passed? "+isSorted(worstArray));
        
        //Testing Selection Sort
    	System.out.println("\nTesting Selection Sort\n");
    	for(int n=1000; n<=8000 ; n*=2){
    		randomArray = create_rand_data(n);
    		selection_sort(randomArray);
    		System.out.println("input = "+n+" random array selection sort test passed? "+isSorted(randomArray));
    	}
    	bestArray = create_best_data(1000);
    	worstArray = create_worst_data (1000);
    	selection_sort(bestArray);
    	selection_sort(worstArray);
    	System.out.println("input = 1000 best array selection sort test passed? "+isSorted(bestArray));
    	System.out.println("input = 1000 worst array selection sort test passed? "+isSorted(worstArray));//testing with isSorted

        //Testing Insertion Sort
    	
        System.out.println("\nTesting Insertion Sort\n");
    	for(int n=1000; n<=8000 ; n*=2){
    		randomArray = create_rand_data(n);
    		insertion_sort(randomArray);
    		System.out.println("input = "+n+" random array insertion sort test passed? "+isSorted(randomArray));
    	}
    	bestArray = create_best_data(1000);
    	worstArray = create_worst_data (1000);
    	insertion_sort(bestArray);
    	insertion_sort(worstArray);
    	System.out.println("input = 1000 best array insertion sort test passed? "+isSorted(bestArray));
    	System.out.println("input = 1000 worst array insertion sort test passed? "+isSorted(worstArray));//testing with isSorted


    	long startbest, endbest, timebest=0;
    	long startworst, endworst, timeworst=0;
    	long startrandom, endrandom, timerandom=0;
    	
    	//checking bubble sort timing
        System.out.println("\n Bubble Sort timing results\n");
  		for(int n=1000 ; n<=8000 ; n*=2){

  			bestArray = create_best_data(n);//create an n size array for best wprst and random
            worstArray =create_worst_data(n);
            randomArray =create_rand_data(n);

  			for(int i=0; i<=100; i++){//get timing for 100 insatances

    			startbest = System.nanoTime();
    			buble_sort(bestArray);
    			endbest = System.nanoTime();

    			startworst = System.nanoTime();
    			buble_sort(worstArray);
    			endworst = System.nanoTime();

    			startrandom = System.nanoTime();
    			buble_sort(randomArray);
    			endrandom = System.nanoTime();

    			timebest += (endbest-startbest);//calculate total running time for bestcase
    			timeworst += (endworst-startworst);//calculate total running time for worst case
    			timerandom += (endrandom-startrandom);//calculate total running time for random case    		

   			}
   			System.out.println("\n Number of inputs ="+n);
   			System.out.printf("\nAverage bestcase running time in ns :"+ (timebest/100)+"\n");//print result best
   			System.out.printf("\nAverage worstcase running time in ns :"+ (timeworst/100)+"\n");//print result worst
   			System.out.printf("\nAverage random running time in ns :"+ (timerandom/100)+"\n");//print result random

  		}

        timerandom = timeworst =timebest = 0; //resetting collected time values
        //Checking selection time values
        System.out.println("\n\n Selection Sort timing results\n");
  		for(int n=1000 ; n<=8000 ; n*=2){

  			bestArray = create_best_data(n);//create an n size array
            worstArray =create_worst_data(n);
            randomArray =create_rand_data(n);

  			for(int i=0; i<=100; i++){//100 insatances

    			startbest = System.nanoTime();
    			selection_sort(bestArray);
    			endbest = System.nanoTime();

    			startworst = System.nanoTime();
    			selection_sort(worstArray);
    			endworst = System.nanoTime();

    			startrandom = System.nanoTime();
    			selection_sort(randomArray);
    			endrandom = System.nanoTime();

    			timebest += (endbest-startbest);//calculate total running time	
    			timeworst += (endworst-startworst);//calculate total running time
    			timerandom += (endrandom-startrandom);//calculate total running time	    		

   			}
   			System.out.println("\n Number of inputs ="+n);
   			System.out.printf("\nAverage bestcase running time in ns :"+ (timebest/100)+"\n");//print result
   			System.out.printf("\nAverage worstcase running time in ns :"+ (timeworst/100)+"\n");//print result
   			System.out.printf("\nAverage random running time in ns :"+ (timerandom/100)+"\n");//print result

  		}
        timerandom = timeworst =timebest = 0; //resetting collected time values
        //checking Insertion timings
  		System.out.println("\n\n Insertion Sort timing results\n");
  		for(int n=1000 ; n<=8000 ; n*=2){

  			bestArray = create_best_data(n);//create an n size array
            worstArray =create_worst_data(n);
            randomArray =create_rand_data(n);

  			for(int i=0; i<=100; i++){//100 insatances

    			startbest = System.nanoTime();
    			insertion_sort(bestArray);
    			endbest = System.nanoTime();

    			startworst = System.nanoTime();
    			insertion_sort(worstArray);
    			endworst = System.nanoTime();

    			startrandom = System.nanoTime();
    			insertion_sort(randomArray);
    			endrandom = System.nanoTime();

    			timebest += (endbest-startbest);//calculate total running time	
    			timeworst += (endworst-startworst);//calculate total running time
    			timerandom += (endrandom-startrandom);//calculate total running time	    		

   			}
   			System.out.println("\n Number of inputs ="+n);
   			System.out.printf("\nAverage bestcase running time in ns :"+ (timebest/100)+"\n");//print result
   			System.out.printf("\nAverage worstcase running time in ns :"+ (timeworst/100)+"\n");//print result
   			System.out.printf("\nAverage random running time in ns :"+ (timerandom/100)+"\n");//print result

  		}











  		
    	
    }
}