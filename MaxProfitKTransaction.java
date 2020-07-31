import java.util.*;
public class MaxProfitKTransaction {
	public static int MaxProfit(int[] price,int n,int k) {
		int[][] dp=new int[k+1][n];
		int maxdiff=Integer.MIN_VALUE;
		for(int i=1;i<k+1;i++) {
			for(int j=1;j<n;j++) {
				maxdiff=Integer.MIN_VALUE;
				for(int m=0;m<j;m++) {
					maxdiff=Math.max(maxdiff, dp[i-1][m]-price[m]);
				}
				dp[i][j]=Math.max(dp[i][j-1], price[j]+maxdiff);
			}
		}
		return dp[k][n-1];
	}
	public static void main(String[] args) {
		int[] price;
		int k,n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		price=new int[n];
		for(int i=0;i<n;i++) {
			price[i]=sc.nextInt();
		}
		k=sc.nextInt();
		System.out.println(MaxProfit(price,n,k));
		sc.close();
	}
}