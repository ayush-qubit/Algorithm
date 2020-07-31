
import java.util.Scanner;

public class BurstingBalloon {
	public static int MaxCost(int[] arr,int n) {
		int[][] dp=new int[n][n];
		for(int len=0;len<n;len++) {
			for(int i=0,j=len;i<n-len && j<n;i++,j++) {
				int l=i-1<0?1:arr[i-1];
				int r=j+1>n-1?1:arr[j+1];
				if(i==j) {
					dp[i][j]=l*arr[i]*r;
				}
				else {
					int q=Integer.MIN_VALUE;
					int left,right;
					for(int k=i;k<=j;k++) {
						left=k-1<i?0:dp[i][k-1];
						right=k+1>j?0:dp[k+1][j];
						q=Math.max(q, left+right+l*arr[k]*r);
					}
					dp[i][j]=q;
				}
			}
		}
		return dp[0][n-1];
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
		System.out.println(MaxCost(arr,n));
		sc.close();
	}
}
