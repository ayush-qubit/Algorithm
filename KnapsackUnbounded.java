
import java.util.*;
public class KnapsackUnbounded {
	public static int MaxProfit(int[] val,int[] weight,int W,int n) {
		int[] dp=new int[W+1];
		dp[0]=0;
		for(int i=1;i<=W;i++) {
			dp[i]=0;
			for(int j=0;j<n;j++) {
				if(weight[j]<=i) {
					dp[i]=Math.max(dp[i], dp[i-weight[j]]+val[j]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[W];
	}
	public static void main(String[] args) {
		int n,W;
		int[] val,weight;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		val=new int[n];
		weight=new int[n];
		for(int i=0;i<n;i++) {
			val[i]=sc.nextInt();
			weight[i]=sc.nextInt();
		}
		W=sc.nextInt();
		System.out.println(MaxProfit(val,weight,W,n));
		sc.close();
	}

}
