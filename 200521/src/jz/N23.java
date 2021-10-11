package jz;

/**
 * 牛客剑指23题
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 *
 * 二叉树后序遍历, 最后一个数一定是head, 左右分开查询, 左边如果有比它大, false, 右边有比它小, false
 */
public class N23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length==0) return false;
        int last=sequence.length-1;
        while(last>0){
            int i=0;
            while(sequence[i]<sequence[last]) i++;
            while(sequence[i]>sequence[last]) i++;
            if(last-->i) return false;
        }
        return true;
    }
}

class N23_2 {
    int[] seq;
    boolean verify(int start, int end){
        int sz=end-start+1;
        if(sz<2) return true;
        int last=seq[end];
        int mid=0;
        while(seq[mid]<last) mid++;
        for(int i=mid;i<end;i++) if(seq[i]<last) return false;
        return verify(start,mid-1)&&verify(mid,end-1);
    }
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length==0) return false;
        seq=sequence;
        return verify(0,sequence.length-1);
    }
}
