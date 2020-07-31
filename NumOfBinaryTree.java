import java.util.*;
public class NumOfBinaryTree {
	public static int NumOfTree(int n) {
		int[] dp=new int[n+1];
		for(int i=0;i<=n;i++) {
			if(i==0 || i==1) {
				dp[i]=1;
			}
			else if(i==2) {
				dp[i]=2;
			}
			else {
				for(int k=0;k<i;k++) {
					dp[i]+=dp[k]*dp[i-k-1];
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.println(NumOfTree(n));
		sc.close();
	}
}
