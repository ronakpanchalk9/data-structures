public class stack_using_LL {
    class MyStack 
{
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
        newNode.next = null;
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        StackNode temp = top;
        if(temp == null){
            return -1;
        }
        
        int topData = top.data;
        
        top = top.next;
        return topData;
    }
}
}
