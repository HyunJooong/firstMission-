package baekjun;

public class Pre5_2 {
    public static void main(String[] args) {

    }
    public boolean solution(int n) {
        boolean answer = true;

        if(n == 2){
            return true;
        }

        if (n <= 1) return false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0){
                answer = false;
            }
        }
        return answer;
    }
}
