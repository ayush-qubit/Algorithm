import java.util.*;

public class QuickSort {
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private static int partition(int[] arr,int low,int high) {
		int x;
		int i=low-1;
		x=arr[high];
		for(int j=low;j<high;j++) {
			if(x>=arr[j]) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}
	public static void sort(int[] arr,int low,int high) {
		if(low<high) {
			int pos=partition(arr,low,high);
			sort(arr,low,pos-1);
			sort(arr,pos+1,high);
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