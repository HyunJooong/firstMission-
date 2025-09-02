package inflearn;

import java.util.Scanner;

public class AlphabetFinding {
    public int solution(String str, char t){
        int answer = 0;
        str = str.toLowerCase();
        t = Character.toLowerCase(t);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == t){
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        AlphabetFinding a = new AlphabetFinding();
        Scanner sc = new Scanner(System.in);
        String h = sc.nextLine();
        char s = sc.next().charAt(0);
        System.out.println("Enter a word: " + a.solution(h, s));
    }
}
