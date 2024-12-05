package baekjun.programmers.week5;

public class Week5_5 {
    public int solution(int N, int M, int[] fry, int[] clean) {
        // 이분 탐색을 위한 초기값 설정
        int left = 1; // 최소 시간
        int right = Integer.MAX_VALUE; // 최대 시간
        int answer = Integer.MAX_VALUE; // 최소 시간 결과

        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간값
            if (canCookInTime(N, M, fry, clean, mid)) {
                answer = mid; // 가능한 최소 시간
                right = mid - 1; // 더 적은 시간으로 시도
            } else {
                left = mid + 1; // 시간이 부족하므로 더 긴 시간으로 시도
            }
        }

        return answer;
    }

    // 주어진 시간 안에 M번 치킨을 튀길 수 있는지 확인하는 함수
    private boolean canCookInTime(int N, int M, int[] fry, int[] clean, int timeLimit) {
        int totalChicken = 0; // 총 튀겨낸 치킨 수

        for (int i = 0; i < N; i++) {
            int cycleTime = fry[i] + clean[i]; // 한 사이클(튀김 + 세척) 시간
            int fullCycles = timeLimit / cycleTime; // 주어진 시간 안에 수행 가능한 전체 사이클
            int remainingTime = timeLimit % cycleTime; // 사이클이 끝난 후 남는 시간

            // 한 사이클당 fry[i] 시간 동안 치킨 튀김 가능
            int chickenCount = fullCycles + (remainingTime >= fry[i] ? 1 : 0);
            totalChicken += chickenCount;

            // 목표치 이상이면 바로 true 반환
            if (totalChicken >= M) {
                return true;
            }
        }

        return totalChicken >= M; // 최종적으로 목표치에 도달하지 못한 경우 false 반환
    }

    public static void main(String[] args) {
        Week5_5 week5_5 = new Week5_5();
        int N = 2;
        int M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};

        int result = week5_5.solution(N, M, fry, clean);
        System.out.println("Minimum time required: " + result); // Expected output: 58
    }
}
