package baekjun.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PWeek2_5 {
    public static void main(String[] args) {
        int[] arr1 = {1,7,8,4};
        int[] arr2 = {4,2,6,8};

        PWeek2_5 obj = new PWeek2_5();
        int[] result = obj.solution(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
    public int[] solution(int arr1[], int[] arr2){

        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    list1.add(arr2[j]);
                }
            }
        }

        int[] answer = new int[list1.size()];
        for(int i = 0; i < list1.size(); i++){
            answer[i] = list1.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
