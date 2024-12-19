package baekjun.programmers.week7;

import java.util.HashMap;

public class Week7_2 {
    public int solution(int[] votes) {
        int answer = -1; // 기본값: 과반수가 없는 경우 -1 반환
        int half = votes.length / 2; // 과반수 기준

        // 각 값의 빈도를 저장할 해시맵 생성
        HashMap<Integer, Integer> voteCount = new HashMap<>();

        // 투표 수 카운트
        for (int vote : votes) {
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }

        // 가장 많이 나온 값을 확인하고 과반수인지 판별
        for (int key : voteCount.keySet()) {
            if (voteCount.get(key) > half) {
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Week7_2 solution = new Week7_2();
        int[] votes = {1, 4, 2, 2, 2, 3, 2, 2, 1};
        int answer = solution.solution(votes);
        System.out.println(answer); // 출력: 2
    }
}
