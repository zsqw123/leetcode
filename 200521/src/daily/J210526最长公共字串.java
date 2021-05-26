package daily;

public class J210526最长公共字串 {
    public String LCS (String str1, String str2) {
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();
        int[][] dp=new int[char1.length][char2.length];
        int max=0,pos=0;
        for(int i=0;i<char1.length;i++)
            for(int j=0;j<char2.length;j++)
                if(char1[i]==char2[j]){
                    if(i==0 || j==0) dp[i][j]=1;
                    else dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>max){
                        pos=i;
                        max=dp[i][j];
                    }
                }
        return str1.substring(pos+1-max,pos+1);
    }
}
