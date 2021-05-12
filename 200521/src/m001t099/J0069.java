package m001t099;

public class J0069 {
    public int mySqrt(int x) {
        int min=1;
        int max=x;
        while(min<=max){
            int mid=min+((max-min)>>1);
            int sqr=x/mid;
            if(mid==sqr) return mid;
            else if(mid>sqr) max=mid-1;
            else min=mid+1;
        }
        return max;
    }
}
