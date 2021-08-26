package jz;

public class S65 {
    public int add(int a, int b) {
        int res=0;
        while(b!=0){
            int c=a&b;
            a=a^b;
            b=c<<1;
        }
        return a;
    }
}
