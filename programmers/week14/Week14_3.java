package programmers.week14;

import java.util.*;

public class Week14_3 {

    static class State {
        int x, y, turn, isDay;

        State(int x, int y, int turn, int isDay) {
            this.x = x;
            this.y = y;
            this.turn = turn;
            this.isDay = isDay;
        }
    }

    static int[] dx = {0, 0, 1, -1, 0}; // 이동 방향 (제자리 포함)
    static int[] dy = {1, -1, 0, 0, 0};

    public int solution(int[][] maze) {
        int N = maze.length;
        int M = maze[0].length;

        boolean[][][] visited = new boolean[N][M][2]; // 낮/밤 구분하여 방문 체크
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, 1)); // 시작점 (낮 상태)

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            // 도착하면 최소 턴 반환
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.turn;
            }

            // 낮(1) 또는 밤(0) 판별
            int nextDayState = (cur.turn / 5) % 2 == 0 ? 1 : 0;

            // 이동 시도
            for (int i = 0; i < 5; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (maze[nx][ny] == 1) continue; // 벽(1) 통과 불가

                    // 밤에 몬스터 위협 지역 확인
                    if (nextDayState == 0 && isThreatened(maze, nx, ny, N, M)) {
                        continue;
                    }

                    // 방문 체크
                    if (!visited[nx][ny][nextDayState]) {
                        visited[nx][ny][nextDayState] = true;
                        queue.add(new State(nx, ny, cur.turn + 1, nextDayState));
                    }
                }
            }
        }
        return -1; // 탈출 불가능
    }

    // 몬스터 위협 지역 확인
    private boolean isThreatened(int[][] maze, int x, int y, int N, int M) {
        int[] mx = {0, 1, -1, 0, 0}; // 자기 포함 상하좌우
        int[] my = {0, 0, 0, 1, -1};

        for (int i = 0; i < 5; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (maze[nx][ny] == 2) return true; // 위협 지역
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Week14_3 sol = new Week14_3();

        int[][] maze1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 2, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(sol.solution(maze1)); // 최소 이동 횟수 출력
    }
}
