import java.util.*;
public class MinInserForPalindrome {
	public static int MinInsertion(String str) {
		int n=str.length();
		int[][] dp=new int[n][n];
		for(int l=0;l<n;l++) {
			for(int i=0,j=l;i<n-l && j<n;i++,j++) {
				if(i==j) {
					dp[i][j]=0;
				}
				else if(i==j-1) {
					if(str.charAt(i)==str.charAt(j)) {
						dp[i][j]=0;
					}
					else {
						dp[i][j]=1;
					}
				}
				else {
					if(str.charAt(i)==str.charAt(j)) {
						dp[i][j]=dp[i+1][j-1];
					}
					else {
						dp[i][j]=1+Math.min(dp[i+1][j], dp[i][j-1]);
					}
				}
			}
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		String str;
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		System.out.println(MinInsertion(str));
		sc.close();
	}

}
