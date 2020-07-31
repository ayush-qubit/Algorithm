import java.util.*;
 class WeightedJobScheduling {
	static class Job{
		int start,end,weight;
		Job(int s,int e,int w){
			start=s;
			end=e;
			weight=w;
		}
	}
	public static int JobScheduling(Job[] J,int n) {
		Arrays.sort(J, new Comparator<Job>(){
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.end<=o2.end) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		int[] dp=new int[n];
		int temp=-1;
		dp[0]=J[0].weight;
		for(int i=1;i<n;i++) {
			temp=-1;
			for(int j=0;j<i;j++) {
				if(J[j].end<=J[i].start) {
					temp=j;
				}
			}
			if(temp==-1) {
				dp[i]=Math.max(J[i].weight, dp[i-1]);
			}
			else {
				dp[i]=Math.max(dp[i-1], dp[temp]+J[i].weight);
			}
		}
		//System.out.println(Arrays.toString(dp));
		return dp[n-1];
	}
	public static void main(String[] args) {
		int n,s,e,w;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Job[] J=new Job[n];
		for(int i=0;i<n;i++) {
			s=sc.nextInt();
			e=sc.nextInt();
			w=sc.nextInt();
			J[i]=new Job(s,e,w);
		}
		System.out.println(JobScheduling(J,n));
		sc.close();
	}

}