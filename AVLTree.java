public class AVLTree{
    public static class Node{
        int data;
        Node left,right;
        int ht;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
            ht=0;
        }
    }
    public static Node root=null;
    public static int getHeight(Node root){
        int LeftHeight=root.left!=null?root.left.ht:-1;
        int RightHeight=root.right!=null?root.right.ht:-1;
        return Math.max(LeftHeight,RightHeight)+1;
    }
    public static int getBalanceFactor(Node root){
        int LeftHeight=root.left!=null?root.left.ht:-1;
        int RightHeight=root.right!=null?root.right.ht:-1;
        return LeftHeight-RightHeight;
    }
    public static Node BalanceTree(Node root){
        if(root.left!=null && root.left.left!=null){
            Node A=root,B=root.left;
            Node BRight=B.right;
            B.right=A;
            A.left=BRight;
            root=B;
        }
        else if(root.right!=null && root.right.right!=null){
            Node A=root,B=root.right;
            Node BLeft=B.left;
            B.left=A;
            A.right=BLeft;
            root=B;
        }
        else if(root.left!=null && root.left.right!=null){
            Node A=root,B=root.left,C=root.left.right;
            Node CLeft=C.left,CRight=C.right;
            C.left=B;
            C.right=A;
            B.right=CLeft;
            A.left=CRight;
            root=C;
        }
        else if(root.right!=null && root.right.left!=null){
            Node A=root,B=root.right,C=root.right.left;
            Node CLeft=C.left,CRight=C.right;
            C.left=A;
            C.right=B;
            A.right=CLeft;
            B.left=CRight;
            root=C;
        }
        root.left.ht=getHeight(root.left);
        root.right.ht=getHeight(root.right);
        return root;
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else if(data<=root.data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        int balanceFactor=getBalanceFactor(root);
        if(-1<=balanceFactor && balanceFactor<=1){
            root.ht=getHeight(root);
            return root;
        }
        else{
            root=BalanceTree(root);
            root.ht=getHeight(root);
            return root;
        }
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        else{
            inorder(root.left);
            System.out.println(root.data+" "+getBalanceFactor(root));
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        root=insert(root,3);
        root=insert(root,2);
        root=insert(root,4);
        root=insert(root,5);
        inorder(root);       
    }
}