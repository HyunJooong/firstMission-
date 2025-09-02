package programmers.week3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Week3_2 {
    public int solution(int[] numbers, int target) {
        // BFS 탐색을 위한 큐와 방문 확인용 Set
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // 초기 상태를 큐에 삽입
        for (int num : numbers) {
            queue.offer(new Node(num, 1)); // 시작 숫자와 초기 카운트
            visited.add(num);
        }

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 목표 값에 도달한 경우
            if (current.value == target) {
                return current.count;
            }

            // 다음 숫자 조합을 탐색
            for (int num : numbers) {
                int[] results = new int[]{
                        current.value + num,
                        current.value - num,
                        current.value * num,
                        num != 0 && current.value % num == 0 ? current.value / num : -1 // 나누기는 유효한 경우만
                };

                for (int nextValue : results) {
                    if (nextValue > 0 && !visited.contains(nextValue)) { // 방문하지 않은 양수만 추가
                        queue.offer(new Node(nextValue, current.count + 1));
                        visited.add(nextValue);
                    }
                }
            }
        }

        return -1; // target을 만들 수 없는 경우
    }

    // Node 클래스 정의: 현재 값과 사용된 숫자 개수를 저장
    static class Node {
        int value;
        int count;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Week3_2 sol = new Week3_2();
        int[] numbers = {1, 2, 4};
        int target = 12;
        System.out.println("최소 숫자 개수: " + sol.solution(numbers, target));
    }
}
