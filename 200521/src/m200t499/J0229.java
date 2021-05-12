package m200t499;

import java.util.ArrayList;
import java.util.List;

public class J0229 {
    public List<Integer> majorityElement(int[] nums) {
        int m=Integer.MIN_VALUE,n=Integer.MIN_VALUE,x=0,y=0;
        for(int a:nums){
            if(a==m) x++;
            else if(a==n) y++;
            else if(x==0){
                m=a; x=1;
            }else if(y==0){
                n=a; y=1;
            }else{
                x--; y--;
            }
        }
        x=0;y=0;
        for(int a:nums){
            if(a==m) x++;
            else if(a==n) y++;
        }
        var res=new ArrayList<Integer>();
        if(x>nums.length/3) res.add(m);
        if(y>nums.length/3) res.add(n);
        return res;
    }
}
