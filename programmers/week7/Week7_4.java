package programmers.week7;

import java.util.ArrayList;
import java.util.List;

public class Week7_4 {

    public int[] solution(String nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length() / 2; i++) {
            for (int j = i + 1; j <= nums.length(); j++) {
                // 첫 두 숫자를 추출
                String num1 = nums.substring(0, i);
                String num2 = nums.substring(i, j);

                // 숫자 앞에 0이 있거나 int 범위를 초과하면 무효
                if (!isValid(num1) || !isValid(num2)) {
                    continue;
                }

                // 유사 피보나치 수열 검증
                List<Integer> sequence = new ArrayList<>();
                sequence.add(Integer.parseInt(num1));
                sequence.add(Integer.parseInt(num2));

                if (isFibonacciSequence(sequence, nums.substring(j))) {
                    return sequence.stream().mapToInt(x -> x).toArray();
                }
            }
        }

        return new int[]{}; // 유사 피보나치 수열을 만들 수 없는 경우
    }

    private boolean isFibonacciSequence(List<Integer> sequence, String remaining) {
        while (!remaining.isEmpty()) {
            int size = sequence.size();
            int nextValue = sequence.get(size - 1) + sequence.get(size - 2);

            // 다음 값 문자열로 변환
            String nextValueStr = String.valueOf(nextValue);

            // 남은 문자열이 다음 값으로 시작하지 않으면 무효
            if (!remaining.startsWith(nextValueStr)) {
                return false;
            }

            // 다음 값을 추가하고 남은 문자열 갱신
            sequence.add(nextValue);
            remaining = remaining.substring(nextValueStr.length());
        }

        return true;
    }

    private boolean isValid(String num) {
        // 숫자 앞에 0이 있거나 빈 문자열인 경우 무효
        if (num.isEmpty() || (num.length() > 1 && num.startsWith("0"))) {
            return false;
        }

        // 숫자가 int 범위를 넘는 경우 무효
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Week7_4 w = new Week7_4();
        int[] result = w.solution("14152944");

        if (result.length == 0) {
            System.out.println("{}");
        } else {
            System.out.print("{");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
}


