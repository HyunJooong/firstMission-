package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestWord {
    public String solution(String word) {
        String answer = "";
        answer = word;

        List words = new ArrayList();
        words.add(word.split(" "));

        for(int i = 0; i < words.size(); i++) {
        }

        return answer;
    }

    public static void main(String[] args) {
        LongestWord lw = new LongestWord();
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println(lw.solution(lw.solution(answer)));
    }
}
