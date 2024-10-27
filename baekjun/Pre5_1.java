package baekjun;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pre5_1 {
    public static void main(String[] args) {
        String s = "google";
        Pre5_1 p = new Pre5_1();
        System.out.println(p.solution(s));
    }

    public String solution(String s) {
        String answer = "";
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char minChar = '\0';
        int maxCount = -1;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            int count = entry.getValue();
            char currentChar = entry.getKey();
            // 최대 빈도수인 경우, 또는 같은 빈도수이면서 알파벳 순서가 빠른 경우 업데이트
            if (count > maxCount || (count == maxCount && currentChar < minChar)) {
                maxCount = count;
                minChar = currentChar;
            }
        }
        answer = minChar + "";


        return answer;
    }

}
