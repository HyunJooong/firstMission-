package baekjun.programmers.week2;

import java.util.Stack;

public class Week2_3 {

    public static String decompress(String code) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char c : code.toCharArray()) {
            if (Character.isDigit(c)) {
                // 숫자를 발견하면 num을 업데이트
                num = num * 10 + (c - '0');
            } else if (c == '{') {
                // 여는 중괄호를 발견하면 현재까지의 숫자와 문자열을 스택에 저장
                numStack.push(num);
                strStack.push(currentStr.toString());
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == '}') {
                // 닫는 중괄호를 발견하면 스택에서 꺼내어 문자열 반복
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();

                // currentStr을 repeatTimes만큼 반복하여 temp에 추가
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                // 일반 문자면 currentStr에 추가
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
