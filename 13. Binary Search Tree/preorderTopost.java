import java.util.*;

public class preorderTopost {
    static int findPos(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                inorder[i] = -1;
                return i;
            }
        }
        return -1;
    }

    public static Node constructTree(int[] pre, int[] inorder, int preStart, int preEnd, int[] preIdx) {
        if (preIdx[0] >= pre.length || preEnd < preStart) {
            return null;
        }
        Node root = new Node(pre[preIdx[0]++]);

        int in_pos = findPos(inorder, root.data);

        root.left = constructTree(pre, inorder, preStart, in_pos - 1, preIdx);
        root.right = constructTree(pre, inorder, in_pos + 1, preEnd, preIdx);
        return root;
    }

    public static Node post_order(int pre[], int size) {
        int[] inorder = new int[size];
        for (int i = 0; i < pre.length; i++) {
            inorder[i] = pre[i];
        }
        Arrays.sort(inorder);
        int[] preIdx = { 0 };

        return constructTree(pre, inorder, 0, size, preIdx);
    }
}
