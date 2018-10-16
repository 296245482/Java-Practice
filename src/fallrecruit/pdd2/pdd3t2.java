package fallrecruit.pdd2;
import java.util.Scanner;


public class pdd3t2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        String[] chessboard = new String[m];
        for (int i = 0; i < m; i++) {
            chessboard[i] = "";
        }
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            for (int j = 0; j < m; j++) {
                chessboard[j] += line.charAt(j);
            }
        }



        String[] result = drop(chessboard);
        print(result);

    }

    public static String[] drop(String[] strings) {
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            String res = "";
            int oNum = 0;
            int pointNum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'o'){
                    oNum++;
                }
                else if (str.charAt(j) == '.') {
                    pointNum++;
                }
                else {
                    res += conbineString('.', pointNum);
                    res += conbineString('o', oNum);
                    res += 'x';
                    pointNum = 0;
                    oNum = 0;
                }
            }
            res += conbineString('.', oNum + pointNum);
            result[i] = res;
        }
        return result;
    }

    private static String conbineString(char c, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += c;
        }
        return res;
    }
    private static void print(String[] str){
        for (int i = 0; i < str[0].length(); i++) {
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[j].charAt(i));
            }
            System.out.println();
        }
    }
}