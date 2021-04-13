package m100t199;

import java.util.*;
import java.util.stream.Collectors;

public class J0179 {
    public String largestNumber(int[] nums) {
        Comparator<String> c=Comparator.naturalOrder();
        String s= Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    if(s1.length()!=s2.length())
                        return -c.compare(s1+s2,s2+s1);
                    return -c.compare(s1,s2);
                }).collect(Collectors.joining(""));
        if(s.startsWith("0")) return "0";
        return s;
    }
}
