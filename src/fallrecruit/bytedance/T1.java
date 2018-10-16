package fallrecruit.bytedance;

import java.util.*;

public class T1 {
    private static Set<Integer> already = new HashSet<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<List<Integer>> relations = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i ++) {
            String inStr = input.nextLine();
            String[] inStrs = inStr.split(" ");
            List<Integer> person = new ArrayList<>();
            for(String item:inStrs) {
                person.add(Integer.parseInt(item));
            }
            person.remove(person.size() - 1);
            relations.add(person);
        }
//        System.out.println(relations.toString());
        int m = 0;
        for(int i = 0; i < n; i ++) {
            if(!already.contains(i)) {
                already.addAll(getGroup(relations, i));

                m ++;
            }
        }
        System.out.println(m);
//        System.out.println(getForward(relations, 1));
    }
    private static Set<Integer> getForward(List<List<Integer>> relations, int index) {
        Set<Integer> forward = new HashSet<>();
//        if(!already.contains(index)) {
            List<Integer> knows = relations.get(index);
            forward.addAll(knows);
            for (Integer item : knows) {
                forward.addAll(getForward(relations, item - 1));
            }
//        }
        return forward;
    }
    private static Set<Integer> getBackWard(List<List<Integer>> relations, int index) {
        Set<Integer> backward = new HashSet<>();
//        if(!already.contains(index)) {
            for (int i = 0; i < relations.size(); i++) {
                List<Integer> item = relations.get(i);
                if (item.contains(index + 1)) {
                    backward.add(i);
                    backward.addAll(getBackWard(relations, i));
                }
            }
//        }
        return backward;
    }
    private static Set<Integer> getGroup(List<List<Integer>> relations, int index) {
        Set<Integer> group = new HashSet<>();
        Set<Integer> forward = getForward(relations, index);
        Set<Integer> backward = getBackWard(relations, index);
        group.addAll(forward);
        group.addAll(backward);
        group.add(index);
        for(Integer item:group) {
            group.addAll(getGroup(relations, item));
        }
        return group;
    }
}
