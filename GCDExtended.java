
import java.util.*;
public class GCDExtended {
	static class Coefficient{
		int x,y;
		Coefficient(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static Coefficient coeff=null;
	public static int ExtendedEuclidean(int a,int b) {
		if(a==0) {
			coeff=new Coefficient(0,1);
			return b;
		}
		else {
			int gcd=ExtendedEuclidean(b%a,a);
			int x,y;
			x=coeff.y-Math.floorDiv(b, a)*coeff.x;
			y=coeff.x;
			coeff=new Coefficient(x,y);
			return gcd;
		}
	}
	public static int euclidean(int a,int b) {
		if(a==0) {
			return b;
		}
		else {
			return euclidean(b%a,a);
		}
	}
	public static void main(String[] args) {
		int a,b;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.println("GCD("+a+","+b+") :"+ExtendedEuclidean(a,b));
		System.out.println(a+"*"+coeff.x+" + "+b+"*"+coeff.y);
		sc.close();
	}

}
