import java.util.*;
public class MaxSumRectangle {
	static class KadanesResult{
		int sum;
		int max_left,max_right;
		KadanesResult(int sum,int max_left,int max_right){
			this.sum=sum;
			this.max_left=max_left;
			this.max_right=max_right;
		}
	}
	public static KadanesResult KadanesAlgo(int[] arr,int n) {
		int current=0,max_sum=0;
		int current_start=0;
		int max_left=-1,max_right=-1;
		for(int i=0;i<n;i++) {
			current+=arr[i];
			if(current<0) {
				current=0;
				current_start=i+1;
			}
			else if(current>max_sum) {
				max_left=current_start;
				max_right=i;
				max_sum=current;
			}
		}
		return new KadanesResult(max_sum,max_left,max_right);
	}
	public static int MaxSum(int[][] arr,int row,int col) {
		int current=0,max_sum=0;
		int dp[]=new int[row];
		int max_left=0,max_right=0;
		int max_up=0,max_down=0;
		KadanesResult result;
		for(int l=0;l<col;l++) {
			for(int j=0;j<row;j++) {
				dp[j]=0;
			}
			for(int r=l;r<col;r++) {
				for(int i=0;i<row;i++) {
					dp[i]+=arr[i][r];
				}
				result=KadanesAlgo(dp,row);
				current=result.sum;
				if(current<0) {
					current=0;
				}
				else if(current>max_sum) {
					max_left=l;
					max_right=r;
					max_up=result.max_left;
					max_down=result.max_right;
					max_sum=current;
				}
			}
		}
		for(int i=max_up;i<=max_down;i++) {
			for(int j=max_left;j<=max_right;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return max_sum;
	}
	public static void main(String[] args) {
		int row=4,col=5;
		int[][] arr;
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		arr=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println(MaxSum(arr,row,col));
		sc.close();
	}
}