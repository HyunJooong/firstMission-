package baekjun;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNum = sc.nextInt(); // 첫 번째 숫자
        //"="가 나올 떄 까지 반복
        while (sc.hasNext()) {
            String token = sc.next();
            if (token.equals("=")) {  // '=' 문자를 만나면 반복 종료
                break;
            }
            int n = sc.nextInt();
            if (token.equals("+")) {
                firstNum += n;
            } else if (token.equals("-")) {
                firstNum -= n;
            } else if (token.equals("*")) {
                firstNum *= n;
            } else {
                firstNum /= n;
            }
        }
        System.out.println(firstNum);
    }

}
