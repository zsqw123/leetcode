package m001t099;

public class J0067 {
    // ...简单题罢了.. 何必这么较真
    public void tool(StringBuilder sb,int index){
        sb.setCharAt(index-1,sb.charAt(index-1)=='0'?'1':'2');
        sb.setCharAt(index,'0');
    }
    public String addBinary(String a, String b) {
        int len1=a.length();
        int len2=b.length();
        if(len1<len2) return addBinary(b,a);
        StringBuilder sb=new StringBuilder(a);
        for(int i=0;i<len2-1;i++){
            if(sb.charAt(len1-1-i)=='2')tool(sb,len1-1-i);
            if(b.charAt(len2-1-i)=='0') continue;
            if(sb.charAt(len1-1-i)=='0') sb.setCharAt(len1-1-i,'1');
            else tool(sb,len1-1-i);
        }
        if(b.charAt(0)!='0'){
            if(sb.charAt(len1-len2)=='1'){
                sb.setCharAt(len1-len2,'2');
            }else if(sb.charAt(len1-len2)=='0'){
                sb.setCharAt(len1-len2,'1');
            }else{
                if(len1-len2>0){
                    sb.setCharAt(len1-len2-1,sb.charAt(len1-len2-1)=='0'?'1':'2');
                    sb.setCharAt(len1-len2,'1');
                }else{
                    sb.setCharAt(0,'1');
                    sb.insert(0,'1');
                    return sb.toString();
                }
            }
        }
        for(int i=len1-len2;i>0;i--) if(sb.charAt(i)=='2') tool(sb,i);
        if(sb.charAt(0)<'2') return sb.toString();
        sb.setCharAt(0,'0');
        sb.insert(0,'1');
        return sb.toString();
    }
}
