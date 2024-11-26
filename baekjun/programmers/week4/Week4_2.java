package baekjun.programmers.week4;
import java.util.*;
public class Week4_2 {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                String query = queries[i];
                int count = 0;

                if (query.startsWith("*")) {
                    // 뒷부분 일부로 구성된 경우
                    String suffix = query.substring(1); // '*' 제외한 부분
                    for (String word : words) {
                        if (word.endsWith(suffix)) {
                            count++;
                        }
                    }
                } else if (query.endsWith("*")) {
                    // 앞부분 일부로 구성된 경우
                    String prefix = query.substring(0, query.length() - 1); // '*' 제외한 부분
                    for (String word : words) {
                        if (word.startsWith(prefix)) {
                            count++;
                        }
                    }
                } else {
                    // 정확히 일치하는 경우
                    for (String word : words) {
                        if (word.equals(query)) {
                            count++;
                        }
                    }
                }

                answer[i] = count;
            }

            return answer;
        }

    public static void main(String[] args) {
        Week4_2 week4_2 = new Week4_2();
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hel*", "*able", "*d", "goose", "children", "card", "teachable"};
        int[] result = week4_2.solution(words, queries);
        System.out.println(Arrays.toString(result)); // [2, 2, 1, 1, 1, 1, 1]
    }
}
