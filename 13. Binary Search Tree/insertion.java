class insertion {
    // Function to insert a node in a BST.
    Node insert(Node root, int key) {
        Node head = root;

        Node temp = new Node(key);

        while (head != null) {
            if (head.data == key) {
                return root;
            }
            if (key > head.data) {
                if (head.right == null) {
                    head.right = temp;
                }
                head = head.right;
            } else {
                if (head.left == null) {
                    head.left = temp;
                }
                head = head.left;
            }
        }
        return root;
    }
}
