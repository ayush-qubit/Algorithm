import java.util.*;
public class RoundA{
    public static int max(int a,int b,int c){
        return a>b&&a>c?a:b>c?b:c;
    }
    public static void printSolution(char[][] sol,int row,int col,char[] S){
        int i=row-1,j=col-1;
        while(i!=0 && j!=0){
            if(sol[i][j]=='\\'){
                System.out.print(S[i-1]);
                i--;
                j--;
            }else if(sol[i][j]=='|'){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println();
    }
    public static int Solution(String s){
        int n=s.length();
        char[] S1=s.toCharArray();
        char[] S2=new char[n];
        for(int i=n-1,j=0;i>=0 && j<n;i--,j++){
            S2[i]=S1[j];
        }
        int[][] dp=new int[n+1][n+1];
        char[][] sol=new char[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    sol[i][j]='\0';
                }else if(S1[i-1]==S2[j-1]){
                    char ch1=i-2<0?'\0':S1[i-2];
                    char ch2=j-2<0?'\0':S2[j-2];
                    if(ch1!='\0' && ch2!='\0'){
                        if(ch1==ch2){
                            dp[i][j]=dp[i-1][j-1]+1;
                            sol[i][j]='\\';
                        }else{
                            dp[i][j]=max(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]+1);
                            if(dp[i][j]==dp[i][j-1]){
                                sol[i][j]='-';
                            }else if(dp[i][j]==dp[i-1][j]){
                                sol[i][j]='|';
                            }else{
                                sol[i][j]='\\';
                            }
                        }
                    }else{
                        dp[i][j]=dp[i-1][j-1]+1;
                        sol[i][j]='\\';
                    }
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    if(dp[i][j]==dp[i-1][j]){
                        sol[i][j]='|';
                    }else{
                        sol[i][j]='-';
                    }
                }
            }
        }
        printSolution(sol,n+1,n+1,S1);
        return dp[n][n];
    }
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        s=sc.next();
        System.out.println(Solution(s));
        sc.close();
    }
}