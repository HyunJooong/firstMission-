package programmers.week2;

import java.util.Arrays;

public class Week2_1 {

    public int solution(int[] n) {
        Arrays.sort(n); // 배열 순서대로 정렬

        int i = 0;
        int answer = n[0];
        for(int num : n){
            if(num == answer){ // 값이 같다면 answer 하나씩 추가
                answer++;
            }else if(num != answer){
                break; // 다르다면 정렬을 한 상태이기 때문에 반복문 탈출
            }
        }

        return answer;
    }
    public static void main(String[] args) {

        int[] n = new int[]{9,4,2,3,7,5};

        Week2_1 w = new Week2_1();
       System.out.println(w.solution(new int[]{9,4,2,3,7,5}));

    }

}
