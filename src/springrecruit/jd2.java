package springrecruit;

import java.util.Scanner;

public class jd2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        long[] arr=new long[t];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextLong();
        }
        muilty(arr);
    }
    public static void  muilty(long[] arr){
        for(int i=0;i<arr.length;i++){
            int two=2;
            if(arr[i]%two!=0)
            {
                System.out.println("No");
            }
            else{
                while((arr[i]/two)%2==0){
                    two=two*2;
                }
                System.out.println(arr[i]/two+" "+two);
            }
        }
    }
}
