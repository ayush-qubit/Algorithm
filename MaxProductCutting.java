import java.util.*;
public class MaxProductCutting {
	public static int MaxCut(int n) {
		if(n==1 || n==0) {
			return 1;
		}
		int[] dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		int q=Integer.MIN_VALUE;
		for(int l=2;l<=n;l++) {
			q=Integer.MIN_VALUE;
			for(int i=1;i<l;i++) {
				q=Math.max(i*(l-i), i*dp[l-i]);
				dp[l]=Math.max(dp[l], q);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.println(MaxCut(n));
		sc.close();
	}

}
