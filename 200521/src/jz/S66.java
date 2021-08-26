package jz;

public class S66 {
    public int[] constructArr(int[] a) {
        int[] b=new int[a.length];
        int c=1;
        for(int i=0;i<a.length;i++){
            b[i]=c;
            c*=a[i];
        }
        c=1;
        for(int i=a.length-1;i>=0;i--){
            b[i]*=c;
            c*=a[i];
        }
        return b;
    }
}
