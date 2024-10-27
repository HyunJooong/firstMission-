package baekjun;

public class Pre4_3 {
    public static void main(String[] args) {

        int n = 10;
        Pre4_3 pre43 = new Pre4_3();
        System.out.println(pre43.solution(n));

    }
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
