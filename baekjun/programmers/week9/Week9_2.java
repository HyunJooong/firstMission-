package baekjun.programmers.week9;

import java.util.*;

class Week9_2 {
    public int solution(int N, int[][] flight, int a, int b, int k) {
        // 비용을 저장할 배열 초기화
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[a] = 0;

        // 큐를 사용한 BFS 접근 (현재 도시, 남은 비행 횟수, 누적 비용)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, 0, 0}); // {현재 도시, 경유 횟수, 비용}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0];
            int stops = current[1];
            int currentCost = current[2];

            // 남은 비행 횟수가 k번 이하인 경우만 진행
            if (stops > k) continue;

            for (int[] flightInfo : flight) {
                if (flightInfo[0] == city) {
                    int nextCity = flightInfo[1];
                    int flightCost = flightInfo[2];

                    if (currentCost + flightCost < cost[nextCity]) {
                        cost[nextCity] = currentCost + flightCost;
                        queue.offer(new int[]{nextCity, stops + 1, cost[nextCity]});
                    }
                }
            }
        }

        // 최종적으로 도착지 비용 확인
        return cost[b] == Integer.MAX_VALUE ? -1 : cost[b];
    }
}