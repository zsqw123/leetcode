package jz;

public class S43 {
    public int countDigitOne(int n) {
        if(n==0) return 0;
        if(n<10) return 1;

        String s=String.valueOf(n);
        int len=s.length();
        int base=(int)Math.pow(10,len-2)*(len-1);
        int hi=s.charAt(0)-'0';
        int pow=(int)Math.pow(10,len-1);
        if(hi==1){
            // 1333
            // 0~999 + 333 + 1xxx出现334次
            return base+countDigitOne(n-pow)+n-pow+1;
        }
        // 2333
        // 0,1开头*base + 333 + 1xxx出现了1000次
        return base*hi+countDigitOne(n-pow*hi)+pow;
    }
}
