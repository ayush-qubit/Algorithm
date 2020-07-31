
import java.util.*;
public class HeapSort {
	private static final int LEFT(int n) {
		return 2*n+1;
	}
	private static final int RIGHT(int n) {
		return 2*n+2;
	}
	private static void MaxHeapify(int[] arr,int pos,int length) {
		int l=LEFT(pos);
		int r=RIGHT(pos);
		int largest;
		int n=length;
		if(l<n && arr[pos]<arr[l]) {
			largest=l;
		}
		else {
			largest=pos;
		}
		if(r<n && arr[largest]<arr[r]) {
			largest=r;
		}
		if(largest!=pos) {
			swap(arr,largest,pos);
			MaxHeapify(arr,largest,length);
		}
	}
	private static void BuildHeap(int[] arr,int n) {
		for(int i=n/2;i>=0;i--) {
			MaxHeapify(arr,i,n);
		}
	}
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void sort(int[] arr,int n) {
		BuildHeap(arr,n);
		int length=n;
		for(int i=n-1;i>0;i--) {
			swap(arr,i,0);
			length--;
			MaxHeapify(arr,0,length);
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
		sort(arr,n);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}