
// Given 2 Arrays of Inorder and preorder traversal. The tree can contain duplicate elements. Construct a tree and print the Postorder traversal
import java.util.*;

class Node {
    int data;
    Node left, right;
}

public class postFromInAndPre {
    static int findPos(int[] inorder, int element, int n) {
        for (int i = 0; i < n; i++) {
            if (inorder[i] == element) {
                inorder[i] = -1;
                return i;
            }
        }
        return -1;
    }

    static Node solve(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int n, int[] preIdx) {
        if (preIdx[0] >= n || inorderStart > inorderEnd) {
            return null;
        }

        int element = preorder[preIdx[0]++];

        Node root = new Node(element);

        int root_pos = findPos(inorder, element, n);

        root.left = solve(inorder, preorder, inorderStart, root_pos - 1, n, preIdx);

        root.right = solve(inorder, preorder, root_pos + 1, inorderEnd, n, preIdx);

        return root;
    }

    public static Node buildTree(int[] inorder, int[] preorder, int n) {
        int[] preIdx = new int[1];
        preIdx[0] = 0;
        return solve(inorder, preorder, 0, n - 1, n, preIdx);
    }
}
