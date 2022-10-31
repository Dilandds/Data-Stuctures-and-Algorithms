# Data-Stuctures-and-Algorithms
How to implement Data stuctures and use algorithms that can optimize run time and storage use.

# Data-Stuctures-Algorithms implemented/ tested 

## Sorting Algorithms

<br/>Bubble sort <br/>
Selection sort <br/>
Insertion sort <br/>
Merge sort <br/>
Quick sort <br/>

## Dynamic programming

Finding the max sub array using dynamic programming


## Hashing 

### Double Hashing

Implement a double-hashing hash table in Java with the necessary helper
methods. This hash table has the hash function ℎ(𝑘) = 𝑘 % 𝑁, where k is the
key and N is the capacity of the hash table. The collisions are handled using
double hashing with the probe function,
𝑝(𝑘, 𝑖) = 𝑖 ∗ {1 + 𝑘%(𝑁 − 1)} where i is the iteration.

### Chaining

Implement a hash table that uses separate chaining using the Java LinkedList
class. You are free to choose the number of slots (N) in the hash table and the
hash function should be, ℎ(𝑘) = 𝑘 % 𝑁 where k is the integer key. The value
inserted is a string

## Graphs 

<b>1 </b>

### Bipartite

In graph theory, a bipartite graph is a graph in which the vertices can be divided into two
disjoint sets. Every edge in the graph connects a vertex in one set to a vertex in the other set.
Using <b>breadth-first search (BFS)</b>, design an algorithm to find out whether a graph given as an
adjacency matrix is a bipartite graph.

### TC_DFS

Java code to get the transitive closure of a graph using <b>depth-first search (DFS)</b>. The
graph is represented as an adjacency list. The number of vertices of the graph is to be passed
into its constructor

<b>2</b>

Solving a least cost problem with <b>Dijkstra’s shortest path algorithm </b>

## Trees

### AVL

Using the given node class, implement an AVL tree. With Methods
for inserting a node, removing a node, and searching for a value in
that AVL tree.
 Implement methods to perform pre-order, in-order, and post-order
traversal on the implemented AVL tree.
Main method and demonstrate the functions that you have
implemented

### HEAP

Implement a min-heap using an array. The maximum size of the heap
is passed in at the time of construction


