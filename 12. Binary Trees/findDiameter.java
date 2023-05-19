// The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).


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

public class findDiameter{
    static int height(Node root, int[] maxi){
        if(root == null){
            return 0;
        }
        int l = height(root.left, maxi);
        int r = height(root.right, maxi);
        maxi[0] = Math.max(maxi[0], l+r+1);
        return 1 + Math.max(l,r);
        
    }
    
    int diameter(Node root) {
        // Your code here
        int[] maxi = new int[1];
        height(root, maxi);
        return maxi[0];
    }
}