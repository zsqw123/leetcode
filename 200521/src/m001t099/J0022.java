package m001t099;
import java.util.*;

public class J0022 {
    // 递归, 通过括号暴力插入
    public List<String> generateParenthesis(int n) {
        if(n==1) return Collections.singletonList("()");
        List<String> list=generateParenthesis(n-1);
        HashSet<String> res=new HashSet<>();
        for(String s:list){
            int sLen=s.length();
            for(int j=-1;j<sLen-1;j++)
                res.add(s.substring(0,j+1)+"()"+s.substring(j+1,sLen));
        }
        return new ArrayList<>(res);
    }

    static List<String> res=new ArrayList<>();
    static void gen(String s,int n,int l,int r){
        // 左边括号数量要大于等于右边括号数量, 否则括号无法闭合, 剪枝
        if(l<r||l>n||r>n) return; // 这里切换到 IDE 才发现其实 r>n 没必要判断的
        if(l==n && r==n) res.add(s);
        gen(s+"(",n,l+1,r); // 就加括号呗
        gen(s+")",n,l,r+1);
    }
    public static List<String> generateParenthesis2(int n) {
        gen("",n,0,0);
        return res;
    }
}
