package baekjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pre2_2 {

    public static void main(String[] args) {
        Pre2_2 p = new Pre2_2();
        String[] answer = p.solution("Hello, World?!");
        for (String result : answer) {
            System.out.print(result);
        }
    }

    public String[] solution(String s) {

        List<String> answer = new ArrayList<>();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ',' && s.charAt(i) != '.' && s.charAt(i) != '!' && s.charAt(i) != '?' && s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    StringBuilder reversedWord = new StringBuilder();
                    while (!stack.isEmpty()) {
                        reversedWord.append(stack.pop());
                        answer.add(String.valueOf(reversedWord));
                    }
                }
            }
        }
        String[] result= new String[answer.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}
