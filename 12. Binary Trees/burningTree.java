// Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
// Note: The tree contains unique values.
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class burningTree {
    static Node parent(Node root, int target, HashMap<Node, Node> parentNodes) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        Node targetNode = null;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) {
                targetNode = curr;
            }
            if (curr.left != null) {
                parentNodes.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parentNodes.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }

    static int totalnodes(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        int size = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                size++;
            }
            if (curr.right != null) {
                q.add(curr.right);
                size++;
            }
        }
        return size;
    }

    static int minTime(Node root, int target) {
        HashMap<Node, Boolean> burnt = new HashMap<>();
        HashMap<Node, Node> parentNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<Node>();
        int minTime = 0;
        Node targetNode = null;
        int qsize = 0;
        int treesize = 0;

        targetNode = parent(root, target, parentNodes);
        treesize = totalnodes(root);

        if (treesize == 1) {
            return 0;
        }

        q.offer(targetNode);
        burnt.put(targetNode, true);

        while (!q.isEmpty()) {
            qsize = q.size();

            for (int i = 0; i < qsize; i++) {
                Node curr = q.poll();
                if (curr.left != null && burnt.get(curr.left) == null) {
                    q.add(curr.left);
                    burnt.put(curr.left, true);
                }

                if (curr.right != null && burnt.get(curr.right) == null) {
                    q.add(curr.right);
                    burnt.put(curr.right, true);
                }

                if (parentNodes.get(curr) != null && burnt.get(parentNodes.get(curr)) == null) {
                    q.add(parentNodes.get(curr));
                    burnt.put(parentNodes.get(curr), true);
                }
            }
            minTime++;

            if (burnt.size() == treesize) {
                return minTime;
            }
        }

        return minTime;
    }
}