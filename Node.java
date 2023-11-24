// Node class with key and contact name as attributes
public class Node {
    int key;
    String contactName;
    Node left;
    Node right;
// Node class constructor
    public Node(int number, String contactName) {
        this.key = number;
        this.contactName = contactName;
        this.left = null;
        this.right = null;
    }
}
