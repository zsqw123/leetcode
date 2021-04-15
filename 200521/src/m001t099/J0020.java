package m001t099;

import java.util.ArrayDeque;

public class J0020 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='['||c=='{') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return false;
            switch(stack.pop()){
                case '(': if(c!=')') return false;break;
                case '[': if(c!=']') return false;break;
                default: if(c!='}') return false;
            }
        }
        return stack.isEmpty();
    }
}
