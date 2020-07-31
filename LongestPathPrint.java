import java.util.ArrayList;

public class LongestPathPrint {
	static class Node{
		int data;
		Node left,right;
		Node(int d,Node l,Node r){
			left=l;
			right=r;
			data=d;
		}
	}
	static Node root=null;
	public static ArrayList<Integer> MaxLengthValues(Node root){
		if(root==null) {
			return new ArrayList<Integer>();
		}
		else {
			ArrayList<Integer> left=MaxLengthValues(root.left);
			ArrayList<Integer> right=MaxLengthValues(root.right);
			if(left.size()>right.size()) {
				left.add(0, root.data);
				return left;
			}
			else {
				right.add(0, root.data);
				return right;
			}
		}
	}
	public static void main(String[] args) {
		root=new Node(1,null,null);
		root.left=new Node(2,null,null);
		root.right=new Node(3,null,null);
		root.left.left=new Node(4,null,null);
		root.left.right=new Node(5,null,null);
		root.left.right.right=new Node(6,null,null);
		ArrayList<Integer> list=MaxLengthValues(root);
		System.out.println(list);
	}
}