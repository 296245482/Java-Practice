package fallrecruit.pdd2;

import java.util.*;

public class pdd2t3 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        String param = input.nextLine();
        String[] reads = param.split(" ");
        int N = Integer.parseInt(reads[0]);
        int index = Integer.parseInt(reads[1]);
        List<int[]> friendList = new ArrayList<>();

        for (int i = 0; i < N; i ++) {
            String str = input.nextLine();
            String[] friendsStr = str.split(" ");
            int friendsNum = friendsStr.length;
            int[] friends = new int[friendsNum];
            for (int j = 0; j < friendsNum; j ++) {
                friends[j] = Integer.parseInt(friendsStr[j]);
            }
            friendList.add(friends);
        }
        System.out.print(findBestMatch(friendList, index));
    }

    private static int findBestMatch(List<int[]> friendList, int index){
        int[] current = friendList.get(index);
        int bestMatch = -1;
        int max = 0;
        for(int i = 0; i < friendList.size(); i ++){
            if (i == index){
                continue;
            }
            int[] other = friendList.get(i);
            int sameFriends = 0;
            boolean isFriend = false;
            for (int otherItem:other){
                for (int currentItem:current){
                    if (currentItem == otherItem) {
                        sameFriends ++;
                        break;
                    }
                }
                if (otherItem == index) {
                    isFriend = true;
                    break;
                }
            }
            if (!isFriend && sameFriends > max) {
                bestMatch = i;
                max = sameFriends;
            }
        }
        return bestMatch;
    }
}