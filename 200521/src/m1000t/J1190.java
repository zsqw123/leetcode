package m1000t;

public class J1190 {
    int idx = 0;

    public String reverseParentheses(String s) {
        return traversal(s.toCharArray()).toString();
    }

    public StringBuilder traversal(char[] arr){
        StringBuilder cur = new StringBuilder();
        while (idx<arr.length){
            if (arr[idx]=='('){
                idx++;
                cur.append(traversal(arr).reverse());
            }else if (arr[idx]==')'){
                idx++;
                return cur;
            }else {
                cur.append(arr[idx]);
                idx++;
            }
        }
        return cur;
    }
}
