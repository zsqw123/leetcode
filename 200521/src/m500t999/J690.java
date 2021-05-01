package m500t999;

import java.util.*;

public class J690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    HashMap<Integer, Employee> map = new HashMap<>();

    int helper(int id) {
        Employee e = map.get(id);
        int a = e.importance;
        for (Integer i : e.subordinates) a += helper(i);
        return a;
    }

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) map.put(e.id, e);
        return helper(id);
    }
}
