package m001t099;

import java.util.*;

public class J0057 {
    // 就和 56 题一模一样 4ms
    // 复杂度可达 O(N^2) 这种方法的缺陷是进行了事实上的插入, 因此速度会慢
    public int[][] insert0(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        BitSet bits=new BitSet();
        for(int[] ints:intervals)bits.set(ints[0]<<1,(ints[1]<<1)+1);
        bits.set(newInterval[0]<<1,(newInterval[1]<<1)+1);
        int end=0;
        for(;;){
            int n=bits.nextSetBit(end);
            if(n==-1) break;
            end=bits.nextClearBit(n);
            res.add(new int[]{n>>1,(end-1)>>1});
        }
        return res.toArray(int[][]::new);
    }

    // 优化算法 理论复杂度 O(N) 3ms
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>(intervals.length);
        BitSet bits=new BitSet();
        int last0,last1;
        final int len=intervals.length;
        if(len>=1){
            last0=intervals[0][0];
            last1=intervals[0][1];
            for(int i=1;i<len;i++){
                int now0=intervals[i][0];
                int now1=intervals[i][1];
                if(now0>last0){
                    bits.set(last0<<1,(last1<<1)+1);
                    last0=now0;
                    last1=now1;
                }else if(now0==last0) last1=Math.max(last1,now1);
            }
            bits.set(last0<<1,(last1<<1)+1);
        }
        bits.set(newInterval[0]<<1,(newInterval[1]<<1)+1);
        int end=0;
        for(;;){
            int n=bits.nextSetBit(end);
            if(n==-1) break;
            end=bits.nextClearBit(n);
            res.add(new int[]{n>>1,(end-1)>>1});
        }
        return res.toArray(int[][]::new);
    }

    // 标准做法 2ms
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergeList = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergeList.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        mergeList.add(newInterval);
        while (i < intervals.length) {
            mergeList.add(intervals[i++]);
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
