package m200t499;

import java.util.HashMap;

public class J0208 {
    /**
     * 查找复杂度 O(1), 插入复杂度最坏为 O(len), 但是慢于官方题解<br/>
     * 空间复杂度 O(n^2) (大概?
     */
    class Trie0 {
        HashMap<String,Boolean> isExist=new HashMap<>();
        /** Inserts a word into the trie. */
        public void insert(String word) {
            int len=word.length();
            isExist.put(word,true);
            if(len==1) return;
            for(int i=len-1;i>0;i--){
                String tmp=word.substring(0,i).intern();
                if(isExist.containsKey(tmp) && isExist.get(tmp)) return;
                else isExist.put(tmp,false);
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return isExist.containsKey(word) && isExist.get(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return isExist.containsKey(prefix);
        }
    }
}
