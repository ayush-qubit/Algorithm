package algorithm;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TripletSum {
	public static int CountTriplets(ArrayList<Integer> array,int x) {
		int result=0;
		int n=array.size();
		for(int i=0;i<n-2;i++) {
			int j=i+1;
			int k=n-1;
			while(j<k) {
				int sum=array.get(j)+array.get(k)+array.get(i);
				if(sum>x) {
					k--;
				}
				else {
					result+=(k-j);
					j++;
				}
			}
		}
		return result;
	}
	public static int Solution(ArrayList<Integer> array,int low,int high) {
		int count1=0,count2=0;
		Collections.sort(array);
		count1=CountTriplets(array,high);
		count2=CountTriplets(array,low-1);
		return count1-count2;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			array.add(sc.nextInt());
		}
		int low=sc.nextInt();
		int high=sc.nextInt();
		System.out.println(Solution(array,low,high));
		sc.close();
	}

}
