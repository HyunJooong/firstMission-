package programmers.week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week7_3 {

    public String[] solution(String s) {
        List<String> result = new ArrayList<>();

        // IP 주소는 4개의 부분으로 나뉘어야 함
        for (int i = 1; i < 4 && i < s.length(); i++) {
            for (int j = i + 1; j < i + 4 && j < s.length(); j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    // 나누어진 네 개의 부분
                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);

                    // 유효한 IP인지 확인
                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        result.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }

        // 결과 정렬
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private boolean isValid(String part) {
        // 빈 문자열 또는 길이가 1~3을 벗어나는 경우
        if (part.length() == 0 || part.length() > 3) {
            return false;
        }

        // 숫자가 아닌 경우
        if (!part.matches("\\d+")) {
            return false;
        }

        // 숫자로 변환 후 범위 확인
        int value = Integer.parseInt(part);
        if (value < 0 || value > 255) {
            return false;
        }

        // 숫자 앞에 0이 붙는 경우 허용하지 않음 ("01", "001" 등)
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Week7_3 obj = new Week7_3();
        String input = "2552552551";
        String[] answer = obj.solution(input);

        System.out.println(java.util.Arrays.toString(answer));
        // Expected Output:
        // [255.255.25.51, 255.255.255.1]
    }
}
