package m001t099;

public class J0050 {
    public double myPow(double x, int n) {
        double res=1.0;
        if(n==Integer.MIN_VALUE) return 1/myPow(x,-(n+2));
        if(n<0) return 1/myPow(x,-n);
        while(n!=0){
            if((n & 1)==1) res*=x;
            x*=x;
            n>>=1;
        }
        return res;
    }
}
