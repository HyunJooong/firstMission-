package baekjun;

import java.util.Scanner;

public class DIce {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int result = 0;
        if(a == b && a == c){
            result = 10000 + a * 1000;
        }else if(a == b || a == c){
            result = 1000 + a * 100;
        }else if(b == c){
            result = 1000 + b * 100;
        }else {
            result = Math.max(a, Math.max(b, c)) * 100; // Math 함수를 이용해 int형 변수 두개씩 비교하기
        }
        System.out.println(result);

    }

}
