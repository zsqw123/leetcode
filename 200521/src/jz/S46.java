package jz;

public class S46 {
    public int translateNum(int num) {
        if(num<=9) return 1;
        int r=num%100;
        if(r>25||r<10) return translateNum(num/10);
        return translateNum(num/10)+translateNum(num/100);
    }
}
