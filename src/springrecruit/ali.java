package springrecruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ali {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    public static void main(String[] args) {

//        List<Integer> order = new ArrayList<Integer>();
//        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();
//
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//
//        Integer n = Integer.parseInt(line.split(",")[0]);
//        Integer m = Integer.parseInt(line.split(",")[1]);
//
//        line = in.nextLine();
//        String[] itemCnt = line.split(",");
//        for(int i = 0; i < n ; i++){
//            order.add(Integer.parseInt(itemCnt[i]));
//        }
//
//        for(int i = 0; i < m; i++){
//            line = in.nextLine();
//            String[] bomInput = line.split(",");
//            List<Integer> bomDetail = new ArrayList<Integer>();
//
//            for(int j = 1; j <= n; j++ ){
//                bomDetail.add(Integer.parseInt(bomInput[j]));
//            }
//            boms.put(bomInput[0], bomDetail);
//        }
//        in.close();

        List<Integer> order = new ArrayList<Integer>(){{
            add(2);
            add(3);
            add(1);
        }};
        List<Integer> bom1 = new ArrayList<Integer>(){{
            add(1);
            add(1);
            add(0);
        }};
        List<Integer> bom2 = new ArrayList<Integer>(){{
            add(0);
            add(1);
            add(1);
        }};
        List<Integer> bom3 = new ArrayList<Integer>(){{
            add(2);
            add(1);
            add(1);
        }};
        Map<String,List<Integer>> boms = new HashMap<String, List<Integer>>(){{
            put("bom1",bom1);
            put("bom2",bom2);
            put("bom3",bom3);
        }};


        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
        Map<String, Integer> res=new HashMap<>();
        int rest=order.size();
        for (Map.Entry<String, List<Integer>> stringListEntry : boms.entrySet())  {
            Map<String, Integer> res1=new HashMap<>();


            List<Integer> bom=stringListEntry.getValue();
            int num=Integer.MAX_VALUE;
            for (int j = 0; j <bom.size() ; j++) {
                if (bom.get(j)==0) continue;
                num=Math.min(num,order.get(j)/bom.get(j));
            }
            if (num!=0)
            {
                List<Integer> neworder=new ArrayList<>();
                Map<String, List<Integer>> newboms=new HashMap<>();
                newboms.putAll(boms);
                newboms.remove(stringListEntry.getKey());

                for (int j = 0; j <bom.size() ; j++) {
                    neworder.add(order.get(j)-num*bom.get(j));
                }
                res1.put(stringListEntry.getKey(),num);
                res1.putAll(resolve(neworder,newboms));
            }

            int newrest=0;

            for (int i = 0; i <order.size(); i++) {
                int v=0;
                for (Map.Entry<String, Integer> si : res1.entrySet()) {
                    v+=si.getValue()*boms.get(si.getKey()).get(i);
                }
                if (v<order.get(i))
                    newrest++;

            }
            if (newrest<rest||(newrest==rest&&res1.size()<res.size()))
            {
                res=res1;
                rest=newrest;
            }

        }
        return res;
    }
}