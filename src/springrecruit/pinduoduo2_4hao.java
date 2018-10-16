package springrecruit;

import java.util.*;
public class pinduoduo2_4hao{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Integer n,k;
        while(sc.hasNext())
        {
            String tmp1=sc.nextLine();
            String[] temp1=tmp1.split(" ");
            n=Integer.parseInt(temp1[0]);
            k=Integer.parseInt(temp1[1]);
            String tmp2=sc.nextLine();
            String[] temp2=tmp2.split(" ");
            int[] array=new int[temp2.length];
            for(int i=0;i<temp2.length;i++){
                array[i]=Integer.parseInt(temp2[i]);
            }
            int[] result=new int[n-k+1];
            for(int i=0;i<n-k+1;i++){
                int min=99999;
                int max=-99999;
                int diff;
                for(int j=i;j<i+k;j++){
                    if(min>array[j])
                        min=array[j];
                    if(max<array[j])
                        max=array[j];
                }
                diff=max-min;
                result[i]=diff;
            }
            for(int i=0;i<result.length;i++)
                if(i!=result.length-1)
                    System.out.print(result[i]+" ");
                else
                    System.out.println(result[i]);
        }
    }
}