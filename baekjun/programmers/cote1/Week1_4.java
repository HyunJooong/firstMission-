package baekjun.programmers.cote1;

public class Week1_4 {
    public int solution(int n, int i, int j) {
        return findValue(n, i, j, 1); // 초기값을 1로 시작
    }

    private int findValue(int size, int i, int j, int start) {
        // 2x2 배열의 경우, 기본 디귿자 패턴 반환
        if (size == 2) {
            if (i == 0 && j == 1) return start;
            if (i == 0 && j == 0) return start + 1;
            if (i == 1 && j == 0) return start + 2;
            if (i == 1 && j == 1) return start + 3;
        }

        int half = size / 2;
        int areaSize = half * half; // 각 부분 배열의 크기

        if (i < half && j >= half) { // 우측 상단
            return findValue(half, i, j - half, start);
        } else if (i < half && j < half) { // 좌측 상단
            return findValue(half, i, j, start + areaSize);
        } else if (i >= half && j < half) { // 좌측 하단
            return findValue(half, i - half, j, start + 2 * areaSize);
        } else { // 우측 하단
            return findValue(half, i - half, j - half, start + 3 * areaSize);
        }
    }

    public static void main(String[] args) {
        Week1_4 sol = new Week1_4();
        int n = 4;
        int i = 1;
        int j = 3;
        int result = sol.solution(n, i, j);
        System.out.println("결과: " + result); // 예상 결과: 4
    }
}
