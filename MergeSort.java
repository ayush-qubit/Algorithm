import java.util.*;
public class MergeSort {
	private static void merge(int[] arr,int low1,int high1,int low2,int high2) {
		int n=high2-low1+1;
		int[] temp=new int[n];
		int i=low1,j=low2,k=0;
		while(i<=high1 && j<=high2) {
			if(arr[i]<=arr[j]) {
				temp[k++]=arr[i++];
			}
			else {
				temp[k++]=arr[j++];
			}
		}
		while(i<=high1) {
			temp[k++]=arr[i++];
		}
		while(j<=high2) {
			temp[k++]=arr[j++];
		}
		for(int l=low1;l<=high2;l++) {
			arr[l]=temp[l-low1];
		}
	}
	public static void sort(int[] arr,int low,int high) {
		int mid;
		if(low<high) {
			mid=(low+high)/2;
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			merge(arr,low,mid,mid+1,high);
		}
	}
	public static void main(String[] args) {
		int[] arr;
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sort(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}