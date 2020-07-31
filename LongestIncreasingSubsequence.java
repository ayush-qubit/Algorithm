
import java.util.*;
public class LongestIncreasingSubsequence {
	public static int LISS(int[] arr,int n) {
		int[] dp=new int[n];
		dp[0]=1;
		int q=Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			q=Math.max(q, dp[i]);
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
		System.out.println(LISS(arr,n));
		sc.close();
	}
}
