package springrecruit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class huawei2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int years = input.nextInt();
        int day = input.nextInt();

        if(years > 400 || day < 0 || day > 6){
            System.out.println(-1);
            return;
        }

        int result = 0;
        SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        for(int i = 0; i < years; i++){
            for(int j = 1; j <= 12; j++){
                String dateStr = "190"+i+"-"+j+"-13";
                try{
                    Date date = sdf.parse(dateStr);
                    cal.setTime(date);
                    int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
                    if(week_index<0){
                        week_index = 0;
                    }
                    if(week_index == day){
                        result ++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        System.out.println(result);
    }
}
