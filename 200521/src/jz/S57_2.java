package jz;

import java.util.ArrayList;

public class S57_2 {
    public int[][] findContinuousSequence(int target) {
        var list=new ArrayList<int[]>();
        int max=target>>1,l=1,r=1,sum=0;
        while(l<=max){
            if(sum>target) sum-=l++;
            else if(sum<target) sum+=r++;
            else{
                int[] arr=new int[r-l];
                for(int i=l;i<r;i++) arr[i-l]=i;
                list.add(arr);
                sum-=l++;
            }
        }
        int sz=list.size();
        int[][] res=new int[sz][];
        l=0;
        for(int[] arr:list) res[l++]=arr;
        return res;
    }
}
