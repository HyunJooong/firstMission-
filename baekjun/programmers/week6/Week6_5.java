package baekjun.programmers.week6;

import java.util.Arrays;

public class Week6_5 {
        public int[] solution(int[] scores) {
            if (scores == null || scores.length == 0) {
                return new int[0];
            }

            int n = scores.length;
            int[] chocolates = new int[n];
            Arrays.fill(chocolates, 1); // Each student gets at least one chocolate

            // Left-to-right pass
            for (int i = 1; i < n; i++) {
                if (scores[i] > scores[i - 1]) {
                    chocolates[i] = chocolates[i - 1] + 1;
                }
            }

            // Right-to-left pass
            for (int i = n - 2; i >= 0; i--) {
                if (scores[i] > scores[i + 1]) {
                    chocolates[i] = Math.max(chocolates[i], chocolates[i + 1] + 1);
                }
            }

            return chocolates;
        }

        public static void main(String[] args) {
            Week6_5 solution = new Week6_5();
            int[] scores = {1, 3, 5, 4, 5, 5, 5, 1};
            System.out.println(Arrays.toString(solution.solution(scores))); // Output: [1, 2, 3, 1, 2, 1, 2, 1]
        }
    }



