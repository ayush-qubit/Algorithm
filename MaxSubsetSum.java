import java.util.*;
public class MaxSubsetSum {
	public static int max(int a,int b,int c) {
		if(a>=b) {
			if(a>c) {
				return a;
			}
			else {
				return c;
			}
		}
		else {
			if(b>=c) {
				return b;
			}
			else {
				return c;
			}
		}
	}
	public static int MaxSum(int[] arr,int n) {
		if(n<=2) {
			return 0;
		}
		else {
			int[] dp=new int[n];
			dp[0]=arr[0];
			dp[1]=Math.max(arr[0], arr[1]);
			for(int i=2;i<n;i++) {
				dp[i]=max(dp[i-1],arr[i],dp[i-2]+arr[i]);
			}
			System.out.println(Arrays.toString(dp));
			return dp[n-1];
		}
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
		System.out.println(MaxSum(arr,n));
		sc.close();
	}

}
