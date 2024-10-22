package baekjun;

import java.util.*;

public class Parenthesis {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        /*6
        (())())
        (((()())()
        (()())((()))
        ((()()(()))(((())))()
        ()()()()(()()())()
        (()((())()(*/

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (isValidParenthesis(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    private static boolean isValidParenthesis(String s) {

        boolean flag = false;

        Stack<Character> stack = new Stack<Character>(); //스택 push pop 이용
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); //문자열 문자형식으로 변환

            //Yes가 나오려면 짝이 맞아야 한다.
            if (ch == '(') { //stack에 push
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) { //모두 닫는 괄호가 나오면 stack은 빈값
                    return false;
                } else {
                    stack.pop(); // 닫는 괄호가 나오면 맨앞 pop
                }
            }
        }
        if(stack.isEmpty()){
            flag = true;
        }
        return flag;
    }
}
