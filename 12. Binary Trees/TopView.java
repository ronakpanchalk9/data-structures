// Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
import java.util.*;
class TopView {
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

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> mpp = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (!mpp.containsKey(curr.hd)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                mpp.put(curr.hd, temp);
            }

            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : mpp.entrySet()) {
            ans.addAll(entry.getValue());
        }

        return ans;

    }

    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.node = node;
            this.hd = hd;
        }
    }
}
