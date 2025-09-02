package programmers;

import java.util.HashMap;

public class PWeek22_4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int[] arr2 = {44, 22, 33, 22, 44, 33};
        PWeek22_4 obj = new PWeek22_4();
        System.out.println(obj.solution(arr2));
    }

    public int solution(int[] arr) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(arr[i]) == 1) {
                answer += arr[i];
            } else answer = 0;
        }


        return answer;
    }

}
