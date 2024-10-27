package baekjun;

import java.util.Stack;

public class Pre5_3 {
    public static void main(String[] args) {
        String s = "apple";
        Pre5_3 p = new Pre5_3();
        System.out.println(p.solution(s));

    }
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.substring(i, i + 1));
        }
        // 스택에서 팝하면서 역순으로 문자열 생성
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }


        return answer;
    }
}
