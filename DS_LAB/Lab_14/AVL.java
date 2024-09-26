import java.util.Scanner;

public class AVL {
    static Scanner sc = new Scanner(System.in);
    public static Node root;

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.print(
                    "   Enter 1 to insert root node," + "\n" +
                            "   Enter 2 to insert element in tree," + "\n" +
                            "   Enter 3 to display all elements," + "\n" +
                            "   Enter 4 to search an element," + "\n" +
                            "   Enter any other key to terminate the program: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    insertRoot();
                    break;
                case 2:
                    insertElements();
                    break;
                case 3:
                    prettyDisplay(root, 0);
                    break;
                case 4:
                    searchElement();
                    break;
                default:
                    System.out.println("Program terminated successfully! :)");
                    return;
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static class Node {
        int info;
        int height;
        Node left, right;

        Node(int info) {
            this.info = info;
            this.height = 1;  
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.info) {
            node.left = insert(node.left, key);
        } else if (key > node.info) {
            node.right = insert(node.right, key);
        } else {
            return node; 
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        
        if (balance > 1 && key < node.left.info) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.info) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.info) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.info) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void insertRoot() {
        System.out.print("Enter the root Node: ");
        int info = sc.nextInt();
        root = new Node(info);
    }

    public static void insertElements() {
        if (root == null) {
            System.out.println("Please enter the root node first! :( ");
            return;
        }
        System.out.print("Enter an element: ");
        int element = sc.nextInt();
        root = insert(root, element);
    }

    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.info);
        } else {
            System.out.println(node.info);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static void searchElement() {
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        boolean found = search(root, key);
        if (found) {
            System.out.println("Element found! :)");
        } else {
            System.out.println("Element not found! :(");
        }
    }

    public static boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.info == key) {
            return true;
        }
        if (key < node.info) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
}
