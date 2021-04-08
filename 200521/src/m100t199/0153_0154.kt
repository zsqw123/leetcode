package m100t199

fun main(){
    fun findMin(nums: IntArray): Int {
        if(nums[0]<nums.last()) return nums[0]
        var l=0
        var r=nums.size-1
        var mid: Int
        while(l<r){
            mid=l+(r-l)/2
            if (nums[mid] < nums[r]) r=mid
            else l=mid+1
            // 154
            //     if (nums[mid] < nums[r]) r=mid
            //     else if(nums[mid]>nums[r])l=mid+1
            //     else r--
        }
        return nums[l]
    }
}