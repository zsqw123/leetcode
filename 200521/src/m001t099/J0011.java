package m001t099;

public class J0011 {
    public static int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int res=0;
        while(l!=r){
            // 由于短板效应
            // 左右指针较大的缩小范围一定不可能导致区域增大
            // 因此将左右指针较小的回缩范围
            if(height[l]<height[r]){
                res=Math.max(res,(r-l)*height[l]);
                l++;
            } else {
                res=Math.max(res,(r-l)*height[r]);
                r--;
            }
        }
        return res;
    }

    static int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    public static void main(String[] args) {
        System.out.println(maxArea(input));
    }
}
