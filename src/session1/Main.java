package session1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        //
        HashSet<String> hs = new HashSet<>();
        hs.add("1");
        hs.add("2");
        hs.add("3");
        hs.add("4");
        for (String s: hs){
            System.out.println(s);
        }
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(8);
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        System.out.println("Numbers: " + numbers);

        int first = numbers.peek();
        System.out.println("first:"+first);
        System.out.println("total:"+numbers.size());

        System.out.println("Poll: "+numbers.poll()+" remain: "+numbers.size());
        System.out.println("Poll: "+numbers.poll()+" remain: "+numbers.size());
        System.out.println("Poll: "+numbers.poll()+" remain: "+numbers.size());
        //
        PriorityQueue<Student> st = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMark() - o1.getMark();
            }
        });
        st.add(new Student("asd",1));
        st.add(new Student("zxc",5));
        st.add(new Student("qwe",8));
        st.add(new Student("ert",6));

        Student s;
        while (st.size() > 0){
            s = st.poll();
            System.out.println("SV: "+s.getName()+" DT: "+s.getMark());
        }
        //
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("g_st",10);
        hm.put("b_st",4);
        System.out.println("asd"+hm.get("g_st"));
        System.out.println(hm.keySet());
        System.out.println(hm.values());
    }
}
