package swordtooffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int Add(int num1,int num2) {
        while (num2 != 0){
            int temp1 = num1 ^ num2;
            int temp2 = (num1 & num2) << 1;
            num1 = temp1;
            num2 = temp2;
        }
        return num1;
    }
}
