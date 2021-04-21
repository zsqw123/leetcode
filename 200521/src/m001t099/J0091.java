package m001t099;

public class J0091 {
    // 第一次试了 5 次提交失败出来的...垃圾代码
    // 1ms 超越 100%
    public int numDecodings0(String s) {
        if(s.charAt(0)=='0') return 0;
        int len=s.length();
        int res=1;
        int i=0;
        while(i<len-1){
            char c;
            int t0=1;
            int t1=1;
            do{
                c=s.charAt(i);
                if(c=='0'){
                    if(s.charAt(i-1)!='1' && s.charAt(i-1)!='2') return 0;
                    else break;
                }
                if(c!='1' && c!='2') break;
                if(i+2<len && s.charAt(i+2)=='0'){
                    if(s.charAt(i+1)!='1' && s.charAt(i+1)!='2') return 0;
                    else break;
                }
                if(s.charAt(i+1)=='0') continue;
                if(c=='2' && s.charAt(i+1)>'6') break;
                int tmp=t1;
                t1+=t0;
                t0=tmp;
            }while(++i<len-1);
            i++;
            res*=t1;
        }
        if(s.charAt(len-1)=='0' && s.charAt(len-2)!='1' && s.charAt(len-2)!='2') return 0;
        return res;
    }
}
