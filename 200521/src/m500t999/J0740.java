package m500t999;

import java.util.HashMap;
import java.util.TreeSet;

public class J0740 {
    // HashMap+TreeSet 时间 nlogn 优点是空间复杂度只需要 O(N)
    // 14ms 7.29%
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer max = 0;
        Integer last = -1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
            Integer now = map.getOrDefault(n, 0);
            map.put(n, now + n);
        }
        for (Integer n : set) {
            if (n - last > 1) {
                max += map.get(n);
                last = n;
                map.put(n, max);
                continue;
            }
            Integer low = set.lower(last);
            Integer now = map.get(n);
            if (low == null) {
                if (now > max) max = now;
            } else {
                int cur = now + map.get(low);
                if (cur > max) max = cur;
            }
            last = n;
            map.put(n, max);
        }
        return max;
    }

    // dp 优点是时间 O(N) 但是空间复杂度较大
    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int i : nums) max = Math.max(max, i);
        int[] dp = new int[max + 1];
        for (int i : nums) dp[i] += i;
        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        return dp[max];
    }
}
