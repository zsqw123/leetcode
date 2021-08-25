package jz;

public class S64 {
    int[] arr=new int[1];
    public int sumNums(int n) {
        try{
            return arr[n];
        }catch(Exception e){
            return n+sumNums(n-1);
        }
    }
}
