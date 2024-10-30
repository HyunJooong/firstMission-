package baekjun.programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PWeek22_3 {

    public int solution(int n) {
        int answer = 0;

        int i = 1;
        int largestCube = 1;

        while (true) {
            int cube = i * i * i;
            if (cube > n) break;
            answer = cube;
            i++;
        }
        return answer;
    }
    public static void main(String[] args) {
        PWeek22_3 obj = new PWeek22_3();
        int n = 99;
        System.out.println(obj.solution(n));
    }

}
