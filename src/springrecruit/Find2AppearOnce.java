package springrecruit;//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class Find2AppearOnce {
    public static void FindNumsAppearOnce(int [] array) {
        if(array == null)
            return;
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            temp ^= array[i];
        }
        int index = 0;
        int result1 = 0;
        int result2 = 0;
        while(((temp & 1) == 0) && (index < 32)){
            temp = temp >> 1;
            index ++;
        }
        for(int i = 0; i < array.length; i++){
            int tmp = array[i];
            int judge = tmp >> index;
            if((judge & 1) == 1){
                result1 ^= array[i];
            }else{
                result2 ^= array[i];
            }
        }
        System.out.print(result1+"   "+result2);
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,4,6};
        FindNumsAppearOnce(a);
    }
}
