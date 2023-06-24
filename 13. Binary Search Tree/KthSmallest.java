class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class KthSmallest {
    static int ans(Node root, int[] arr, int k) {
        if (root == null) {
            return -1;
        }

        int left = ans(root.left, arr, k);

        if (left != -1) {
            return left;
        }

        arr[0]++;

        if (arr[0] == k) {
            return root.data;
        }

        return ans(root.right, arr, k);
    }

    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        int[] arr = new int[1];
        arr[0] = 0;

        return ans(root, arr, k);
    }
}
