package m001t099;

public class J0038 {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String input=countAndSay(n-1);
        int[] arr=new int[input.length()];
        for(int i=0;i<arr.length;i++) arr[i]=input.charAt(i)-'0';
        StringBuilder sb= new StringBuilder();
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                sb.append(String.valueOf(count));
                sb.append(String.valueOf(arr[i-1]));
                count=1;
            }else count++;
        }
        sb.append(String.valueOf(count));
        sb.append(String.valueOf(arr[arr.length-1]));
        return sb.toString();
    }
}
