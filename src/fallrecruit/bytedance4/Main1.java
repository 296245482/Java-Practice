package fallrecruit.bytedance4;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        Stack<String> strStack = new Stack<>();
        String[] strList = inputStr.split("/");
        for (String item : strList) {
            switch (item) {
                case "..": {
                    if (!strStack.isEmpty()) {
                        strStack.pop();
                    }
                    break;
                }
                case ".": {
                    continue;
                }
                case "": {
                    continue;
                }
                default: {
                    strStack.push(item);
                }
            }
        }
        String res = "";
        while (!strStack.isEmpty()) {
            String cur = strStack.pop();
            res = "/" + cur + res;
        }
        if ("".equals(res)) {
            System.out.println("/");
            return;
        }
        System.out.println(res);
    }
}