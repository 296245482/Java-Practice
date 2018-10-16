package fallrecruit.tencent;

import java.util.*;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int k = Integer.parseInt(input.nextLine());
        String A = input.nextLine();
        String B = input.nextLine();

        HashSet<String> strSet = new HashSet<>();
        for (int i=0; i<=A.length()-k; i++) {
            StringBuffer tmp = new StringBuffer();
            for (int j=0; j<k; j++) {
                tmp.append(A.charAt(i+j));
            }
            strSet.add(tmp.toString());
        }

        int res = 0;
        for (int i=0; i<=B.length()-k; i++) {
            StringBuffer tmp = new StringBuffer();
            for (int j=0; j<k; j++) {
                tmp.append(B.charAt(i+j));
            }
//            System.out.println(tmp.toString());
            for (String str : strSet) {
                if (str.equals(tmp.toString())) {
                    res++;
                    break;
                }
            }
        }

        System.out.println(res);

    }
}