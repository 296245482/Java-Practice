package springrecruit;

import java.text.DecimalFormat;
import java.util.Scanner;

public class pinduoduo2_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] s = input.nextLine().split(":");
        int a= Integer.parseInt(s[0]);
        int b= Integer.parseInt(s[1]);
        double x=(a%12)*30+30*(b/60.0);
        double y=360*(b/60.0);
        double res=Math.abs(x-y);

        if(res>180)
            res=360-res;
        DecimalFormat df = new DecimalFormat("#.0");
        String res1=df.format(res);
        int res0 = (int) res;
        if(res>res0)
            System.out.println(res1);
        else
            System.out.println(res0);
    }
}