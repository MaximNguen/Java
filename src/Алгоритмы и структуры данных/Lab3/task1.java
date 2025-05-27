import java.util.*;

class Node {
    int val;
    Node left, right;
    
    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

class BST {
    Node root;
    
    void insert(int key) {
        root = insertRec(root, key);
    }
    
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);
        return root;
    }
    
    void inorder() {
        inorderRec(root);
    }
    
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }
}

public class task1 {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] keys = {50, 20, 70, 10, 30, 60, 90};
        for (int key : keys) {
            tree.insert(key);
        }
        
        System.out.println("Inorder обход BST:");

        tree.insert(25);
        tree.inorder();

        
    }
}