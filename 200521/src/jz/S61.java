package jz;

import java.util.Arrays;

public class S61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(nums[i]==0) i++;
        if(i>=4) return true;
        for(int j=i+1;j<5;j++)
            if(nums[j]==nums[j-1]) return false;
        return nums[4]-nums[i]<=4;
    }
}
