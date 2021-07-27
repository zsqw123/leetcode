package jz;

public class S10_2 {
    public int numWays(int n) {
        if(n==0) return 1;
        if(n==1) return 1;

        int a=1,b=1,tmp;
        for(int i=2;i<=n;i++){
            tmp=b;
            b=(a+b)%1000000007;
            a=tmp;
        }
        return b;
    }
}
