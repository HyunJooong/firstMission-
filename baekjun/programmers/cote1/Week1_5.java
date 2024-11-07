package baekjun.programmers.cote1;

public class Week1_5 {
    public long solution(int N, int M, int K, int[] capacity) {
        // DP 테이블: dp[i][j]는 i명의 학생을 j개의 교실에 배치하는 경우의 수를 저장
        long[][] dp = new long[N + 1][M + 1];
        dp[0][0] = 1; // 학생 0명을 0개의 교실에 배치하는 경우의 수는 1

        // 교실을 하나씩 사용하면서 학생을 배치
        for (int room = 1; room <= M; room++) {
            int cap = capacity[room - 1]; // 현재 교실의 최대 수용 인원

            for (int students = 0; students <= N; students++) {
                // 현재 학생 수에서 0명부터 최대 cap명까지 배치 가능
                for (int assigned = 0; assigned <= Math.min(students, cap); assigned++) {
                    dp[students][room] += dp[students - assigned][room - 1];
                }
            }
        }

        return dp[N][M];
    }

    public static void main(String[] args) {
        Week1_5 sol = new Week1_5();
        int N = 10;
        int M = 3;
        int K = 4;
        int[] capacity = {3, 3, 4};
        long result = sol.solution(N, M, K, capacity);
        System.out.println("결과: " + result); // 예상 결과: 100800
    }
}
