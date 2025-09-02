package programmers.week5;

import java.util.Arrays;
import java.util.Comparator;

public class Week5_2 {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] numStrings = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 두 문자열을 비교하여 내림차순 정렬
        Arrays.sort(numStrings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                // 두 문자열을 이어 붙였을 때 큰 순서로 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 모든 숫자가 0인 경우 처리
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 이어 붙임
        StringBuilder answer = new StringBuilder();
        for (String num : numStrings) {
            answer.append(num);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Week5_2 week5_2 = new Week5_2();
        int[] numbers = {9, 5, 34, 3, 30};

        String result = week5_2.solution(numbers);
        System.out.println("Largest number: " + result); // Expected output: "9534330"
    }
}
