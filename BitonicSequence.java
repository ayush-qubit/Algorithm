import java.util.*;
public class BitonicSequence {
	public static int BSequence(int[] arr,int n) {
		int[] dp1=new int[n];
		int[] dp2=new int[n];
		dp1[0]=1;
		dp2[n-1]=1;
		for(int i=1;i<n;i++) {
			dp1[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp1[i]=Math.max(dp1[i],dp1[j]+1);
				}
			}
		}
		for(int i=n-2;i>=0;i--) {
			dp2[i]=1;
			for(int j=n-1;j>i;j--) {
				if(arr[j]<arr[i]) {
					dp2[i]=Math.max(dp2[i], dp2[j]+1);
				}
			}
		}
		int q=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			dp2[i]=dp2[i]+dp1[i]-1;
			q=Math.max(q, dp2[i]);
		}
		return q;
	}
	public static void main(String[] args) {
		int[] arr;
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(BSequence(arr,n));
		sc.close();
	}
}
