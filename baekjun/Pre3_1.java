package baekjun;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pre3_1 {
    public static void main(String[] args) {
        String s = "aacddefg";
        Pre3_1 p = new Pre3_1();
        System.out.println(p.solution(s));

    }
    public String solution(String s){
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // 문자열의 각 문자에 대해 등장 횟수를 계산
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // 등장 횟수가 1인 문자들만 결과 문자열에 추가
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }
}
