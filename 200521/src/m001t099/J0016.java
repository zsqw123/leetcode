package m001t099;

import java.util.Arrays;

public class J0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE-target;
        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int tmp=nums[i]+nums[l]+nums[r];
                if(tmp==target) return target;
                int abs=Math.abs(tmp-target);
                if(abs<Math.abs(res-target)) res=tmp;
                if(tmp>target)r--;
                else l++;
            }
        }
        return res;
    }
}
