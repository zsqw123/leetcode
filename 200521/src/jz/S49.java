package jz;

public class S49 {
    public int nthUglyNumber(int n) {
        int p2=0,p3=0,p5=0,a,b,c;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            a=2*dp[p2];
            b=3*dp[p3];
            c=5*dp[p5];

            int min=Math.min(Math.min(a,b),c);
            dp[i]=min;
            if(a==min) p2++;
            if(b==min) p3++;
            if(c==min) p5++;
        }
        return dp[n-1];
    }
}
