package programmers.week6;

import java.util.Arrays;

public class Week6_2 {
        public static void main(String[] args) {
            int[] amount = {7, 10, 4, 5};
            int[] value = {5, 4, 3, 1};
            int[] stomach = {4, 6, 2, 8};
            Week6_2 solution = new Week6_2();
            int result = solution.solution(amount, value, stomach);
            System.out.println(result);
        }

        public int solution(int[] amount, int[] value, int[] stomach) {
            int n = amount.length;
            int maxValue = 0;

            // Calculate value per unit of each meat type
            double[] valuePerUnit = new double[n];
            for (int i = 0; i < n; i++) {
                valuePerUnit[i] = (double) value[i] / amount[i];
            }

            // Sort indices based on value per unit in descending order
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, (a, b) -> Double.compare(valuePerUnit[b], valuePerUnit[a]));

            // Distribute meat to maximize value
            for (int idx : indices) {
                int maxStomach = Arrays.stream(stomach).min().orElse(0); // Find the smallest stomach capacity

                if (maxStomach == 0) {
                    break; // No one can eat more
                }

                int eatAmount = Math.min(maxStomach, amount[idx]);
                if (eatAmount > 0) {
                    maxValue += eatAmount * valuePerUnit[idx];

                    // Deduct the distributed meat and update stomach capacities
                    for (int i = 0; i < stomach.length; i++) {
                        stomach[i] -= eatAmount;
                    }
                    amount[idx] -= eatAmount;
                }
            }

            return maxValue;
        }
    }

