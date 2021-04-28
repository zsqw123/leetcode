package m500t999;

public class J0633 {
    public boolean judgeSquareSum(int c) {
        int sqa=0;
        int sqb=(int)Math.floor(Math.sqrt(c));
        int a=0;
        int b=sqb*sqb;

        while(sqa<=sqb){
            int res=a+b-c;
            if(res==0) return true;
            if(res<0) a+=(sqa++<<1)+1;
            else b-=(sqb--<<1)-1;
        }
        return false;
    }
}
