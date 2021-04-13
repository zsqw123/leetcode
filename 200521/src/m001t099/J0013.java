package m001t099;

public class J0013 {
    public int romanToInt(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)) {
                case 'I':res+=1;break;
                case 'V':res+=5;break;
                case 'X':res+=10;break;
                case 'L':res+=50;break;
                case 'C':res+=100;break;
                case 'D':res+=500;break;
                case 'M':res+=1000;break;
                default:break;
            }

            if(i!=0){
                if(((s.charAt(i)=='V')||(s.charAt(i)=='X'))&&(s.charAt(i-1)=='I')) res-=2;
                if(((s.charAt(i)=='L')||(s.charAt(i)=='C'))&&(s.charAt(i-1)=='X')) res-=20;
                if(((s.charAt(i)=='D')||(s.charAt(i)=='M'))&&(s.charAt(i-1)=='C')) res-=200;
            }
        }
        return res;
    }
}
