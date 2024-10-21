package baekjun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        //LinkedList 요세푸스

        int n = sc.nextInt(); //원소수
        int k = sc.nextInt(); //칸수

        Deque<Integer> dq = new ArrayDeque<Integer>();

        ArrayList<Integer> arr = new ArrayList<>();
        // dq에 순서대로 값 넣기
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }
        int count = 0; // 현재 위치 카운트
        while (!dq.isEmpty()) {
            count++;
            // k번째 사람이면 제거하고 리스트에 추가
            if (count == k) {
                arr.add(dq.pollFirst());
                count = 0; // 카운트 초기화
            } else {
                // k번째가 아니면 맨 앞에서 꺼내서 다시 뒤로 넣음
                dq.addLast(dq.pollFirst());
            }
        }

        // 결과 출력
        for (int i = 0; i < arr.size(); i++) {
            if(i == 0){
                System.out.print("<");
            }
            System.out.print(arr.get(i));
            if(i == arr.size() - 1){
                System.out.println(">");
            }
            if (i < arr.size() - 1) {
                System.out.print(", ");
            }
        }
        sc.close();
    }
}

//첫번째 시도
/*
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 원소 수
        int k = sc.nextInt(); // 칸 수

        Deque<Integer> dq = new ArrayDeque<Integer>();
        ArrayList<Integer> arr = new ArrayList<>();

        // dq에 순서대로 값 넣기
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        int count = 0; // 현재 위치 카운트
        while (!dq.isEmpty()) {
            count++;
            // k번째 사람이면 제거하고 리스트에 추가
            if (count == k) {
                arr.add(dq.pollFirst());
                count = 0; // 카운트 초기화
            } else {
                // k번째가 아니면 맨 앞에서 꺼내서 다시 뒤로 넣음
                dq.addLast(dq.pollFirst());
            }
        }

        // 결과 출력
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i < arr.size() - 1) {
                System.out.print(", ");
            }
        }
        sc.close();
    }
}
*/
