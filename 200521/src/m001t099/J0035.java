package m001t099;

public class J0035 {
    public int searchInsert(int[] nums, int target) {
        int l=-1,r=nums.length,mid;
        while(l+1!=r){
            mid=l+((r-l)>>1);
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) l=mid;
            else r=mid;
        }
        return r;
    }
}
