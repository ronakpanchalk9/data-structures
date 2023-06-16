import org.w3c.dom.Node;

public class countNodes {
    static int leftHeight(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    static int rightHeight(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
    public static int totalnodes(Node root) {
        if(root == null){
            return 0;
        }

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh){
            return (1 << lh) - 1;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.rigt);

        return leftNodes + rightNodes + 1;
    }
}
