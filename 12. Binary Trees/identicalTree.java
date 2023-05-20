public class identicalTree {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Function to check if two trees are identical.
    boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if ((root1 == null && root2 == null)) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1 != null && root2 != null) {
            if (root1.data != root2.data) {
                return false;
            }
        }

        boolean l = isIdentical(root1.left, root2.left);
        boolean r = isIdentical(root1.right, root2.right);
        return l && r;
    }

}
