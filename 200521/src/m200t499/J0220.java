package m200t499;

import java.util.TreeSet;

public class J0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set=new TreeSet<>();
        for (int i= 0;i<nums.length;i++) {
            Long ceiling=set.ceiling((long)nums[i]-(long)t);
            if (ceiling!=null && ceiling<=((long)nums[i]+(long)t))
                return true; // 查找最近的符合条件的, 由于 set 大小被限制, 因此查找到的一定符合
            set.add((long)nums[i]);
            if (set.size()==k+1) set.remove((long)nums[i-k]);
        }
        return false;
    }
}
