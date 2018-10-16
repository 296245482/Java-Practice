package fallrecruit.pdd3;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        inputStr = inputStr.toLowerCase();
        inputStr = delPunc(inputStr);
        String[] words = inputStr.split(" ");
        Map<String, Integer> count = new HashMap<>();
        for (String item : words) {
            if (count.get(item) != null) {
                int num = count.get(item);
                num++;
                count.put(item, num);
            } else {
                count.put(item, 1);
            }
        }
        int MAX = Integer.MIN_VALUE;
        Set<String> res = new HashSet<>();
        Iterator iterator = count.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry item = (Map.Entry)iterator.next();
            int num = (int)item.getValue();
            if(num ==MAX){
                res.add((String)item.getKey());
            }
            if(num>MAX){
                res = new HashSet<>();
                res.add((String)item.getKey());
                MAX = num;
            }
        }
        String[] result = new String[res.size()];
        Iterator iterator2 = res.iterator();
        int i =0;
        while(iterator2.hasNext()){
            String item = (String) iterator2.next();
            result[i] = item;
            i++;
        }
        Arrays.sort(result);
        System.out.println(result[0]);
    }

    public static String delPunc(String str) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 19968 && chars[i] <= 40869)
                    || (chars[i] >= 97 && chars[i] <= 122)
                    || (chars[i] >= 65 && chars[i] <= 90)) {
                continue;
            } else {
                chars[i] = ' ';
            }
        }
        return new String(chars);
    }
}


//
//
//    public static String format(String s){
//        String str=s.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？|-]", "");
//        return str;
//    }
