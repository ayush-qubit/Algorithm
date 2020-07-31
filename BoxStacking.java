
import java.util.*;
public class BoxStacking {
	static class Box{
		int length,breadth,height;
		Box(int l,int b,int h){
			length=l;
			breadth=b;
			height=h;
		}
	}
	public static boolean ifStack(Box B1,Box B2) {
		if(B2.length<B1.length && B2.breadth<B1.breadth) {
			return true;
		}
		else if(B2.length<B1.breadth && B2.breadth<B1.length) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void PrintBox(Box[] B,int n) {
		for(int i=0;i<n;i++) {
			System.out.println(B[i].length+" "+B[i].breadth+" "+B[i].height);
		}
	}
	public static int MaxHeight(Box[] B,int n) {
		int[] result=new int[n];
		int q=Integer.MIN_VALUE;
		Arrays.sort(B,new Comparator<Box>(){
			@Override
			public int compare(Box o1, Box o2) {
				int area1=o1.length*o1.breadth;
				int area2=o2.length*o2.breadth;
				if(area1>=area2) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		result[0]=B[0].height;
		for(int i=1;i<n;i++) {
			result[i]=B[i].height;
			for(int j=0;j<i;j++) {
				if(ifStack(B[j],B[i])) {
					result[i]=Math.max(result[i], B[j].height+B[i].height);
				}
				else {
					result[i]=Math.max(result[i], B[j].height);
				}
			}
			q=Math.max(q, result[i]);
		}
		System.out.println(Arrays.toString(result));
		return Math.max(q, result[0]);
	}
	public static void main(String[] args) {
		int n;
		int[] length,breadth,height;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		length=new int[n];
		breadth=new int[n];
		height=new int[n];
		for(int i=0;i<n;i++) {
			length[i]=sc.nextInt();
			breadth[i]=sc.nextInt();
			height[i]=sc.nextInt();
		}
		Box[] B=new Box[3*n];
		for(int i=0,k=0;i<n && k<3*n;i++,k+=3) {
			B[k]=new Box(length[i],breadth[i],height[i]);
			B[k+1]=new Box(height[i],breadth[i],length[i]);
			B[k+2]=new Box(length[i],height[i],breadth[i]);
		}
		System.out.println(MaxHeight(B,3*n));
		sc.close();
	}
}