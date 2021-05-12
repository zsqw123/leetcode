package m001t099;

import java.util.*;

public class J0056 {
    // 3ms
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        BitSet bits = new BitSet();
        for (int[] ints : intervals) bits.set(ints[0] << 1, (ints[1] << 1) + 1);
        int end = 0;
        for (; ; ) {
            int n = bits.nextSetBit(end);
            if (n == -1) break;
            end = bits.nextClearBit(n);
            res.add(new int[]{n >> 1, (end - 1) >> 1});
        }
        return res.toArray(int[][]::new);
    }

    // 7ms
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int idx = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (idx == -1 || res[idx][1] < interval[0]) res[++idx] = interval;
            else res[idx][1] = Math.max(res[idx][1], interval[1]);
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        J0056 j = new J0056();
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        j.merge(input);
    }
}
