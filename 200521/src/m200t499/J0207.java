package m200t499;

import java.util.*;

public class J0207 {
    // 拓扑
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 下一门课程的队列
        List<Deque<Integer>> nextCourses=new ArrayList<>(numCourses);
        for(int i=numCourses-1;i>=0;i--) nextCourses.add(new LinkedList<>());
        // 前一门课程
        int[] preCount=new int[numCourses];
        for(int[] p:prerequisites){
            preCount[p[0]]++;
            nextCourses.get(p[1]).push(p[0]);
        }
        // 筛选前一门没课的去掉并使子节点-1
        Deque<Integer> zeroStack=new LinkedList<>();
        for(int i=numCourses-1;i>=0;i--) if(preCount[i]==0) zeroStack.push(i);
        while(!zeroStack.isEmpty())
            for(int n:nextCourses.get(zeroStack.pop()))
                if(--preCount[n]==0) zeroStack.push(n);
        for(int i:preCount) if(i!=0) return false;
        return true;
    }
}
