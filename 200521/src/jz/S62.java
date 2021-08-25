package jz;

public class S62 {
    public int lastRemaining(int n, int m) {
        if(n==0) return 0;
        return (lastRemaining(n-1,m)+m)%n;
    }
}
