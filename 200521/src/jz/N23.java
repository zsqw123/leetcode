package jz;

/**
 * 牛客剑指23题
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
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
