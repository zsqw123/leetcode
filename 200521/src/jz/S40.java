package jz;

import java.util.Arrays;

public class S40 {
    int[] arr;
    void fastSort(int start,int end){
        if(start>=end) return;
        int l=start,r=end;
        int t=arr[start];
        while(l<r){
            while(l<r && arr[r]>=t) r--;
            arr[l]=arr[r];
            while(l<r && arr[l]<=t) l++;
            arr[r]=arr[l];
        }
        arr[l]=t;
        fastSort(start,l-1);
        fastSort(l+1,end);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        this.arr=arr;
        fastSort(0,arr.length-1);
        return Arrays.copyOf(arr,k);
    }
}
