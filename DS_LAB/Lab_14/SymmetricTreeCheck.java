public class SymmetricTreeCheck {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(Node leftTree, Node rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree == null || rightTree == null) {
            return false;
        }

        return (leftTree.data == rightTree.data) &&
               isMirror(leftTree.left, rightTree.right) &&
               isMirror(leftTree.right, rightTree.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if (isSymmetric(root)) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
    }
}
