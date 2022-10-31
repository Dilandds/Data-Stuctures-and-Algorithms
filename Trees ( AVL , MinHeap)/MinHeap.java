public class MinHeap {
    private int[] Heap;
    private int size;
    private int current_size;
    private static final int ROOT = 0; //to do the root remove (only root can be removed)
    
    //constructor
    public MinHeap(int size)
    {
        this.size = size;
        Heap = new int[this.size];
        this.current_size = 0;
    }

    //returns the index of the parent (input is index of child)
    private int parent(int n)
    {
        return (n-1)/2;
    }

    //return index of left child
    private  int leftChild(int n)
    {
        return (2 * n) + 1;
    }

    //return index of right child
    private  int rightChild(int n)
    {
        return (2 * n) + 2;
    }

    //funtion will return true for leaf
    private boolean isLeaf(int n)
    {
        if(n > (current_size / 2)-1 && n <= current_size-1)return  true;
        return false;
    }

    //swap two indexes
    private  void swap(int i,int j)
    {
        int temp;
        temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    //heapify a node at a given index
    private  void minHeapify(int n)
    {

    	//if node is not a leaf
        if(!isLeaf(n))
        {
            //if parent node greater than child nodes
            if(Heap[n] > Heap[leftChild(n)] || Heap[n] > Heap[rightChild(n)])
            {
            	//if right child is greater than left child
                if(Heap[leftChild(n)] < Heap[rightChild(n)])
                {
                     //left child is the smallest, swap it with parent
                    swap(n,leftChild(n));
                    //recurcively heapify leftChild
                    minHeapify(leftChild(n));
                }
                //otherwise
                else
                {
                	//right child is the smallest, swap it with parent
                    swap(n,rightChild(n));
                    //recurcively heapify rightChild
                    minHeapify(rightChild(n));
                }
            }
        }
    }

    //insert a key to heap
    public void insert(int k)
    {

        //if heap is full
        if(current_size >= size)return;

        int cur = current_size;

        //insert the key to the heap at the end
        Heap[current_size] = k;
        

        //set minmum node as the root
        while(Heap[cur] < Heap[parent(cur)])
        {
            swap(cur,parent(cur));
            cur = parent(cur);
        }
        current_size++;
    }

    //remove the minimum key
    public  int remove()
    {
    	//get minimum key
        int min = Heap[ROOT];

        //copy last node to the root & decrese the current size
        Heap[ROOT] = Heap[current_size-- -1]; 
        
        //minHeapify again
        minHeapify(ROOT);
        //return the removed root value
        return  min;
    }

    //print the heap
    public void print()
    {

        for(int i = 0 ; i < current_size/2 ; i++)
        {
            
            System.out.format("PARENT-------> ( %d )\n\n",Heap[i]);
            //getting child indexes from parent
            System.out.format("LEFT CHILD (%d) RIGHT CHILD  (%d) \n",Heap[leftChild(i)], Heap[rightChild(i)]);
        }
    }

  
    public static void main(String[] args)
    {


        //create a Heap
        MinHeap minHeap = new MinHeap(15);

        //inserting 1 2 5 9 4 6 10 12 example in Trees_part_2 pdf

        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(10);
        minHeap.insert(12);
        
        //prints the Heap
        System.out.println(" Min Heap ");
        System.out.println(" -------- ");
        minHeap.print();
        System.out.println();

        //removes the minimum key
        System.out.format("The root  value  %d  is removed:\n\n", minHeap.remove());

        //prints the Heap
        System.out.println("New Min Heap ");
        System.out.println("------------");
        minHeap.print();
        System.out.println();

    }

}
