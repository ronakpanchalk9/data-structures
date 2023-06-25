import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class merge2BST {
    public static void addList(List<Integer> ans, Node root) {
        if (root == null) {
            return;
        }

        addList(ans, root.left);
        ans.add(root.data);
        addList(ans, root.right);
    }

    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> bst1 = new ArrayList<>();
        List<Integer> bst2 = new ArrayList<>();

        addList(bst1, root1);
        addList(bst2, root2);
        int i = 0;
        int j = 0;
        while (i < bst1.size() && j < bst2.size()) {
            if (bst1.get(i) < bst2.get(j)) {
                ans.add(bst1.get(i));
                i++;
            } else {
                ans.add(bst2.get(j));
                j++;
            }
        }
        while (i < bst1.size()) {
            ans.add(bst1.get(i));
            i++;
        }
        while (j < bst2.size()) {
            ans.get(bst2.get(j));
            j++;
        }
        
        return ans;
    }
}
