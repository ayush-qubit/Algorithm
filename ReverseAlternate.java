import java.util.*;
public class ReverseAlternate {
	static class Node{
		int data;
		Node next;
		Node(int d,Node ptr){
			data=d;
			next=ptr;
		}
	}
	static Node head=null;
	public static Node insert(Node head,int data) {
		if(head==null) {
			return new Node(data,null);
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=new Node(data,null);
			return head;
		}
	}
	public static void PrintLL(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static Node AlternateReverse(Node head) {
		if(head==null) {
			return null;
		}
		else {
			Stack<Node> stack=new Stack<Node>();
			Node temp=head;
			while(temp!=null) {
				stack.push(temp);
				temp=temp.next;
			}
			temp=head;
			Node temp2;
			Node head2=null;
			while(temp!=null) {
				temp2=stack.pop();
				head2=insert(head2,temp.data);
				head2=temp==temp2?head2:insert(head2,temp2.data);
				temp2.next=null;
				temp=temp.next==temp2?null:temp.next;
			}
			head=head2;
			return head;
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int data;
		for(int i=0;i<n;i++) {
			data=sc.nextInt();
			head=insert(head,data);
		}
		PrintLL(head);
		head=AlternateReverse(head);
		PrintLL(head);
		sc.close();
	}
}