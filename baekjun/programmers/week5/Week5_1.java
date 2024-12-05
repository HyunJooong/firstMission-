package baekjun.programmers.week5;

import java.util.Arrays;

public class Week5_1 {

    public boolean solution(String s, String t) {
        // 두 문자열 길이가 다르면 애너그램이 될 수 없음
        if (s.length() != t.length()) {
            return false;
        }

        // 문자열을 문자 배열로 변환 후 정렬
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // 정렬된 배열이 같으면 true, 다르면 false
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        Week5_1 week5_1 = new Week5_1();
        String s = "imfinethankyou";
        String t = "atfhinemnoyuki";

        boolean result = week5_1.solution(s, t);
        System.out.println("Are they anagrams? " + result); // Expected output: true
    }
}
