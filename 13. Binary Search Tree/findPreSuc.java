// There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.

// Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 
public class findPreSuc {
    static Node pre = null;
    static Node suc = null;
    static Node ceilNode(Node root, int key) {
        int diff = Integer.MAX_VALUE;
        Node ans = new Node(root.data);
        while (root != null) {
            int root_data = root.data;
            if (root.data != key && diff - root_data < diff && root_data > key) {
                ans = root;
                diff = root_data;
            }
            if (key >= root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (diff == Integer.MAX_VALUE) {
            return null;
        }
        return ans;
    }

    static Node floor(Node root, int key) {
        int diff = Integer.MAX_VALUE;
        Node ans = new Node(root.data);
        while (root != null) {
            int root_data = root.data;
            if (root.data != key && diff - root_data < diff && root_data < key) {
                ans = root;
                diff = root_data;
            }
            if (key > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (diff == Integer.MAX_VALUE) {
            return null;
        }
        return ans;
    }

    public static void findPreSuc(Node root, int key) {
        // code here.
        pre = floor(root, key);
        suc = ceilNode(root, key);
        /*
         * There are two static nodes defined above pre(representing predecessor) and
         * suc(representing successor) as follows:
         * static Node pre=null,suc=null
         * You need to update these both.
         * And the data inside these classes will be printed automatically by the driver
         * code.
         */
    }
}
