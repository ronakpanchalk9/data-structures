class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Tree
{
    static void left(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        left(root.left, ans);
                ans.add(root.data);
        left(root.right, ans);
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      Queue<Node> q = new LinkedList<Node>();
      ArrayList<Integer> ans = new ArrayList<>();
      q.add(root);
      if(root == null){
          return ans;
      }
      
      while(!q.isEmpty()){
          int lvl = q.size();
          int sub = 0;
          
            for(int i = 0; i < lvl; i++){
              if(q.peek().left != null){
                  q.offer(q.peek().left);
              }
              if(q.peek().right != null){
                  q.offer(q.peek().right);
                }
              
                if(i == 0){
                  sub = q.poll().data;
                }else{
                  q.poll();
                }
              
            }
        ans.add(sub);
      }
      return ans;
    }
}
