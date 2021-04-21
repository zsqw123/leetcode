package m001t099;

import java.util.*;

public class J0056 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res=new ArrayList<>();
        BitSet bits=new BitSet();
        for(int[] ints:intervals)bits.set(ints[0]<<1,(ints[1]<<1)+1);
        int end=0;
        for(;;){
            int n=bits.nextSetBit(end);
            if(n==-1) break;
            end=bits.nextClearBit(n);
            res.add(new int[]{n>>1,(end-1)>>1});
        }
        return res.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        J0056 j=new J0056();
        int[][] input=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        j.merge(input);
    }
}
