package programmers.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week4_1 {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        // 결과를 저장할 2차원 리스트
        List<List<String>> result = new ArrayList<>();

        // 각 문제에 대해 처리
        for (String problem : problems) {
            List<String> matchingTitles = new ArrayList<>();

            // 모든 노래 가사를 탐색
            for (int i = 0; i < lyrics.length; i++) {
                if (lyrics[i].startsWith(problem)) {
                    matchingTitles.add(titles[i]);
                }
            }

            // 매칭 결과를 리스트에 추가
            result.add(matchingTitles);
        }

        // 2차원 리스트를 2차원 배열로 변환
        String[][] answer = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).toArray(new String[0]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Week4_1 solution = new Week4_1();
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = {
                "산다는게다그런거지누구나빈손으로와...(후략)",
                "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)",
                "개울가에올챙이한마리꼬물꼬물헤엄치다...(후략)",
                "산다는건다그런거래요힘들고아픈날도많지만...(후략)"
        };
        String[] problems = {"산다", "아기상어", "올챙이"};

        String[][] result = solution.solution(titles, lyrics, problems);

        // 결과 출력
        for (String[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}

