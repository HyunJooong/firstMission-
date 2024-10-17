package baekjun;

import java.util.*;

public class MinMax {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n개의 정수

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt()); // 정수 배열에 담기
        }
        Collections.sort(list); //arraylist 오름차순 정렬
        System.out.println(list.get(0) + " " + list.get(list.size() - 1));

    }
}
