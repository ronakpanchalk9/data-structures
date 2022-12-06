import java.util.ArrayList;

// Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

public class pair_sum_DLL {
    Node head;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    static ArrayList<ArrayList<Integer>> findPair(int target, Node head) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node tbeg = head;
        Node tlast = head;

        while (tlast.next != null) {
            tlast = tlast.next;
        }

        while (tbeg.val < tlast.val) {
            if (tlast.val + tbeg.val == target) {
                l1.add(tbeg.val);
                l1.add(tlast.val);
                ans.add(l1);
                tbeg = tbeg.next;
                tlast = tlast.prev;
            } else if (tlast.val + tbeg.val < target) {
                tbeg = tbeg.next;
            } else {
                tlast = tlast.prev;
            }
        }
        return ans;
    }
}
