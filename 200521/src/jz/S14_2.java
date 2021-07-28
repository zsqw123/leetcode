package jz;

public class S14_2 {
    /**
     * 选 2 3 再分割会变小, 4以上再分割会变大
     * @see S14_1
     */
    public int cuttingRope(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        long res=1;
        while(n>4){
            res*=3;
            res%=1000000007;
            n-=3;
        }
        return (int)((res*n)%1000000007);
    }
}
