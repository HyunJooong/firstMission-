package baekjun;

import java.util.*;

public class SpinQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);//순서대로 큐에 넣기
        }


        int cnt = 0; // 회전 횟수
        for (int i = 0; i < m; i++) { // arr 배열의 각 값을 처리
            int target = arr[i]; // 이번에 뽑아낼 목표 숫자

            // 목표 숫자의 위치를 큐에서 찾음
            int idx = 0;
            for (int num : dq) {
                if (num == target) break;
                idx++;
            }

            // 왼쪽 회전이 빠른지 오른쪽 회전이 빠른지 판단
            if (idx <= dq.size() / 2) {
                // 왼쪽 회전
                while (dq.peekFirst() != target) {
                    dq.addLast(dq.pollFirst()); // 앞에서 빼서 뒤로 넣음
                    cnt++;
                }
            } else {
                // 오른쪽 회전
                while (dq.peekFirst() != target) {
                    dq.addFirst(dq.pollLast()); // 뒤에서 빼서 앞으로 넣음
                    cnt++;
                }
            }

            // 목표 숫자를 큐에서 제거
            dq.pollFirst();
        }

        System.out.println(cnt); // 총 회전 횟수 출력
}

}
