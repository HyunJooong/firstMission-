package baekjun.programmers.week6;

import java.util.*;

public class Week6_3 {
        public int solution(String[] ingredients, String[] items) {
            // Convert ingredients to a set for fast lookup
            Set<String> ingredientSet = new HashSet<>(Arrays.asList(ingredients));

            // Map to count occurrences of each ingredient in the current window
            Map<String, Integer> windowCount = new HashMap<>();

            int left = 0;
            int right = 0;
            int minLength = Integer.MAX_VALUE;
            int matched = 0;

            while (right < items.length) {
                // Add the rightmost item to the window
                String currentItem = items[right];
                if (ingredientSet.contains(currentItem)) {
                    windowCount.put(currentItem, windowCount.getOrDefault(currentItem, 0) + 1);
                    // Count only when the first occurrence is added
                    if (windowCount.get(currentItem) == 1) {
                        matched++;
                    }
                }

                // Try to shrink the window from the left
                while (matched == ingredientSet.size()) {
                    minLength = Math.min(minLength, right - left + 1);
                    String leftItem = items[left];
                    if (ingredientSet.contains(leftItem)) {
                        windowCount.put(leftItem, windowCount.get(leftItem) - 1);
                        if (windowCount.get(leftItem) == 0) {
                            matched--;
                        }
                    }
                    left++;
                }

                right++;
            }

            return minLength;
        }

        public static void main(String[] args) {
            Week6_3 solution = new Week6_3();
            String[] ingredients = {"생닭", "인삼", "소주", "대초"};
            String[] items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대초", "삼"};
            System.out.println(solution.solution(ingredients, items)); // Output should be 7
        }
    }
