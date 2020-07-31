import java.util.*;
public class MaxSumIncreasingSubSeq {
	public static int MaxSum(int[] arr,int n) {
		int[] dp=new int[n];
		dp[0]=arr[0];
		int q=Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			dp[i]=arr[i];
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i], dp[j]+arr[i]);
				}
			}
			q=Math.max(q, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return Math.max(q, dp[0]);
	}
	public static void main(String[] args) {
		int n;
		int[] arr;
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