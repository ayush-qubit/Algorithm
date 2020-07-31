import java.util.*;
public class RunningMedian {
	public static void Balance(PriorityQueue<Integer> MaxHeap,PriorityQueue<Integer> MinHeap) {
		if(MaxHeap.peek()>MinHeap.peek()) {
			int a=MaxHeap.remove();
			int b=MinHeap.remove();
			MaxHeap.add(b);
			MinHeap.add(a);
		}
		if(MaxHeap.size()>MinHeap.size()+1) {
			MinHeap.add(MaxHeap.remove());
		}
	}
	public static float GetMedian(PriorityQueue<Integer> MaxHeap,PriorityQueue<Integer> MinHeap) {
		float median;
		if(MinHeap.isEmpty()) {
			median=(float)MaxHeap.element();
		}
		else if(MaxHeap.size()==MinHeap.size()) {
			median=(float)(MaxHeap.element()+MinHeap.element())/2;
		}
		else {
			median=(float)MaxHeap.element();
		}
		return median;
	}
	public static void FindMedian(int[] arr,int n) {
		PriorityQueue<Integer> MaxHeap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				if(a.intValue()>b.intValue()) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		PriorityQueue<Integer> MinHeap=new PriorityQueue<Integer>();
		for(int i=0;i<n;i++) {
			if(MaxHeap.isEmpty()) {
				MaxHeap.add(arr[i]);
			}
			else if(MinHeap.isEmpty()) {
				MinHeap.add(arr[i]);
			}
			else if(MaxHeap.size()==MinHeap.size()) {
				MaxHeap.add(arr[i]);
				Balance(MaxHeap,MinHeap);
			}
			else if(arr[i]<=MaxHeap.element()) {
				MaxHeap.add(arr[i]);
				Balance(MaxHeap,MinHeap);
			}
			else {
				MinHeap.add(arr[i]);
				Balance(MaxHeap,MinHeap);
			}
			System.out.println(GetMedian(MaxHeap,MinHeap));
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
		FindMedian(arr,n);
		sc.close();
	}
}