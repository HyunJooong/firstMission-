package programmers.week11;

import java.util.*;

public class Week11_3 {
    public boolean week11_3(String s, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        return canForm(s, wordSet, new HashMap<>());
    }

    private boolean canForm(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (s.isEmpty()) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                if (canForm(s.substring(word.length()), wordSet, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        Week11_3 solution = new Week11_3();
        String s = "zerobase";
        String[] words = {"zero", "ro", "ze", "base"};
        System.out.println(solution.week11_3(s, words)); // Expected: true
    }
}
