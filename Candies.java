
import java.util.*;
public class Candies {
	public static long candies(int[] arr,int n) {
		long[] dp=new long[n];
		for(int i=0;i<n;i++) {
			dp[i]=1;
		}
		for(int i=1;i<n;i++) {
			if(arr[i]>arr[i-1]) {
				dp[i]=dp[i-1]+1;
			}
		}
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>arr[i+1]) {
				if(dp[i]<=dp[i+1]) {
					dp[i]=dp[i+1]+1;
				}
			}
		}
		long sum=0;
		for(int i=0;i<n;i++) {
			sum+=dp[i];
		}
		return sum;
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
		System.out.println(candies(arr,n));
		sc.close();
	}
}