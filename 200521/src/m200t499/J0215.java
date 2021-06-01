package m200t499;

import java.util.Arrays;

public class J0215 {
    // 不讲武德
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
