package baekjun.programmers.week11;

import java.util.Arrays;

public class Week11_1 {

    //num = 15223
    //n = 2
    public int solution(int n, int num) {
        String stringNum = String.valueOf(num);
        char[] charNum = stringNum.toCharArray();

        Arrays.sort(charNum); // 정렬

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < charNum.length; j++) {
                if (i < charNum.length - 1 && charNum[j] == charNum[j + 1]) {
                    cnt++;
                } else {
                    sb.append(charNum[j]).append(cnt);
                    cnt = 1;
                }
            }
        }

        return 10;
    }

    public static void main(String[] args) {

        int num = 15223;

        String stringNum = String.valueOf(num);
        char[] charNum = stringNum.toCharArray();

        Arrays.sort(charNum); // 정렬

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < charNum.length; i++)
            if (i < charNum.length - 1 && charNum[i] == charNum[i + 1]) {
                cnt++;
            } else {
                sb.append(charNum[i]).append(cnt);
                cnt = 1;
            }

        System.out.println(sb.toString());


    }

}
