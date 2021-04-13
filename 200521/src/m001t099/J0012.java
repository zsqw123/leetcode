package m001t099;

public class J0012 {
    public String intToRoman(int num) {
        int[] v={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] r={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<13; i++){
            while(num>=v[i]){
                num -= v[i];
                sb.append(r[i]);
            }
        }
        return sb.toString();
    }
}
