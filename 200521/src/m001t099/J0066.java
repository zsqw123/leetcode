package m001t099;

public class J0066 {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;
        for(int i=digits.length-1;i>0;i--){
            digits[i-1]+=digits[i]/10;
            digits[i]=digits[i]%10;
        }
        if(digits[0]<10) return digits;
        int[] n=new int[digits.length+1];
        System.arraycopy(digits,0,n,1,digits.length);
        n[0]=1;
        n[1]%=10;
        return n;
    }
}
