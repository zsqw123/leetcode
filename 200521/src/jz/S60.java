package jz;

public class S60 {
    public double[] dicesProbability(int n) {
        double oneBySix=1.0/6;
        if(n==1) return new double[]{oneBySix,oneBySix,oneBySix,oneBySix,oneBySix,oneBySix};
        double[] smaller=dicesProbability(n-1);
        double[] res=new double[smaller.length+5];
        for(int i=0;i<smaller.length;i++)
            for(int j=0;j<6;j++)
                res[i+j]+=smaller[i]*oneBySix;
        return res;
    }
}
