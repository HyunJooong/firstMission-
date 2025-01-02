package baekjun.programmers.week9;

import java.util.*;

public class Week9_1 {
    public int solution(int N, int[][] friends, int[][] time) {
        // 최소 시간을 추적하기 위한 배열 초기화
        int[] minTime = new int[N];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();

        // 0번 친구가 거짓말을 믿기 시작 (시작 시간은 0)
        queue.offer(new int[]{0, 0}); // {현재 친구, 현재 시간}
        minTime[0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentFriend = current[0];
            int currentTime = current[1];

            // 현재 친구와 연결된 친구들 탐색
            for (int i = 0; i < friends[currentFriend].length; i++) {
                int nextFriend = friends[currentFriend][i];
                int spreadTime = time[currentFriend][i];

                // 다음 친구가 거짓말을 믿기 시작하는 시간 계산
                int nextTime = currentTime + spreadTime;

                // 이미 최소 시간보다 오래 걸린다면 건너뜀
                if (nextTime < minTime[nextFriend]) {
                    minTime[nextFriend] = nextTime;
                    queue.offer(new int[]{nextFriend, nextTime});
                }
            }
        }

        // 모든 친구가 거짓말을 믿는 데 걸린 최대 시간 계산
        int maxTime = 0;
        for (int t : minTime) {
            if (t == Integer.MAX_VALUE) {
                return -1; // 어떤 친구는 거짓말을 믿지 못함
            }
            maxTime = Math.max(maxTime, t);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        Week9_1 sol = new Week9_1();
        int[][] friends = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}};
        int[][] time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}};
        int N = 5;

        System.out.println(sol.solution(N, friends, time)); // 출력: 9
    }
}
