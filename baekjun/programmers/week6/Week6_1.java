package baekjun.programmers.week6;

public class Week6_1 {
    public static void main(String[] args) {
        int[] values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156};
        Week6_1 solution = new Week6_1();
        int[] result = solution.solution(values);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public int[] solution(int[] values) {
        if (values == null || values.length < 2) {
            return new int[]{0, 0};
        }

        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 0;

        int currentStart = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[i - 1]) {
                // Continuing the increasing sequence
                if (i - currentStart > maxLength) {
                    maxStart = currentStart;
                    maxEnd = i;
                    maxLength = i - currentStart;
                }
            } else {
                // Sequence breaks, reset start
                currentStart = i;
            }
        }

        // If no increasing sequence is found, return {0, 0}
        if (maxLength == 0) {
            return new int[]{0, 0};
        }

        return new int[]{maxStart, maxEnd};
    }
}
