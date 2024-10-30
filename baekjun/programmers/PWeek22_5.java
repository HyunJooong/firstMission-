package baekjun.programmers;

public class PWeek22_5 {
    public static void main(String[] args) {

        int n = 340;
        PWeek22_5 obj = new PWeek22_5();

        System.out.println(obj.solution(n));

    }
    public int solution(int num) {
        // 마이너스 부호 절대값으로 만들기
        int answer = Math.abs(num);

        int reversed = 0;
        // 자릿수를 하나씩 뒤집기
        while (answer != 0) {
            int digit = answer % 10;
            reversed = reversed * 10 + digit;
            answer /= 10;
        }
        // 이 범위면은 0 출력
        if(reversed > 100000 || reversed < -100000){
            reversed = 0;
        }

        // 원래 숫자가 음수였으면 결과도 음수로 변환
        return num < 0 ? -reversed : reversed;

    }
}
