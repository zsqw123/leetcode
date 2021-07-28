package jz;

public class S16 {
    public double myPow(double x, int n) {
        double res=1.0;
        // 很离谱 你就给我卡这种奇葩条件(
        if(n==Integer.MIN_VALUE) return myPow(x,n+2);
        if(n==0) return 1.0;
        if(n<0) return 1.0/myPow(x,-n);
        if((n&1)==0){
            double half=myPow(x,n>>1);
            return half*half;
        }else{
            return x*myPow(x,n-1);
        }
    }
}
