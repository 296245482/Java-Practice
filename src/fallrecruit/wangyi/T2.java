package fallrecruit.wangyi;

import java.util.*;

public class T2 {
    private static Set<String> combinations = new HashSet<String>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int k = Integer.parseInt(params[2]);
        char[] aAndZ = new char[n + m];
        for(int i = 0; i < n; i ++){
            aAndZ[i] = 'a';
        }
        for(int j = 0; j < m; j ++){
            aAndZ[n + j] = 'z';
        }
        getCombinations(aAndZ,0);
        List<String> combinationList = new ArrayList<>(combinations);
        Collections.sort(combinationList);
        if(k > combinationList.size()){
            System.out.println(-1);
            return;
        }
        System.out.println(combinationList.get(k - 1));
    }
    private static void getCombinations(char[] aAndZ, int i){
        if(aAndZ == null || i < 0 || i > aAndZ.length){
            return;
        }
        if(i == aAndZ.length){
            String str = new String(aAndZ);
            combinations.add(str);
        }else{
            for(int j = i; j < aAndZ.length; j ++){
                char temp = aAndZ[j];
                aAndZ[j] = aAndZ[i];
                aAndZ[i] = temp;
                getCombinations(aAndZ,i+1);
                temp = aAndZ[j];
                aAndZ[j] = aAndZ[i];
                aAndZ[i] = temp;
            }
        }
    }
}