public class BinaryTree{
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static Node root=null;
    public static Node LowestCommonAncestor(Node root,int low,int high){
        if(root==null){
            return null;
        }
        else if(root.data==low || root.data==high){
            return root;
        }
        else{
            Node a=LowestCommonAncestor(root.left,low,high);
            Node b=LowestCommonAncestor(root.right,low,high);
            if(a==null && b==null){
                return null;
            }
            else if(a==null){
                return b;
            }
            else if(b==null){
                return a;
            }
            else{
                return root;
            }
        }
    }
    public static void main(String[] args) {
        root=new Node(3);
        root.left=new Node(6);
        root.right=new Node(8);
        root.left.left=new Node(2);
        root.left.right=new Node(11);
        root.right.right=new Node(13);
        root.left.right.left=new Node(9);
        root.left.right.right=new Node(5);
        root.right.right.left=new Node(7);
        Node temp=LowestCommonAncestor(root,7,8);
        if(temp!=null){
            System.out.println(temp.data);
        }
        else{
            System.out.println("No ancestor...");
        }
    }
}