public class SortingAlgos { 

    /* Some test cases */
    static int [] data1 = {0, 0, 0, 0, 0, 0, 0};
    static int [] data2 = {0, 0, 0, 0, 0, 0, 0, 0};
    static int [] data3 = {1, 2, 3, 4, 5, 6, 7, 8};
    static int [] data4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int [] data5 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int [] data6 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    static int [][] tests = {data1, 
			     data2, 
			     data3,
			     data4,
			     data5,
			     data6 };

    /********************* Random array generation ***************/

    static int [] create_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    static int getRandom(int size) { 
	return (int) (Math.random() * size);
    }

    /************* Postcondition *********************/
    static boolean postcondition(int [] array) { 
	for(int i=1; i<array.length; i++) 
	    if(array[i-1] > array[i]) return false; 
	return true; 
    }

    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }


    static void display(int [] data, int from, int end) { 
	System.out.printf("=FROM %d TO %d DISPLAY=\n", from, end);
	for(int i=from; i <= end; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("-END-\n");
    }
    

    /*************** NlogN algorithms *********************/
  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
    static void mergeSort(int [] data) { 
	int [] tmp = new int [data.length];	
	mergeSort(data, tmp, 0, data.length-1);
    }

    static void mergeSort(int [] data, int [] tmp, int start, int end){ 
	if(start < end)  {
	    int mid = (start + end) / 2; 
	    mergeSort(data, tmp, start, mid);
	    mergeSort(data, tmp, mid+1, end);

	    merge(data, tmp, start, mid, end);
	}
    }

    static void merge(int [] data, int [] tmp, int start, int mid, int end) {
	int total = end - start + 1; 
	int i = start, j = mid+1, k; 

	for(k=0; (k < total) && (i <= mid) && (j <= end); k++) { 
	    if(data[i] < data[j]) tmp[k] = data[i++];
	    else                  tmp[k] = data[j++];
	}
	
	for(;k < total && i <= mid; k++, i++) tmp[k] = data[i];
	for(;k < total && j <= end; k++, j++) tmp[k] = data[j];
	
	for(k=0; k < total; k++) 
	    data[start + k] = tmp[k];
    }

    /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

    static int [] combine(int [] a, int [] b) { 
	int total = a.length + b.length; 
	int [] merged = new int [total]; 
	int i=0, j=0, k; 
	for(k=0;
	    k < total && i < a.length && j < b.length; 
	    k++) { 
	    if(a[i] < b[j]) { 
		merged[k] = a[i++]; 
		//i++; 
	    }
	    else { 
		merged[k] = b[j++]; 
		//j++; 
	    }
	}

	for(; k < total && i < a.length; k++, i++)
	    merged[k] = a[i];
	for(; k < total && j < b.length; k++, j++)
	    merged[k] = b[j];
	

	return merged; 
    }
    
    static int [] split(int [] a, int from, int to) { 
	/* array including from till to */	
	int [] newarray = new int [to - from]; 

	for(int i=0; i < newarray.length; i++) {
	    newarray[i] = a[from + i];
	}
	return newarray;
    }
	

    static int [] merge_sort(int [] a) { 

	if(a.length  == 1) return a; 

	int mid = (int)((a.length) / 2);
	
	int [] left  = split(a, 0, mid);// excluding mid 
	int [] right = split(a, mid, a.length); 
	left  = merge_sort(left);
	right = merge_sort(right);
	return combine(left, right);
    }    
  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

        /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
    static void quickSort(int [] data) { 
	quickSort(data, 0, data.length-1);
    }

    static void quickSort(int [] data, int start, int end) {
	if(start < end) { 
	    int pivotPosition = partition(data, start, end); 
	    quickSort(data, start, pivotPosition-1);
	    quickSort(data, pivotPosition+1, end); 
	}
    }

    static int partition(int [] data, int start, int end) { 
	int pivot = data[start]; /* first element is pivot */
	int l=start, r=end; 
	while(l < r) { 
	    while(data[l] <  pivot && l < end) l++; 
	    while(data[r] >= pivot && r > start) r--;
	    if(l < r) { 
		int tmp = data[l];
		data[l] = data[r];
		data[r] = tmp; 
	    }
	}
	if(pivot > data[r] ){ 
	    data[start] = data[r];
	    data[r]     = pivot;
	}
	
	return r; 
    }
		    


  /*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/


    public static void main(String [] args) { 
	for(int  i=0; i<tests.length; i++) { 
	    quickSort(tests[i]);

	    if(postcondition(tests[i])) { 
		System.out.println("worked for test case:" + (i+1));	    
	    }
	    else { 
		System.out.println("Broken code");
		display(tests[i]); 
		while(true);
	    }
	} /* test cases */

	System.out.println("Testing with random arrays ");

	for(int  i=10; i < 200000; i += getRandom(100)) { 
	    int [] data = create_data(i); 
	    quickSort(data);	    

	    if(postcondition(data)) { 
		System.out.printf("worked for random array with %d elem\n",i);
	    }
	    else { 
		System.out.println("Broken code");
		display(tests[i]); 
		while(true);
	    }
	} /* random arrays */
	
    }
}
		
