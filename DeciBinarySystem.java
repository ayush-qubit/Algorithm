import java.util.ArrayList;
import java.util.Scanner;
public class DeciBinarySystem{
	private static ArrayList<Integer> array=new ArrayList<Integer>();
	private static final Scanner sc=new Scanner(System.in);
	public static void gen(final int d, final int s, final int v) {
		if (s < 0 || s > 9 * ((1 << (d + 1))) - 1) {
			return;
		} else if (s == 0 && d == -1) {
			array.add(v);

		} else {
			for (int i = 0; i < 9; i++) {
				gen(d - 1, s - i * (1 << d), v * 10 + i);
			}
		}
	}

	public static void main(final String[] args) {
		int pos;
		for(int i=0;i<50;i++){
			gen(20, i, 0);
		}
		pos=sc.nextInt();
		System.out.println(array.get(pos-1));
		sc.close();
	}
}