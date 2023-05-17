import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
//Recurive Approach
public class findDepth {
    int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftside = height(root.left);
        int rightside = height(root.right);

        return 1 + Math.max(leftside, rightside);
    }
}
