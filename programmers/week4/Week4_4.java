package programmers.week4;

import java.util.*;

public class Week4_4 {
        public int[] solution(int[] start, int[] time) {
            // 작업의 인덱스와 시작 시간, 처리 시간을 담은 리스트
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < start.length; i++) {
                tasks.add(new Task(i, start[i], time[i]));
            }

            // 처리 순서를 저장할 리스트
            List<Integer> result = new ArrayList<>();
            // 대기 작업들을 담을 우선순위 큐 (처리 시간 -> 인덱스 기준 정렬)
            PriorityQueue<Task> pq = new PriorityQueue<>((a, b) ->
                    a.time == b.time ? Integer.compare(a.index, b.index) : Integer.compare(a.time, b.time)
            );

            // 작업 리스트를 시작 시간 기준 정렬
            tasks.sort(Comparator.comparingInt(a -> a.start));

            int currentTime = 0;
            int taskIndex = 0;

            while (taskIndex < tasks.size() || !pq.isEmpty()) {
                // 현재 시간에 시작할 수 있는 작업을 대기열에 추가
                while (taskIndex < tasks.size() && tasks.get(taskIndex).start <= currentTime) {
                    pq.offer(tasks.get(taskIndex));
                    taskIndex++;
                }

                if (pq.isEmpty()) {
                    // 대기열이 비어 있으면 다음 작업의 시작 시간으로 건너뜀
                    currentTime = tasks.get(taskIndex).start;
                } else {
                    // 가장 처리 시간이 짧은 작업을 처리
                    Task currentTask = pq.poll();
                    result.add(currentTask.index);
                    currentTime += currentTask.time;
                }
            }

            // 결과를 배열로 변환
            return result.stream().mapToInt(i -> i).toArray();
        }

        // 작업 정보를 나타내는 클래스
        private static class Task {
            int index, start, time;

            Task(int index, int start, int time) {
                this.index = index;
                this.start = start;
                this.time = time;
            }
        }

        public static void main(String[] args) {
            Week4_4 solution = new Week4_4();
            int[] start = {0, 2, 3, 5, 6};
            int[] time = {2, 4, 2, 1, 3};
            int[] result = solution.solution(start, time);
            System.out.println(Arrays.toString(result)); // [0, 1, 3, 2, 4]
        }
    }

