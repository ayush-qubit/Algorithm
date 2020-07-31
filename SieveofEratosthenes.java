import java.util.Arrays;

public class SieveofEratosthenes {
    public void solve(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int p=2;p*p<=n;p++){
            if(isPrime[p]==true){
                for(int i=p*p;i<=n;i+=p){
                    isPrime[i]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i]==true){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SieveofEratosthenes s=new SieveofEratosthenes();
        s.solve(50);
    }
}