// E/17/379
//Node class
class Node 
{
    int key, height;
    Node left, right;
    
    Node(int d) //constructor
    {
        key = d;
        height = 1; //initializing height to 1
    }

}

//AVL tree class
public class AVLTree
{
	Node root;
	//returns height of a node
	int height(Node N)
	{
        
        if (N == null)
            return 0;
 
        return N.height;
    }
    //updates the height of a given node (height of the taller subtree + 1)
	void UpdateHeight(Node node)
	{
		node.height = max(height(node.left), height(node.right)) + 1;
	}

	//returns maximum of given two numbers
	int max(int a, int b) 
	{
        return (a > b) ? a : b;
    }
    //right rotation
	Node rightRotate(Node y) 
	{
    
        Node x = y.left;
        Node z = x.right;
 
        //Rotation
        x.right = y;
        y.left = z;
 
        //Update heights
        UpdateHeight(y);
        UpdateHeight(x);
 
        return x; //return new parent node
    }

    //left rotation
    Node leftRotate(Node x) 
    {
        Node y = x.right;
        Node z = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = z;
 
        //Update heights
        UpdateHeight(y);
        UpdateHeight(x);
 
        return y; //return new parent node
    
    }

    //return the balace value from heights
	int getBalance(Node N) 
	{
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
    
    //insert a key to a subtree
	Node insert(Node node, int key) 
	{
 
        //if root of the given sub tree is null, returns null
        if (node == null)
            return (new Node(key));

        //if the key is less than node key
        if (key < node.key)
        {
        	//inserting key to the left node recursively
            node.left = insert(node.left, key);
        }
        //if the key is larger than node key
        else if (key > node.key)
        {
        	//inserting key to the right node recursively
            node.right = insert(node.right, key);
        }
        //if the given key already in the tree
        else 
        {
           throw new RuntimeException("Duplicate Key!");
        }
 		//rebalance after inserting key
 		return rebalance(node , key);

	}
    //to delete a given node
	Node delete(Node node, int key)
	{
        //if the root of the given sub tree is null, return null node
        if (node == null)
        {
            return (new Node(key));
        }

        //if node key is bigger than the key
        else if (node.key > key)
        {
        	//delete left node recursively
        	node.left = delete(node.left , key);
        }
        //if node key is smaller than the key
        else if (node.key < key)
        {
        	//delete right node recursively
        	node.right = delete(node.right , key);
        }

        else
        {
        	//if the left or right nodes are empty
        	if (node.left == null || node.right == null)
        	{   
        		//if left node is empty replace node with right node else replace with left node 
        		node = (node.left == null ) ? node.right : node.left; 
        	}

        	else
        	{
        		Node mostLeftChild = mostLeftChild(node.right);
        		node.key = mostLeftChild.key;
        		node.right = delete(node.right , node.key);
        	}
        }

        if (node != null)
        {
        	return rebalance(node , key);
        }

        return node;

	}

    //search for a given key
	boolean search(Node node , int key)
	{

        //if the root of the given sub tree is null
		if (node == null )
		{
			return false;
		}

        //if root is the key
		if (node.key == key) 
		{
			return true;
		}

        //if the node key is biggesr than the searching key
		if (node.key > key) 
		{
			//recursively search for the key in left node
			return search(node.left , key);
		}

		else
		{
			//else recursively search for the key in right-=- node
			return search(node.right, key);
		}

	}

	//find the most left child node
	Node mostLeftChild(Node node)
    {
        Node current = node;
 
        //Iterate until left node is empty
        while (current.left != null)
        current = current.left;
 
        return current;
    }

    //rebalance a sub tree
	private Node rebalance(Node node , int key)
	{	

   		UpdateHeight(node); //update node height
		int balance = getBalance(node); //get the balance value

        // Case Left Left 
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
 
        // Case Right Right 
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        // Case Left Right 
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Case Right Left 
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
  
        return node;
    }
    //print AVL-tree---preorder
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " "); // print the key in node
            preOrder(node.left); //traverse left subtree
            preOrder(node.right); //traverse right ubtree
        }
        return;
    }
    //print AVL-tree---inorder
    void inOrder(Node node) {
        if (node != null) {
        	inOrder(node.left); //traverse left subtree
            System.out.print(node.key + " "); //print the node
            inOrder(node.right); //traverse right subtree
        }
        return;
    }

    //print AVL-tree---postorder
    void postOrder(Node node) {
        if (node != null) {
        	postOrder(node.left); //traverse left subtree
            postOrder(node.right); //traverse right subtree
            System.out.print(node.key + " "); //print the key in node
        }
        return;
    }

    public static void main(String[] args) {
        
        //create a tree
        AVLTree tree = new AVLTree();
 
        // inserting 24, 12, 5, 30, 20, 45, 11, 13, 9, 16 example in tree__part__2
        tree.root = tree.insert(tree.root, 24);
        tree.root = tree.insert(tree.root, 12);
        //tree.root = tree.insert(tree.root, 12);  //throws the exeption duplicate key
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 45);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 16);

        //pre order
        System.out.println("Preorder traversal tree ");
        tree.preOrder(tree.root);
        System.out.println('\n');

        //in order
        System.out.println("Inorder traversal tree  ");
        tree.inOrder(tree.root);
        System.out.println('\n');

        //post order
        System.out.println("Postorder traversal  tree  "); 
        tree.postOrder(tree.root);
        System.out.println('\n');
         
        //search a key
        System.out.println("Is 20 in the tree? "+ tree.search(tree.root , 20));
        System.out.println('\n');

        //delete a key
        System.out.println("20 is deleted");        
        tree.root = tree.delete(tree.root, 20);
        System.out.println('\n');
        
        //search deleted key
        System.out.println("Is 20 in the tree? "+ tree.search(tree.root , 20));
        System.out.println('\n');


        //print tree after the deletion
        System.out.println("Preorder traversal tree  "); 
        tree.postOrder(tree.root);
        System.out.println('\n');

        

    }

}