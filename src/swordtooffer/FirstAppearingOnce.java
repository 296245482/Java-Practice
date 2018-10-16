package swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstAppearingOnce {

    private Map<Character, Integer> map = new HashMap<>();
    private List<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (list.contains(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char item : list) {
            if (map.get(item) == 1) {
                return item;
            }
        }
        return '#';
    }
}
