package m001t099;

public class J0035 {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        int mid;
        while(l<r){
            mid=l+(r-l)/2;
            if(nums[mid]>target) r=mid;
            else if(nums[mid]<target) l=mid+1;
            else return mid;
        }
        return l;
    }
}
