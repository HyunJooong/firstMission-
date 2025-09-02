package programmers.week5;

import java.util.Arrays;

public class Week5_4 {

    public int solution(int N, int[] branches) {
        // 나뭇가지 길이의 최대 길이를 찾기 위해 이분 탐색을 수행
        int left = 1; // 교보재 나뭇가지의 최소 길이
        int right = Arrays.stream(branches).max().getAsInt(); // 가장 긴 나뭇가지의 길이
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2; // 교보재 나뭇가지의 후보 길이
            if (canMake(N, branches, mid)) {
                answer = mid; // 길이 `mid`로 N개 이상 만들 수 있음
                left = mid + 1; // 더 긴 길이를 시도
            } else {
                right = mid - 1; // 더 짧은 길이를 시도
            }
        }

        return answer;
    }

    // 주어진 길이로 N개의 교보재 나뭇가지를 만들 수 있는지 확인하는 함수
    private boolean canMake(int N, int[] branches, int length) {
        int count = 0;
        for (int branch : branches) {
            count += branch / length; // 해당 나뭇가지로 만들 수 있는 교보재 수
            if (count >= N) {
                return true; // N개 이상 만들 수 있으면 true 반환
            }
        }
        return false; // N개 만들 수 없으면 false 반환
    }

    public static void main(String[] args) {
        Week5_4 week5_4 = new Week5_4();
        int N = 10;
        int[] branches = {6, 7, 10, 16, 12};

        int result = week5_4.solution(N, branches);
        System.out.println("Maximum branch length: " + result); // Expected output: 4
    }
}
