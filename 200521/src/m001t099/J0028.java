package m001t099;

public class J0028 {
    public int strStr(String haystack, String needle) {
        int hLen=haystack.length();
        int nLen=needle.length();
        if(nLen>hLen) return -1;
        if(nLen==0) return 0;
        for(int i=0;i<=hLen-nLen;i++)
            if(needle.charAt(0)==haystack.charAt(i)){
                int j=nLen-1;
                int k=i+j;
                while(k>=i) if(haystack.charAt(k--)!=needle.charAt(j--)) break;
                if(k==i-1) return i;
            }
        return -1;
    }
}
