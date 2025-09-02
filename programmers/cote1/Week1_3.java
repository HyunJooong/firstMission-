package programmers.cote1;

public class Week1_3 {
    public int solution(int N) {
        if (N == 0) return 1;
        if (N == 1) return 1;

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public static void main(String[] args) {
        Week1_3 sol = new Week1_3();
        int result = sol.solution(4);
        System.out.println("결과: " + result); // 예상 결과: 5
    }
}
