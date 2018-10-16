package swordtooffer;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString("sadsadqw", 2));
    }
}
