package baekjun.programmers.week3;

import java.util.HashSet;
import java.util.Set;

public class Week3_1 {
    public int solution(int n, int[][] trust){
        Set<Integer> uniqueValues = new HashSet<>();

        // 이차원 배열 trust의 두 번째 값을 Set에 추가
        for (int[] t : trust) {
            uniqueValues.add(t[1]);
        }

        // Set의 크기가 1이면 모든 값이 같음, 아니면 -1 반환
        return uniqueValues.size() == 1 ? uniqueValues.iterator().next() : -1;
    }
}
