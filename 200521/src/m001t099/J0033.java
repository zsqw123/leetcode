package m001t099;

public class J0033 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) { // l到mid有序
                if (nums[l] <= target && target < nums[mid]) r = mid - 1; // target在这个范围内, 收缩右边界
                else l = mid + 1;
            } else { // mid到r有序
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
