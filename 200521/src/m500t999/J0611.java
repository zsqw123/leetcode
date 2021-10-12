package m500t999;

import java.util.Arrays;

public class J0611 {
    // 双指针 复杂度 O(n^2)
    class S2 {
        public int triangleNumber(int[] nums) {
            int len=nums.length;
            if(len<3) return 0;
            Arrays.sort(nums);
            int res=0,start=-1;
            for(int i=0;i<len;i++) if(nums[i]>0){
                start=i;
                break;
            }
            if(start==-1 || (len-start<2)) return 0;
            int c=len-1;
            while(c>start && c>=2){
                int a=start,b=c-1;
                int max=nums[c];
                while(a<b){
                    if(nums[a]+nums[b]>max){
                        res+=b-a;
                        b--;
                    }else a++;
                }
                c--;
            }
            return res;
        }
    }

    // 二分查找 复杂度O(n^2 * logn)
    class S1 {
        int binSearch0(int target,int[] nums,int left){
            int l=left-1,r=nums.length;
            while(l+1!=r){
                int mid=l+((r-l)>>1);
                if(nums[mid]<=target) l=mid;
                else r=mid;
            }
            return l;
        }
        int binSearch1(int target,int[] nums,int left){
            int l=left-1,r=nums.length;
            while(l+1!=r){
                int mid=l+((r-l)>>1);
                if(nums[mid]<target) l=mid;
                else r=mid;
            }
            return l;
        }
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int len=nums.length;
            int res=0;
            int start=-1;
            for(int i=0;i<len;i++) if(nums[i]>0){
                start=i;
                break;
            }
            if(start==-1) return 0;
            for(int i=start;i<len-2;i++){
                for(int j=i+1;j<len-1;j++){
                    int sum=nums[i]+nums[j];
                    int dec=nums[j]-nums[i];
                    res+=binSearch1(sum,nums,j+1)-binSearch0(dec,nums,j+1);
                }
            }
            return res;
        }
    }
}
