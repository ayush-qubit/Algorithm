import java.util.*;

public class LinkedList{
    private static class Node{
        int data;
        Node nextNode;
        Node(int data){
            this.data=data;
            nextNode=null;
        }
    }
    private static Node head=null;
    public static Node insertNode(int data,Node head){
        if(head==null){
            return new Node(data);
        }else{
            Node temNode=new Node(data);
            temNode.nextNode=head;
            head=temNode;
            return head;
        }
    }
    public static void printLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.nextNode;
        }
        System.out.println();
    }
    public static Node reverseList(Node head){
        if(head==null){
            return null;
        }else{
            Node head2=null;
            while(head!=null){
                head2=insertNode(head.data,head2);
                head=head.nextNode;
            }
            return head2;
        }
    }
    public static int isPalindrome(Node head){
        int flag=1;
        Node slow=head,fast=head.nextNode;
        while(fast!=null && fast.nextNode!=null){
            slow=slow.nextNode;
            fast=fast.nextNode.nextNode;
        }
        slow.nextNode=reverseList(slow.nextNode);
        Node a=head,b=slow.nextNode;
        while(a!=null && b!=null){
            if(a.data!=b.data){
                flag=0;
                break;
            }
            a=a.nextNode;
            b=b.nextNode;
        }
        slow.nextNode=reverseList(slow.nextNode);
        return flag;
    }
    public static void main(String[] args) {
       int q;
       Scanner sc=new Scanner(System.in);
       q=sc.nextInt();
       while(q-->0){
           int n=sc.nextInt();
           for(int i=0;i<n;i++){
               int data=sc.nextInt();
               head=insertNode(data, head);
           }
           System.out.println(isPalindrome(head));
       }
       sc.close();
    }
}