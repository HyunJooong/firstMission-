package baekjun;

public class Pre5_4 {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i < n; i++) {
            if(i * i == n){
                answer = i;
                break;
            } else if (i * i > n) {
                break; // i^2이 n보다 커지면 더 이상 검사할 필요 없음
            }
        }
        return answer;
    }
}
