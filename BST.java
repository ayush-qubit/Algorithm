import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST{
    static class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static Node root=null;
    public static Queue<Node> queue=new LinkedList<Node>();
    public static Stack<Node> stack=new Stack<Node>();
    public static Node insertNode(int data,Node root) {
        if(root==null){
            return new Node(data,null,null);
        }else{
            if(data<=root.data){
                root.left=insertNode(data, root.left);
            }else{
                root.right=insertNode(data, root.right);
            }
            return root;
        }
    }
    public static boolean validateTree(Node root,int minValue,int maxValue) {
        if(root==null){
            return true;
        }else{
            boolean current=false,leftTree=false,rightTree=false;
            if(root.data>=minValue && root.data<maxValue){
                current=true;
            }
            leftTree=validateTree(root.left, minValue, root.data);
            rightTree=validateTree(root.right, root.data+1, maxValue);
            return current && leftTree && rightTree;
        }
    } 
    public static void reverseLevelOrder(Node root) {
        if(root==null){
            System.out.println("Tree is Empty...");
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            stack.push(temp);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data+" ");            
        }
        System.out.println();
    }
    public static void levelOrderTraversal(Node root){
        if(root==null){
            System.out.println("Tree is Empty...");
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        System.out.println();
    }
    public static void SpiralLevelOrder(Node root){
        if (root==null) {
            System.out.println("Tree is Empty...");
            return;
        }
        Stack<Node> stack1=new Stack<Node>();
        Stack<Node> stack2=new Stack<Node>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node temp=stack1.pop();
                if(temp.right!=null){
                    stack2.push(temp.right);
                }
                if(temp.left!=null){
                    stack2.push(temp.left);
                }
                System.out.print(temp.data+" ");
            }
            while (!stack2.isEmpty()) {
                Node temp=stack2.pop();
                if(temp.left!=null){
                    stack1.push(temp.left);
                }
                if(temp.right!=null){
                    stack1.push(temp.right);
                }
                System.out.print(temp.data+" ");
            }
        }
    }
    public static void main(String[] args) {
        root=new Node(10,null,null);
        root.left=new Node(2,null,null);
        root.right=new Node(15,null,null);
        root.left.left=new Node(1,null,null);
        root.left.right=new Node(3,null,null);
        root.right.left=new Node(12,null,null);
        root.right.right=new Node(16,null,null);
        System.out.println(validateTree(root, Integer.MIN_VALUE,Integer.MAX_VALUE));
        reverseLevelOrder(root);
        levelOrderTraversal(root);     
        SpiralLevelOrder(root);
    }
}