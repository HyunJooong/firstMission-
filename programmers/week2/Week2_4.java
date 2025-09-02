package programmers.week2;

import java.util.LinkedList;
import java.util.Queue;

public class Week2_4 {
    public static int countLostMessages(int delay, int capacity, int[] times) {
        Queue<Integer> queue = new LinkedList<>();
        int lostMessages = 0;
        int currentTime = 0;

        for (int time : times) {
            // 다음 메시지까지 걸린 시간 만큼 현재 시간 업데이트
            currentTime += time;

            // 큐에서 메시지 제거 (처리 완료된 메시지들 제거)
            while (!queue.isEmpty() && queue.peek() <= currentTime) {
                queue.poll();
            }

            // 메시지를 큐에 추가
            if (queue.size() < capacity) {
                queue.add(currentTime + delay); // 메시지가 처리 완료되는 시점
            } else {
                // 큐가 가득 찬 경우 메시지가 손실됨
                lostMessages++;
            }
        }

        return lostMessages;
    }

}
