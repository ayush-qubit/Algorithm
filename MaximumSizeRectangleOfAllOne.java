import java.util.*;
public class MaximumSizeRectangleOfAllOne {
	public static int MaxAreaHistogram(int[] hist,int n) {
		int area=0;
		int length=0,breadth=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(hist[i]==0) {
				length=0;
				breadth=Integer.MAX_VALUE;
			}
			else {
				length++;
				breadth=Math.min(breadth, hist[i]);
				area=Math.max(area, length*breadth);
			}
		}
		return area;
	}
	public static int MaxSizeRectangle(int[][] arr,int row,int col) {
		int area=0;
		int[] hist=new int[col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j]==0) {
					hist[j]=0;
				}
				else {
					hist[j]+=arr[i][j];
				}
			}
			area=Math.max(area,MaxAreaHistogram(hist,col));
		}
		return area;
	}
	public static void main(String[] args) {
		int[][] arr;
		int row,col;
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		arr=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println(MaxSizeRectangle(arr,row,col));
		sc.close();
	}

}
