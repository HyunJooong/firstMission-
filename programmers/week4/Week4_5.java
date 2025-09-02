package programmers.week4;

import java.util.*;

public class Week4_5 {
    public int[][] solution(int[][] buildings) {
        List<int[]> edges = new ArrayList<>();
        // 모든 건물의 시작과 끝점을 추출
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            edges.add(new int[]{left, height});  // 시작점
            edges.add(new int[]{right, -height}); // 끝점
        }

        // 엣지 정렬 (x값 기준, 같은 x에서는 높이 순으로 처리)
        edges.sort((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1); // 바닥 높이 0을 초기화

        int prevMaxHeight = 0;

        for (int[] edge : edges) {
            int x = edge[0];
            int height = edge[1];

            if (height > 0) {
                // 시작점: 높이를 추가
                heightMap.put(height, heightMap.getOrDefault(height, 0) + 1);
            } else {
                // 끝점: 높이를 제거
                int absoluteHeight = -height;
                if (heightMap.get(absoluteHeight) == 1) {
                    heightMap.remove(absoluteHeight);
                } else {
                    heightMap.put(absoluteHeight, heightMap.get(absoluteHeight) - 1);
                }
            }

            // 현재 최대 높이 계산
            int currentMaxHeight = heightMap.firstKey();

            // 높이가 변경되면 키포인트 추가
            if (currentMaxHeight != prevMaxHeight) {
                result.add(new int[]{x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }

        // 결과를 2차원 배열로 변환하여 반환
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Week4_5 solution = new Week4_5();
        int[][] buildings = {{1, 8, 4}, {2, 4, 10}, {3, 5, 6}, {10, 12, 6}};
        int[][] result = solution.solution(buildings);

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
        // Expected output: [[1, 4], [2,

    }
}
