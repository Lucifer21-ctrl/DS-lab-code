class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class ConversBinaryTreeExample {

    Node root;

    // Inorder Traversal (Left → Root → Right)
    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.right);
        System.out.print(node.data + " ");
        inorder(node.left);
    }

    // Preorder Traversal (Root → Left → Right)
    void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.right);
        preorder(node.left);
    }

    // Postorder Traversal (Left → Right → Root)
    void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.right);
        postorder(node.left);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ConversBinaryTreeExample tree = new ConversBinaryTreeExample();

        // Creating nodes manually
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }
}