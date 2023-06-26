// You are given the root of a binary search tree(BST), where exactly two nodes were swapped by mistake. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.

public class swapNodes {
    private static Node first;
    private static Node middle;
    private static Node last;
    private static Node prev;

    public Node correctBST(Node root) {
        first = null;
        middle = null;
        last = null;
        prev = new Node(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        return root;
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null && (root.data < prev.data)) {
            // This is the first violation
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
                // This is 2nd violation
            }
        }
        prev = root;
        inorder(root.right);
    }
}