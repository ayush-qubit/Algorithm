
import java.util.*;
public class FractionalKnapsackUnbounded {
	static class Item{
		int value,weight;
		double ratio;
		Item(int value,int weight){
			this.value=value;
			this.weight=weight;
			ratio=(double)value/weight;
		}
	}
	public static double MaxProfit(Item[] item,int W,int n) {
		Arrays.sort(item,new Comparator<FractionalKnapsackUnbounded.Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				if(o1.ratio>o2.ratio) {
					return -1;
				}
				else {
					return 1;
				}
			}
			
		});
		double a=(double)W/item[0].weight;
		return a*item[0].value;
	}
	public static void main(String[] args) {
		int n,W;
		int value,weight;
		Item[] item;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		item=new Item[n];
		for(int i=0;i<n;i++) {
			value=sc.nextInt();
			weight=sc.nextInt();
			item[i]=new Item(value,weight);
		}
		W=sc.nextInt();
		System.out.println(MaxProfit(item,W,n));
		sc.close();
	}
}
