import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available.
// Note: You have to return list in sorted order.

class Node {
    int data;
    Node left, right;
}

class nodesAtDistance {
    static void parent(Node root, HashMap<Node, Node> parent_nodes, int targetnode, Node nodefound) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == targetnode) {
                nodefound = curr;
            }
            if (curr.left != null) {
                q.offer(curr.left);
                parent_nodes.put(curr.left, curr);
            }
            if (curr.right != null) {
                q.offer(curr.right);
                parent_nodes.put(curr.right, curr);
            }
        }
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        HashMap<Node, Node> parent_nodes = new HashMap<>();
        Queue<Node> q = new LinkedList<Node>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        Node nodefound = parent(root, parent_nodes, target);

        q.offer(nodefound);
        visited.put(nodefound, true);

        int curr_lvl = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (curr_lvl == k) {
                break;
            }

            curr_lvl++;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_nodes.get(curr) != null && visited.get(parent_nodes.get(curr)) == null) {
                    q.offer(parent_nodes.get(curr));
                    visited.put(parent_nodes.get(curr), true);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Node curr = q.poll();
            result.add(curr.data);
        }
        Collections.sort(result);
        return result;
    }
}