package fallrecruit.pdd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pdd3t3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        n = n % m;
        List<Integer> temp = new ArrayList<>();
        while (true) {
            temp.add(n);
            n = n * 10 % m;
            if (n == 0) {
                System.out.println(temp.size() + " " + 0);
                break;
            }
            if (temp.contains(n) && temp.indexOf(n) >= 0) {
                System.out.println(temp.indexOf(n)+" "+(temp.size()-temp.indexOf(n)-1));
                break;
            }
        }
    }
    private static Boolean checkSame(List<Integer> temp, int m, int n){
        int bewteen = (temp.size()-temp.indexOf(n));
        int begin = temp.indexOf(n);
        for(int i = 0; i < bewteen; i++){
            temp.add(n);
            n = n * 10 % m;
            if(!temp.get(begin+i).equals(temp.get(begin+bewteen+i))){
                return false;
            }
        }
        return true;
    }
}
