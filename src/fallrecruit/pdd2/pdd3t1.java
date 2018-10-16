package fallrecruit.pdd2;

import java.util.*;

public class pdd3t1 {
    private static List<List<Integer>> conditions = new ArrayList<>();
    private static List<Integer> results = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int hp = input.nextInt();
        int normalAttack = input.nextInt();
        int buffedAttack = input.nextInt();
        conditions.add(Arrays.asList(normalAttack));
        conditions.add(Arrays.asList(buffedAttack));
        calculate(hp, normalAttack, buffedAttack);
        System.out.println(calMin());
    }
    private static void calculate(int hp, int normalAttack, int buffedAttack){
        if(results.size() == conditions.size()){
            return;
        }
        List<List<Integer>> tempCondition = conditions;
        Iterator iterator = tempCondition.iterator();
        while(iterator.hasNext()){
            List<List<Integer>> addCondition = new ArrayList<>();
            List<Integer> temp = new ArrayList<Integer>((List<Integer>)iterator.next());
            temp.add(normalAttack);
            if(getArraySum(temp) > hp){
                results.add(getRound(temp, normalAttack));
            }else {
                addCondition.add(temp);
            }
            temp.remove(temp.size() - 1);
            temp.add(buffedAttack);
            if(getArraySum(temp) > hp){
                results.add(getRound(temp, normalAttack));
            }else {
                addCondition.add(temp);
            }
            iterator.remove();
            conditions.addAll(addCondition);
        }
        calculate(hp, normalAttack, buffedAttack);
    }

    private static int getArraySum(List<Integer> array){
        int sum = 0;
        for(Integer item:array){
            sum += item;
        }
        return sum;
    }

    private static int getRound(List<Integer> array, int normalAttack){
        int round = 0;
        for(Integer item:array){
            if(item == normalAttack){
                round += 1;
            }else {
                round += 2;
            }
        }
        return round;
    }
    private static int calMin(){
        int min = Integer.MAX_VALUE;
        for(Integer item:results){
            if(item < min){
                min = item;
            }
        }
        return min;
    }
}
