package baekjun.programmers;

import java.util.Arrays;

public class PWeek2_2 {
    public static void main(String[] args) {

        int[] arr = {9,4,7,5,10,4};
        PWeek2_2 obj = new PWeek2_2();
        System.out.println(obj.solution(arr));
    }

    public int solution(int[] arr){
        int answer = 0;

        Arrays.sort(arr);

        int cnt = 0;
        int result = 0;
        for(int i = 1; i < arr.length - 1; i++){
            result += arr[i];
            cnt++;
        }
        answer = result / cnt;

        return answer;
    }
}
