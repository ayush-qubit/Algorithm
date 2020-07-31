import java.util.Scanner;
public class DoublyLinkedList{
    static class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static Node head=null;
    public static  Node insertNode(Node head,int data){
        if(head==null){
            return new Node(data,null,null);
        }
        else{
            Node temp=new Node(data,null,null);
            temp.right=head;
            head.left=temp;
            head=temp;
            return head;
        }
    }
    public static void displayLinkedList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.right;
        }
    }
    public static Node reverseNode(Node head){
        if(head==null){
            return null;
        }
        else{
            //Node a,b;
            Node temp=head;
            Node head2=null;
            while(temp!=null){
                head2=insertNode(head2, temp.data);
                temp=temp.right;
            }
            return head2;
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            head=insertNode(head, data);
        }
        displayLinkedList(head);
        head=reverseNode(head);
        System.out.println("Reverse List is: ");
        displayLinkedList(head);
        sc.close();
    }
}