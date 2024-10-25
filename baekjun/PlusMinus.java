package baekjun;

public class PlusMinus {
    public int calculate(String s) {
        int result = 0;
        int currentNumber = 0;
        int sign = 1; // 현재 부호, 초기값은 양수로 설정 (+)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 숫자라면, 여러 자리 숫자를 위해 자릿수 계산을 포함하여 현재 숫자를 생성
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                // 부호를 만나면 이전 숫자를 결과에 반영하고, 부호를 갱신
                result += sign * currentNumber;

                // 다음 숫자에 대한 부호 설정
                sign = (c == '+') ? 1 : -1;

                // 현재 숫자를 초기화
                currentNumber = 0;
            }
        }

        // 마지막 숫자 반영 (문자열 끝에서 마지막 숫자가 처리되지 않기 때문)
        result += sign * currentNumber;

        return result;
    }

    public static void main(String[] args) {
        PlusMinus sol = new PlusMinus();
        String s = "-3+26-7";
        System.out.println(sol.calculate(s)); // 16 출력
    }
}
