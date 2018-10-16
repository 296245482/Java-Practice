package fallrecruit.bytedance3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        List<String> binaryData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String item = beBinary(Integer.toBinaryString(data[i]));
            binaryData.add(item);
        }

        //一个字节的特殊情况
        if(binaryData.size()==1){
            String str1 = binaryData.get(0);
            if(str1.charAt(0) == '0'){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            return;
        }

        //判断第一个
        String str1 = binaryData.get(0);
        int i =0;
        for(; i<n; i++){
            if(str1.charAt(i) == '1'){
                continue;
            }else {
                System.out.println(0);
                return;
            }
        }
        if(str1.charAt(i) != '0'){
            System.out.println(0);
            return;
        }
        for(int j = 1; j < n; j++){
            String item = binaryData.get(j);
//            if(item.charAt(0) == '0'){
//                continue;
//            }
            if(item.charAt(0) != '1' || item.charAt(1) != '0'){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
    private static String beBinary(String input){
        int len = input.length();
        String result = input;
        if(len < 8){
            for(int i = 0; i < 8-len; i++){
                result = '0'+result;
            }
        }
        return result;
    }
}
