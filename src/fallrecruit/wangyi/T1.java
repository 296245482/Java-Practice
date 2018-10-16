package fallrecruit.wangyi;

import java.util.Scanner;

/**
 * 瞌睡
 */
public class T1 {
    public static void main(String[] args){
        // 输入
        Scanner input = new Scanner(System.in);
        String[] param = input.nextLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);
        if (n < 1 || k > 100000){
            System.out.println(0);
            return;
        }
        int[] interest = new int[n];
        int[] awake = new int[n];
        String[] interestStr = input.nextLine().split(" ");
        String[] awakeStr = input.nextLine().split(" ");
        for(int i = 0; i < n; i ++) {
            interest[i] = Integer.parseInt(interestStr[i]);
            if(interest[i] > 10000 || interest[i] < 1){
                System.out.println(0);
                return;
            }
            awake[i] = Integer.parseInt(awakeStr[i]);
        }
        // 计算不叫醒
        int maxLearn = 0;
        int maxLearnOrigin = 0;
        for (int i = 0; i < n; i ++){
            maxLearnOrigin += awake[i] * interest[i];
        }
        // 加上叫醒
        int tempMaxLearn = maxLearnOrigin;
        for (int i = 0; i < n; i ++){
            if (awake[i] == 0){
                for(int j = 0; j < k; j ++) {
                    if(i + j < n && awake[i+j] == 0){
                        tempMaxLearn += interest[i+j];
                    }
                }
                if(tempMaxLearn > maxLearn){
                    maxLearn = tempMaxLearn;
                }
                tempMaxLearn = maxLearnOrigin;
            }
        }
        System.out.println(maxLearn);
    }
}
