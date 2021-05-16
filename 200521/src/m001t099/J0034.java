package m001t099;

public class J0034 {
    public int[] searchRange(int[] nums, int target) {
        int l=-1,r=nums.length,mid;
        while(l+1!=r){
            mid=l+((r-l)>>1);
            if(nums[mid]<target) l=mid;
            else r=mid;
        }
        if(r==nums.length || nums[r]!=target) return new int[]{-1,-1};
        int start=r;
        l=r;
        r=nums.length;
        while(l+1!=r){
            mid=l+((r-l)>>1);
            if(nums[mid]<=target) l=mid;
            else r=mid;
        }
        return new int[]{start,l};
    }
}
