package baekjun;

import java.util.Stack;

public class Pre3_2 {
    public int solution(String s) {

        int answer = 0;

        Stack<Character> stack = new Stack<Character>(); //스택 push pop 이용
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); //문자열 문자형식으로 변환

            //Yes가 나오려면 짝이 맞아야 한다.
            if (ch == '(' || ch == '{' || ch == '[' || ch == '<') { //stack에 push
                stack.push(ch);
            } else if (ch == ')'|| ch == '}' || ch == ']' || ch == '>') {
                if (stack.isEmpty()) { //모두 닫는 괄호가 나오면 stack은 빈값
                    return 0;
                } else {
                    stack.pop(); // 닫는 괄호가 나오면 맨앞 pop
                }
            }
        }
        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
