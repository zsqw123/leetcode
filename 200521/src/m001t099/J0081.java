package m001t099;

public class J0081 {
    public boolean search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid;
        while(l<=r){
            mid=l+((r-l)>>1);
            if(nums[mid]==target) return true;
            while(l<=mid && nums[l]==nums[mid]) l++;
            if(l>mid) continue;
            if(nums[mid]>=nums[l]){
                if(nums[l]<=target && target<nums[mid]) r=mid-1;
                else l=mid+1;
            }else{
                if(nums[mid]<target && target<=nums[r]) l=mid+1;
                else r=mid-1;
            }
        }
        return false;
    }
}
