package springrecruit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class TouTiao666 {
    static char[][] nums = {
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','.','.','.','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','.'},
            {'6','6','6','6','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','.'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','.'},
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'6','6','6','6','6'},
            {'6','.','.','.','6'},
            {'6','6','6','6','6'},
            {'.','.','.','.','6'},
            {'6','6','6','6','6'},
    };
    public static void main(String[] args) throws ScriptException{

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] answer = new String[n];
        for(int i = 0; i<n; i++){
            String formula = input.nextLine();
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            answer[i] = engine.eval(formula).toString();
        }
        for(int i = 0; i<n; i++){
            String result = answer[i];
            char[] results = result.toCharArray();
//            System.out.println(results);
            for(int j = 0; j<5; j++){
                for(int k = 0; k<results.length; k++){

//                    System.out.print((results[k]-'0')*5+j);
                    System.out.print(nums[(results[k]-'0')*5+j]);
                    if(k != results.length - 1){
                        System.out.print("..");
                    }
                }
                if( (j == 4) && (i == n-1))
                    System.out.print("");
                else
                    System.out.print("\n");
            }
        }
    }
}