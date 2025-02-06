package baekjun.programmers.week14;

public class Week14_1 {
    public int solution(int N, int M) {
        return N + M - gcd(N, M);
    }

    // Helper method to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
