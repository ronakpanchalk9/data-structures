public class treeFromInAndPost {
    static int findPos(int[] inorder, int element, int n) {
        for (int i = 0; i < n; i++) {
            if (inorder[i] == element) {
                inorder[i] = -1;
                return i;
            }
        }
        return -1;
    }

    static Node solve(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int n, int[] postIdx) {
        if (postIdx[0] < 0 || inorderStart > inorderEnd) {
            return null;
        }

        int element = postorder[postIdx[0]--];

        Node root = new Node(element);

        int root_pos = findPos(inorder, element, n);

        root.right = solve(inorder, postorder, root_pos + 1, inorderEnd, n, postIdx);
        root.left = solve(inorder, postorder, inorderStart, root_pos - 1, n, postIdx);
        return root;
    }

    Node buildTree(int in[], int post[], int n) {
        // Your code here
        int[] postIdx = new int[1];
        postIdx[0] = n - 1;
        return solve(in, post, 0, n - 1, n, postIdx);
    }
}
