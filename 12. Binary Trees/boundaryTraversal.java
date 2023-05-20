// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
// Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
// Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.


import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class boundaryTraversal {

    static void printL(Node node, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            ans.add(node.data);
            printL(node.left, ans);
        } else if (node.right != null) {
            ans.add(node.data);
            printL(node.right, ans);
        }

    }

    static void printLeaf(Node node, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        printLeaf(node.left, ans);
        if (node.left == null && node.right == null) {
            ans.add(node.data);
        }
        // printLeaf(node.left, ans);
        printLeaf(node.right, ans);

    }

    static void printR(Node node, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            printR(node.right, ans);
            ans.add(node.data);

        } else if (node.left != null) {
            printR(node.left, ans);
            ans.add(node.data);

        }
    }

    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(node.data);

        printL(node.left, ans);
        printLeaf(node.left, ans);
        printLeaf(node.right, ans);
        printR(node.right, ans);

        return ans;
    }
}
