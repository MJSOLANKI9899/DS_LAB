import java.util.Scanner;

public class Demo_Tree {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Demo_Tree a = new Demo_Tree();
        Boolean root_node = false;
        while (true) {
            System.out.println();
            System.out.print(
                    "   Enter 1 for root node," + "\n" +
                            "   Enter 2 for insert element in tree ," + "\n" +
                            "   Enter 3 for display all elements," + "\n" +
                            "   Enter 4 for search an element," + "\n" +
                            "   Enter 5 for preorder traversal ," + "\n" +
                            "   Enter 6 for inorder traversal," + "\n" +
                            "   Enter 7 for postorder traversal," + "\n" +
                            "   Enter 8 for delete node," + "\n" +
                            "   Enter any thing else for terminate the programe :");
            int i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                a.insert();
                root_node = true;
            } else if (i == 2) {
                if (root_node) {
                    a.insert_elements(root);
                } else {
                    System.out.println("Please enter the root node first! :( ");
                }
            } else if (i == 3) {
                a.pretydisplay(root, 0);
            } else if (i == 4) {
                a.search();
            }else if (i == 5) {
                a.priorder(root);
            }else if (i == 6) {
                a.inorder(root);
            }else if (i == 7) {
                a.postorder(root);
            }else if (i == 8) {
                System.out.print("Enter a no. to delete : ");
                a.deleteNode(root,sc.nextInt());
            }  else {
                System.out.println(
                        "---------------the program has been termineted successfully! :)---------------------------");
                break;
            }
            System.out.println("--------------------------------------------------------------");

        }
    }
    public static Node root;
    
    public static void priorder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.info+",");

        if(node.left!=null){
            priorder(node.left);
        }

        if (node.right!= null){
            priorder(node.right);
        }

    }
    public static void inorder(Node node){
        if(node== null){
            return;
        }
       if(node.left!=null){
            inorder(node.left);
       }

       System.out.println(node.info+",");

       if(node.right!= null){
            inorder(node.right);
       }
    }
    public static void postorder(Node node){
        if(node== null){
            return;
        }

       if(node.left!=null){
            postorder(node.left);
       }

       if(node.right!= null){
            postorder(node.right);
       }

       System.out.println(node.info+",");
       
    }

    public static class Node {
        int info;
        int balence;
        Node left;
        Node right;

        Node(int info) {
            this.info = info;
            left = null;
            right = null;
        }
    }



    // insert root node
    public void insert() {
        System.out.println("Enter the root Node : ");
        int info = sc.nextInt();
        root = new Node(info);
    }

    // elements
    public void insert_elements(Node node) {
        System.out.print("Enter a element :");
        insert_elements(root, sc.nextInt());
    }

    public void insert_elements(Node node, int info) {
        if (node == null) {
            return;
        } else if (node.info < info) {
            insert_elements(node.right, info);
            if (node.right == null) {
                Node newnode = new Node(info);
                node.right = newnode;
                return;
            }
        } else if (node.info > info) {
            insert_elements(node.left, info);
            if (node.left == null) {
                Node newnode = new Node(info);
                node.left = newnode;
                return;
            }
        }
    }

    //display
    public void pretydisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        pretydisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.info);
        } else {
            System.out.println(node.info);
        }
        pretydisplay(node.left, level + 1);
    }

    //search
    public void search() {
        System.out.print("Enter the element for search : ");
        Boolean ift = search(root, sc.nextInt());
        if (ift)
            System.out.println("found! :)");
        else
            System.out.println("not found! :(");
    }

     public Boolean search(Node node, int search) {
        if (node == null) {
            return false;
        } else if (node.info == search) {
            return true;
        }
        return search(node.left, search) || search(node.right, search);
    }

    //delete
    Node deleteNode(Node root, int key) {
        if (root == null) return root;

        if (key < root.info)
            root.left = deleteNode(root.left, key);
        else if (key > root.info)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.info = minValue(root.right);

            root.right = deleteNode(root.right, root.info);
        }

        return root;
    }

    //min value
    int minValue(Node root) {
        int minValue = root.info;
        while (root.left != null) {
            root = root.left;
            minValue = root.info;
        }
        return minValue;
    }
}