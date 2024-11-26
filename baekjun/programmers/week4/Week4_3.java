package baekjun.programmers.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week4_3 {
    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            List<String> result = new ArrayList<>();

            for (String word : words) {
                if (isMatch(word, query)) {
                    result.add(word);
                }
            }

            // 결과를 리스트에서 배열로 변환하여 저장
            answer[i] = result.toArray(new String[0]);
        }

        return answer;
    }

    // 검색 조건 확인 메서드
    private boolean isMatch(String word, String query) {
        if (word.length() != query.length()) {
            return false;
        }

        for (int j = 0; j < query.length(); j++) {
            char qChar = query.charAt(j);
            char wChar = word.charAt(j);

            if (qChar != '?' && qChar != wChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Week4_3 solution = new Week4_3();
        String[] words = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"he??", "g???", "childre?", "goo????", "?"};

        String[][] result = solution.solution(words, queries);

        // 출력 결과를 보기 좋게 출력
        for (String[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}

