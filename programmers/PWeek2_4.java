package programmers;

import java.util.HashSet;

public class PWeek2_4 {
    public static void main(String[] args) {
        String s = "Hello World Nice World";
        PWeek2_4 p = new PWeek2_4();
        System.out.println(p.solution(s));
    }

    public int solution(String s){
        int answer = 0;

        HashSet<String> hashSet = new HashSet<>();

        //공백 기준으로 자르기
        String[] arr = s.split(" ");

        //배열 hashset에 add
        for(String word : arr){
            hashSet.add(word);
        }

        answer = hashSet.size();
        return answer;
    }
}
