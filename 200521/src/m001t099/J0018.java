package m001t099;

import java.util.*;

public class J0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length-1;
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len-1;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l=j+1;
                int r=len;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum<target) l++;
                    else if(sum>target) r--;
                    else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        r--;l++;
                    }
                }
            }
        }
        return res;
    }
}
