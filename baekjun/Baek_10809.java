package baekjun;

import java.util.Scanner;

public class Baek_10809 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int[] arr = new int[26];

        //알파벳 순서대로 -1 대입
        for(int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        // 입력 받은 문자 - a를 해서 index 값 배열에 위치 넣기
        for(int i = 0; i <s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            if(arr[index] == -1) {
                arr[index] = i;
            }
        }

        for(int answer: arr){
            System.out.print(answer + " ");
        }
    }
}
