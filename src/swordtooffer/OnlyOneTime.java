package swordtooffer;

public class OnlyOneTime {
    public int FirstNotRepeatingChar(String str) {
        int[] record = new int['z'+1];
        char[] chars = str.toCharArray();
        for(char item:chars){
            record[(int)item]++;
        }
        for(int i=0; i < chars.length; i++){
            if(record[chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(new OnlyOneTime().FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
