package baekjun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pre3_3 {
    public int solution(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); //
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                iterator.remove();
            }
        }


        return map.isEmpty() ? 1 : 0;

    }

    public static void main(String[] args) {
        Pre3_3 p = new Pre3_3();
        System.out.println(p.solution("abba"));


    }
}
