package programmers;

import java.util.Arrays;

public class PWeek2_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 60, 50, 7};
        int[] arr2 = {5, 19, 3, 23, 198, 34};
        //System.out.println(arr.length);
        PWeek2_1 obj = new PWeek2_1();
        System.out.println(obj.solution(arr));
        System.out.println(obj.solution(arr2));

    }

    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) { // 마지막 두 수는 더해도 의미가 없으니 배열 길이 -2까지만 반복
            if (arr[i] + arr[i + 1] > arr[i + 2]) {
                answer = arr[i] + arr[i + 1] + arr[i + 2]; 
            }
        }
        return answer;
    }

}
