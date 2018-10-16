package swordtooffer;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class CharOrder {
    private static List<String> results = new ArrayList<>();
    public ArrayList<String> Permutation(String str){
        if(str != null && str.length() > 0){
            handler(str, 0);
            Collections.sort(results);
        }
        return (ArrayList) results;
    }
    private void handler(String str, int index) {
        if(index == str.length() - 1){
            if(!results.contains(str)) {
                results.add(str);
            }
        }else {
            for(int j = index; j < str.length(); j++){
                str = swap(str, index, j);
                handler(str, index + 1);
                str = swap(str, index, j);
            }
        }
    }
    private String swap(String str, int i, int j){
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
    public static void main(String[] args){
        System.out.println(new CharOrder().Permutation("aa").toString());
    }
}
