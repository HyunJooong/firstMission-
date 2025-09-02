package programmers.week6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Week6_4 {
        public int[] solution(int[] arr, int k) {
            if (arr == null || arr.length == 0 || k <= 0) {
                return new int[0];
            }

            int n = arr.length;
            int[] answer = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // Remove elements out of the current window
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // Remove smaller elements as they are not useful
                while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                    deque.pollLast();
                }

                // Add the current element index
                deque.offerLast(i);

                // Add the maximum element of the current window to the answer
                if (i >= k - 1) {
                    answer[i - k + 1] = arr[deque.peekFirst()];
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Week6_4 solution = new Week6_4();
            int[] arr = {4, 2, 6, 4, 2, 3};
            int k = 3;
            System.out.println(Arrays.toString(solution.solution(arr, k))); // Output: [6, 6, 6, 4]
        }
    }

