
// Given 2 Arrays of Inorder and preorder traversal. The tree can contain duplicate elements. Construct a tree and print the Postorder traversal
import java.util.*;

class Node {
    int data;
    Node left, right;
}

public class postFromInAndPre {
    static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder,
                inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder,
                inRoot + 1, inEnd, inMap);

        return root;
    }

    public static Node buildTree(int[] inorder, int[] preorder, int n) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
                inorder.length - 1, inMap);
        return root;
    }
}
