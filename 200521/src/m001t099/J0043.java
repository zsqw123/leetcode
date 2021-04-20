package m001t099;

public class J0043 {
    /**
     *               9   9   9
     *         ×     6   7   8
     *  ----------------------
     *              72  72  72
     *          63  63  63
     *      54  54  54
     *  ----------------------
     *      54 117 189 135  72
     *  ----------------------
     *      54 117 189 142   2
     *  -----------------------
     *      54 117 203   2   2
     *  -----------------------
     *      54 137   3   2   2
     *  -----------------------
     *      67   7   3   2   2
     */
    class S0 {
        public String multiply(String num1, String num2) {
            if(num1.charAt(0)=='0'||num2.charAt(0)=='0') return "0";
            int len1=num1.length(),len2=num2.length();
            int[] res=new int[len1+len2-1];
            for(int i=0;i<len2;i++)for(int j=0;j<len1;j++)
                res[i+j]+=(num1.charAt(j)-'0')*(num2.charAt(i)-'0');
            for(int i=len1+len2-2;i>0;i--){
                res[i-1]+=res[i]/10;
                res[i]%=10;
            }
            StringBuilder sb=new StringBuilder();
            for(int i:res) sb.append(i);
            return sb.toString();
        }
    }
}
