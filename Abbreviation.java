import java.util.*;
public class Abbreviation {
	public static String abbreviation(String a,String b) {
		int col=a.length();
		int row=b.length();
		boolean[][] dp=new boolean[row+1][col+1];
		dp[0][0]=true;
		for(int i=1;i<=col;i++) {
			if(Character.isLowerCase(a.charAt(i-1))) {
				dp[0][i]=dp[0][i-1];
			}
			else {
				dp[0][i]=false;
			}
		}
		for(int i=1;i<=row;i++) {
			dp[i][0]=false;
		}
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				if(j<i) {
					dp[i][j]=false;
				}
				else if(a.charAt(j-1)==b.charAt(i-1)) {
					dp[i][j]=dp[i-1][j-1];
				}
				else if(a.charAt(j-1)!=b.charAt(i-1) && Character.isLowerCase(a.charAt(j-1))) {
					if(Character.toUpperCase(a.charAt(j-1))==b.charAt(i-1)) {
						dp[i][j]=dp[i-1][j-1] || dp[i][j-1];
					}
					else {
						dp[i][j]=dp[i][j-1];
					}
				}
				else {
					dp[i][j]=false;
				}
			}
		}
		if(dp[row][col]==true) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	public static void main(String[] args) {
		String a,b;
		Scanner sc=new Scanner(System.in);
		a=sc.next();
		b=sc.next();
		System.out.println(abbreviation(a,b));
		sc.close();
	}
}