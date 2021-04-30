package m100t199;

public class J0136 {
    /** @see J0137 */
    public int singleNumber(int[] nums) {
        int a=0;
        for(int b:nums)a^=b;
        return a;
    }
}
