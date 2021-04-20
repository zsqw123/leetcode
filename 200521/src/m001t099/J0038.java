package m001t099;

public class J0038 {
    // 可以非迭代 没必要
    public String countAndSay(int n) {
        if(n==1) return "1";
        String input=countAndSay(n-1);
        int[] arr=new int[input.length()];
        for(int i=0;i<arr.length;i++) arr[i]=input.charAt(i)-'0';
        StringBuilder sb= new StringBuilder();
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                sb.append(count);
                sb.append(arr[i - 1]);
                count=1;
            }else count++;
        }
        sb.append(count);
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
}
