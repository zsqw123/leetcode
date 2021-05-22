package m001t099;

import java.util.Deque;
import java.util.LinkedList;

public class J0071 {
    public String simplifyPath(String path) {
        String[] folders=path.split("/");
        Deque<String> deque=new LinkedList<>();
        for(String f:folders){
            if(f.equals("") || f.equals(".")) continue;
            if(f.equals("..")){
                if(!deque.isEmpty()) deque.pop();
            }
            else deque.push(f);
        }
        StringBuilder sb=new StringBuilder();
        if(deque.isEmpty()) return "/";
        while(!deque.isEmpty()){
            sb.insert(0,deque.pop()).insert(0,"/");
        }
        return sb.toString();
    }
}
