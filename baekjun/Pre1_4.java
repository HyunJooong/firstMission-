package baekjun;

import java.util.HashMap;
import java.util.Map;

public class Pre1_4 {

    public static void main(String[] args) {

        String input = "552342502";
        Pre1_4 pre1 = new Pre1_4();
        int result = pre1.solution(input);
        System.out.println("가장 많이 중복된 숫자: " + result);

    }

    public int solution(String s) {
        int answer = 0;

        //HashMap
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char mostFrequentChar = s.charAt(0);  // 첫 번째 문자를 초기 값으로 설정
        int maxFrequency = 0;

        // 가장 많이 중복된 숫자를 찾기
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char currentChar = entry.getKey();
            int currentFrequency = entry.getValue();

            // 더 높은 빈도를 찾거나, 빈도가 같으면 더 작은 숫자를 선택
            if (currentFrequency > maxFrequency ||
                    (currentFrequency == maxFrequency && currentChar < mostFrequentChar)) {
                mostFrequentChar = currentChar;
                maxFrequency = currentFrequency;
            }
        }

        // char를 int로 변환해서 반환
        return Character.getNumericValue(mostFrequentChar);
    }
}

