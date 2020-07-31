import java.util.*;
public class StringsWithNoConsecutiveOne {
	public static int NoConsecutiveOne(int n) {
		int[] dp=new int[n+1];
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.println(NoConsecutiveOne(n));
		sc.close();
	}

}
