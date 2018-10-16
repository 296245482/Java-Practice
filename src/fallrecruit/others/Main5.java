package fallrecruit.others;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputStr = input.nextLine().split("X\\^");
        TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();

        int times = Integer.parseInt(inputStr[0]);
        int power = 0;
        for (int i = 1; i < inputStr.length - 1; i++) {
            String param = inputStr[i];
            if (param.contains("+")) {
                power = Integer.parseInt(param.split("\\+")[0]);
                if (count.containsKey(power)) {
                    int temp = count.get(power);
                    count.put(power, temp + times);
                } else {
                    count.put(power, times);
                }
                times = Integer.parseInt(param.split("\\+")[1]);
            }
            if (param.contains("-")) {
                power = Integer.parseInt(param.split("-")[0]);
                if (count.containsKey(power)) {
                    int temp = count.get(power);
                    count.put(power, temp + times);
                } else {
                    count.put(power, times);
                }
                times = 0 - Integer.parseInt(param.split("-")[1]);
            }
        }
        power = Integer.parseInt(inputStr[inputStr.length - 1]);
        if (count.containsKey(power)) {
            int temp = count.get(power);
            count.put(power, temp + times);
        } else {
            count.put(power, times);
        }

        Set<Integer> powers = count.keySet();
        Iterator iter = powers.iterator();
        TreeSet<Integer>  ts = new TreeSet<Integer>();
        while (iter.hasNext()){
            ts.add((Integer) iter.next());
        }
        Iterator<Integer> iterator = ts.descendingIterator();
        String res = "";
        while (iterator.hasNext()) {
            int key = (Integer)iterator.next();
            if(count.get(key) != 0) {
                String temp = String.format("%sX^%s", count.get(key), key);
                if(temp.charAt(0)!='-') {
                    res += "+" + temp;
                }else {
                    res += temp;
                }
            }
        }
        if(res.charAt(0) == '+'){
            res = res.substring(1);
        }
        System.out.println(res);
    }
}
