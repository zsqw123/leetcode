package jz;

public class S11 {
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1,mid;
        while(l<r){
            mid=(l+r) >> 1; // 测试用例不是很大, 所以没考虑越界
            if(numbers[mid]<numbers[r]){
                r=mid;
            }else if(numbers[mid]>numbers[r]){
                l=mid+1;
            }else r--; // 为什么不用 l++ 呢? 因为 l++ 可能会导致 mid 始终取到 l(向下取整)
        }
        return numbers[l];
    }
}
