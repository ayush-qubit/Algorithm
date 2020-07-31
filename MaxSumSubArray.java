import java.util.*;
public class MaxSumSubArray {
	public static int KadanesAlgo(int[] arr,int n) {
		int current=0;
		int max_sum=0;
		int current_start=0;
		int max_start=-1;
		int max_end=-1;
		for(int i=0;i<n;i++) {
			current+=arr[i];
			if(current<0) {
				current=0;
				current_start=i+1;
			}
			else if(current>max_sum) {
				max_start=current_start;
				max_end=i;
				max_sum=current;
			}
		}
		System.out.println(max_start+" "+max_end);
		return max_sum;
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
		System.out.println(KadanesAlgo(arr,n));
		sc.close();
	}

}
