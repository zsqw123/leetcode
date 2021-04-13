package m001t099;

public class J0008 {
    public int myAtoi(String s) {
        char[] chars=s.toCharArray();
        int len=chars.length;
        int idx=0;
        while(idx<len && chars[idx]==' ') idx++;
        if(idx==len) return 0;
        boolean negtive=false;
        if(chars[idx]=='-') {
            negtive=true;
            idx++;
        } else if(chars[idx]=='+') idx++;
        else if(!Character.isDigit(chars[idx])) return 0;

        int res=0;
        while(idx<len && Character.isDigit(chars[idx])){
            int digit=chars[idx]-'0';
            if(res>(Integer.MAX_VALUE-digit)/10)
                return negtive? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res*=10;
            res+=digit;
            idx++;
        }
        return negtive? -res : res;
    }
}
