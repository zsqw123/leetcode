package jz;

public class S42 {
    public int maxSubArray(int[] nums) {
        for(int i=1;i<nums.length;i++)
            nums[i]=nums[i]+Math.max(nums[i-1],0);
        int max=Integer.MIN_VALUE;
        for(int i:nums) max=Math.max(max,i);
        return max;
    }
}
