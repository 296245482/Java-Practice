package fallrecruit.pdd2;

import java.util.Scanner;
import java.util.*;
public class pdd2t4 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String str = input.nextLine();
        int n = Integer.parseInt(str);
        str = input.nextLine();
        String[] cardsStr = str.split(" ");
        List<Integer> cards = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            cards.add(Integer.parseInt(cardsStr[i]));
        }
        if(n > 100){
            return;
        }
        int result=0;
        // 没做完
    }
}
