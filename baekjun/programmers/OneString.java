package baekjun.programmers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class OneString {
    public static void main(String[] args) {
        OneString os = new OneString();
        System.out.println(os.solution("abcabcadc"));
    }
    public String solution(String s) {

        //사전순으로 정렬
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        //중복이 있으면 +1 씩
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : chars) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        //중복되지 않는 문자만 return
        StringBuilder answer = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if(entry.getValue() == 1) {
                answer.append(entry.getKey());
            }
        }

        return answer.toString();
    }
}
