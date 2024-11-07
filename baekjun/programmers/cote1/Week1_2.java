package baekjun.programmers.cote1;

import java.util.*;

public class Week1_2 {
    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바","스쿨", "자바", "베이스", "베이스", "백엔드", "화이팅"};
        Week1_2 obj = new Week1_2();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < names.length; i++){
            set.add(names[i]);
        }

        for(String name : set){
            System.out.print(name);
        };
    }

    public static int solution(String[] names) {
        int answer = 0;

        // 중복 제거
        HashSet<String> set = new HashSet<>();
        for (String name : names) {
            set.add(name);
        }

        // 중복 제거된 이름 목록
        List<String> uniqueNames = new ArrayList<>(set);

        // 조합의 개수 계산
        answer = countCombinations(uniqueNames, 4, 0);

        return answer;
    }

    public static int countCombinations(List<String> names, int r, int start) {
        if (r == 0) {
            return 1; // 유효한 조합 하나를 의미
        }

        int count = 0;
        for (int i = start; i <= names.size() - r; i++) {
            count += countCombinations(names, r - 1, i + 1);
        }

        return count;
    }
}
