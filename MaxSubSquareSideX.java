import java.util.*;
public class MaxSubSquareSideX {
	public static int MaxSize(char[][] mat,int row,int col) {
		int[][] horizontal=new int[row][col];
		int[][] vertical=new int[row][col];
		int count=0;
		for(int j=0;j<col;j++) {
			count=0;
			for(int i=0;i<row;i++) {
				if(mat[i][j]=='X') {
					count++;
				}
				else {
					count=0;
				}
				vertical[i][j]=count;
			}
		}
		count=0;
		for(int i=0;i<row;i++) {
			count=0;
			for(int j=0;j<col;j++) {
				if(mat[i][j]=='X') {
					count++;
				}
				else {
					count=0;
				}
				horizontal[i][j]=count;
			}
		}
		System.out.println("Answer: ");
		int size=0;
		int result=0;
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				size=0;
				if(mat[i][j]!='O') {
					size=1;
					int n=Math.min(horizontal[i][j], vertical[i][j]);
					for(int k=n-1;k>0;k--) {
						int r=i-k;
						int c=j-k;
						if(horizontal[r][j]>=k && vertical[i][c]>=k) {
							size=Math.max(size, k+1);
						}
					}
				}
				result=Math.max(size, result);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int row,col;
		char[][] mat;
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		mat=new char[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat[i][j]=sc.next().charAt(0);
			}
		}
		System.out.println(MaxSize(mat,row,col));
		sc.close();
	}
}