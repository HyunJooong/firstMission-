package baekjun.programmers.week9;

import java.util.*;

public class Week9_5 {

    public int solution(int N, int[][] relations) {
        // 그래프 생성
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] relation : relations) {
            int from = relation[0];
            int to = relation[1];
            int time = relation[2];
            graph.get(from).add(new int[]{to, time});
        }

        // 최소 시간을 계산하기 위한 배열
        int[] minTime = new int[N];
        Arrays.fill(minTime, 30); // 기본적으로 한 문제를 독립적으로 공부할 때의 시간

        // 방문 여부 체크
        boolean[] visited = new boolean[N];

        // DFS를 이용한 시간 계산
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, graph, minTime, visited);
            }
        }

        // 모든 문제를 공부하는 데 걸리는 최소 시간 계산
        int totalTime = 0;
        for (int time : minTime) {
            totalTime += time;
        }

        return totalTime;
    }

    private void dfs(int node, Map<Integer, List<int[]>> graph, int[] minTime, boolean[] visited) {
        visited[node] = true;
        for (int[] neighbor : graph.get(node)) {
            int next = neighbor[0];
            int time = neighbor[1];

            // 다음 문제를 공부하는 데 걸리는 최소 시간 갱신
            if (!visited[next]) {
                dfs(next, graph, minTime, visited);
            }
            minTime[node] = Math.min(minTime[node], 30 + minTime[next] - time);
        }
    }

    public static void main(String[] args) {
        Week9_5 solution = new Week9_5();
        int n = 6;
        int[][] relations = {
                {2, 3, 15},
                {1, 5, 10},
                {3, 4, 25},
                {1, 2, 27},
                {1, 4, 29},
                {2, 5, 5}
        };

        System.out.println(solution.solution(n, relations)); // 출력: 115
    }
}
