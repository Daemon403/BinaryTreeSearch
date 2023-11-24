// This class represents a binary search tree data structure
public class BinarySearchTree {
    Node root;
    // this constructor initializes an empty BST
    public BinarySearchTree() {
        this.root = null;
    }
/*
Given a number and contact name, create and
insert a new node into the BST
    */
    public void insert(int number, String contactName) {
        // if the tree is empty, the root node becomes the node
        if(root ==null){
            root = new Node(number, contactName);
        }
        // finding the correct position of the node
        else{
            Node parent = null;
            Node temp = root;
            while (temp!=null){
                parent = temp;
                if (number>temp.key){
                    temp = temp.right;
                }
                else if(number <temp.key){
                    temp = temp.left;
                }
            }
            // compare nodes and insert appropriately
            if (number < parent.key){
                parent.left = new Node(number, contactName);
            }
            else{
                parent.right = new Node(number, contactName);
            }
        }
    }
    // In this implementation, a contact is deleted based on
    // the given contact number. This method is recursive ie. self calling
    public Node delete(Node root,int number){
        if (root == null){
            return root;
        }
        if (number < root.key){
            root.left = delete(root.left,number);
        }
        else if (number> root.key){
            root.right = delete(root.right, number);
        }
        else{
            if(root.left ==null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }
            root.key = findMin(root.right);
            root.right = delete(root.right,root.key);
        }
        return root;
    }
    // find the minimum value in a given subtree
    public int findMin(Node root){
        int minVal = root.key;
        while (root.left!= null){
            minVal =root.left.key;
            root=root.left;
        }
        return minVal;
    }
    // printing all elements in the tree
    // in ascending order of contact by implementing
    // in-order traversal
    public void print(Node temp) {

        if (temp != null) {
            print(temp.left);
            System.out.println(temp.key + " "+ temp.contactName);
            print(temp.right);
        }
    }
    // check for existence of a node with a given name
    public boolean find(Node root,String contactName) {
        if (root==null){
            return false;
        }
        if (root.contactName.equalsIgnoreCase(contactName)){
           return true;
        }
        boolean left = find(root.left, contactName);
        boolean right = find(root.right, contactName);
        return left || right;
    }
    // check for existence of a node with a given number
    public boolean search(Node root,int contact){
        if (root == null){
            return false;
        }
        if (root.key ==contact){
            return true;
        }
        if (contact <root.key) {
            return search(root.left, contact);
        }else {
            return search(root.right, contact);
        }
    }
    // Demonstrating the implementation of the functions defined above
    public  static void main(String[] args) {
        // creating a tree
        BinarySearchTree tree = new BinarySearchTree();
        //inserting values into the tree
        tree.insert(10, "A");
        tree.insert(20,"B");
        tree.insert(30,"C");
        tree.insert(40,"D");
        tree.insert(50,"E");
        tree.insert(60,"F");
        tree.insert(70,"G");
        // displaying elements in the tree
        System.out.println("HERE IS THE TREE");
        tree.print(tree.root);
        //deleting a node in the tree
        System.out.println("DELETING");
        tree.delete(tree.root,30);
        System.out.println();
        // displaying to check if node was deleted
        System.out.println("Here is the new tree after deleting");
        tree.print(tree.root);
        System.out.println("searching for a contact by contact name");
        //searching for a contact by contact name
        System.out.println(tree.find(tree.root,"Z"));
        //searching for a contact by contact number
        System.out.println("searching for a contact by contact number");
        System.out.println(tree.search(tree.root,40));
    }
}

