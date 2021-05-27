package m200t499;

import java.util.Arrays;

public class J0334 {
    // 非常简单的思路
    public boolean increasingTriplet(int[] nums) {
        int len=nums.length;
        if(len<3) return false;
        int[] mins=Arrays.copyOf(nums,len);
        int[] maxs= Arrays.copyOf(nums,len);
        for(int i=1;i<len;i++) mins[i]=Math.min(mins[i-1],mins[i]);
        for(int i=len-2;i>=0;i--) maxs[i]=Math.max(maxs[i+1],maxs[i]);
        for(int i=1;i<len-1;i++)
            if(nums[i]>mins[i-1] && nums[i]<maxs[i+1]) return true;
        return false;
    }

    // 记录第一小和第二小的数, 如果出现了比第一小和第二小大的, 那么符合条件
    public boolean increasingTriplet2(int[] nums) {
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=a) a=i;
            else if(i<=b) b=i;
            else return true;
        }
        return false;
    }
}
