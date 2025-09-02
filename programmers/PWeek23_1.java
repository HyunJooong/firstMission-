package programmers;

import java.util.ArrayList;
import java.util.List;

public class PWeek23_1 {

    public String solution(String s) {
        int[] frequency = new int[10];  // 0부터 9까지의 숫자 빈도수를 저장할 배열

        // 입력된 문자열에서 각 숫자의 빈도수를 계산
        for (char c : s.toCharArray()) {
            frequency[c - '0']++;
        }

        List<Integer> result = new ArrayList<>();

        // 빈도수가 큰 순서대로 숫자를 리스트에 추가
        for (int i = 0; i < 10; i++) {
            int maxFreq = -1;
            int maxNum = -1;
            for (int j = 0; j < 10; j++) {
                if (frequency[j] > maxFreq) {
                    maxFreq = frequency[j];
                    maxNum = j;
                }
            }
            if (maxFreq > 0) {
                result.add(maxNum);
                frequency[maxNum] = 0;  // 이미 추가된 숫자는 빈도수를 0으로 만듦
            }
        }

        // 빈도수가 0인 숫자들을 작은 숫자 순으로 추가
        for (int i = 0; i < 10; i++) {
            if (frequency[i] == 0) {
                result.add(i);
            }
        }

        // 결과를 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }

}
