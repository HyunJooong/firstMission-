package baekjun.programmers;

import java.util.Arrays;

public class PWeek23_2 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        PWeek23_2 obj = new PWeek23_2();
        for(int n : obj.solution(arr)){
            System.out.println(n);
        }
    }

    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];

        Arrays.sort(nums);

        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = cnt;
            cnt++;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != answer[i]){
                result[i] = answer[i];
            }
        }
        return result;
    }
}
