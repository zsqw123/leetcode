package m001t099;

public class J0033 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l<=r) {
            mid=l+(r-l)/ 2;
            if (nums[mid]==target) return mid;
            // 如果大于等于, 说明左边有序, 否则右侧有序
            if (nums[mid] >= nums[l]) {
                if(target>=nums[l]){ // 左边有序而且 target 在左边, 使用正常的二分
                    if(nums[mid]>target) r=mid-1;
                    else l=mid+1;
                }else l=mid+1; // 左边有序但是 target 在右边, l 右移
            } else { // 右边有序
                if(target<=nums[r]){ // target 在右边
                    if(nums[mid]<target) l=mid+1;
                    else r=mid-1;
                }else r=mid-1;
            }
        }
        return -1;
    }
}
