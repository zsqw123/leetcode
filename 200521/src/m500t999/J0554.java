package m500t999;

import java.util.HashMap;
import java.util.List;

public class J0554 {
    // 暴力 超时
    public int leastBricks(List<List<Integer>> wall) {
        var n=wall.size();
        var cur=new int[n];
        var res=n;
        for(var wa:wall) for(var i=1;i<wa.size();i++) wa.set(i,wa.get(i-1)+wa.get(i));
        var total=wall.get(0).get(wall.get(0).size()-1);
        for(var i=1;i<total;i++){
            var count=0;
            for(var j=0;j<n;j++){
                if(wall.get(j).get(cur[j])==i) cur[j]++;
                else count++;
            }
            res=Math.min(res,count);
        }
        return res;
    }

    // 哈希表存间隙 18ms 25%
    public int leastBricks2(List<List<Integer>> wall) {
        var n=wall.size();
        var map=new HashMap<Integer,Integer>();

        for (int i=0, sum = 0; i < n; i++, sum = 0) {
            for (int cur : wall.get(i)) {
                sum += cur;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }

        var res=n;
        for (int key:map.keySet()) {
            res = Math.min(res, n-map.get(key));
        }
        return res;
    }
}
