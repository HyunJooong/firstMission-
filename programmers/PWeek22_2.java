package programmers;

import java.util.ArrayList;
import java.util.List;

public class PWeek22_2 {
    public static void main(String[] args) {
        int[] arr = {0,2,1,4,3,0};
        PWeek22_2 pp = new PWeek22_2();
       // System.out.println(pp.solution(arr));
        for(int answer : pp.solution(arr)){
            System.out.print(answer + " ");
        }
    }
    public int[] solution(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if(arr[i] % 2 != 0){
                list.add(arr[i]); // 홀수이면 한 번 더 추가
            }
        }


        //배열 길이에 변화가 없으니 파라미터 배열 만큼만 반복문 실행
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
