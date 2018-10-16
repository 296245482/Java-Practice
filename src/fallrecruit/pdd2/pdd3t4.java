package fallrecruit.pdd2;


import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;


public class pdd3t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        scanner.nextLine();
        char[][] s = new char[l][n];
        Set<String> inputs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String l1 = scanner.nextLine();
            inputs.add(l1);
            for (int j = 0; j < l; j++) {
                s[j][i] = l1.charAt(j);
            }
        }
        for (int i = 0; i < l; i++) {
            Arrays.sort(s[i]);
        }


        Index index = new Index(l, n);
        while (true) {
            if (index.isEnd())
                break;
            String res = generateString(s, index);
            if (!inputs.contains(res)) {
                System.out.println(res);
                return;
            } else {
                index.add(index.len - 1);
            }
        }
        System.out.println("-");


    }

    public static String generateString(char[][] s, Index index) {
        String res = "";
        for (int i = 0; i < index.len; i++) {
            res += s[i][index.data[i]];
        }
        return res;
    }


}

class Index {
    int len;
    int size;
    int[] data;

    public Index(int len, int size) {
        this.len = len;
        this.size = size;
        data = new int[len];
    }

    public Index add(int n) {
        data[n] = data[n] + 1;
        if (data[n] < size)
            return this;
        else {
            data[n] = 0;
            add(n - 1);
        }
        return this;

    }

    public boolean isEnd() {
        for (int i = 0; i < len; i++) {
            if (data[i] != size - 1)
                return false;
        }
        return true;
    }

}