package swordtooffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int item:array){
            if(result.containsKey(item)){
                result.put(item, result.get(item) + 1);
            }else {
                result.put(item, 1);
            }
        }
        Iterator iterator = result.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry item = (Map.Entry)iterator.next();
            if((int)item.getValue() > array.length/2){
                return (int)item.getKey();
            }
        }
        return 0;
    }
}
