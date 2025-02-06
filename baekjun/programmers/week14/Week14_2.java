package baekjun.programmers.week14;

import java.util.Stack;

public class Week14_2 {
    public String solution(String s, int k) {
        int n = s.length();
        if (k >= n) return "0"; // 모든 숫자를 지우는 경우

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 남아 있는 k개 더 제거 (필요한 경우)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 결과 문자열 만들기
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // 앞의 불필요한 0 제거
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Week14_2 week14_2 = new Week14_2();
        System.out.println(week14_2.solution("105990", 1)); // "5990"
        System.out.println(week14_2.solution("10200", 1));  // "200"
        System.out.println(week14_2.solution("123456", 3)); // "123"
        System.out.println(week14_2.solution("10", 2));     // "0"
    }
}
