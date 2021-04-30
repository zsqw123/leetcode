package m001t099;

public class J0096 {
    int[] mem=new int[20];
    public int numTrees(int n) {
        if(n<2) return 1;
        if(mem[n]!=0) return mem[n];
        int res=0;
        for(int i=0;i<n;i++)
            res+=numTrees(i)*numTrees(n-1-i);
        mem[n]=res;
        return res;
    }
}
