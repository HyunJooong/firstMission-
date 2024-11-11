package baekjun;

import java.util.*;
import java.lang.*;

// Please name your class Main
class Average {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[10];

        Set<Integer> hash = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
            int result = arr[i] % 42; // 나머지를 넣는다.
            hash.add(result);
        }

        int answer =hash.size();

        System.out.print(answer);
    }
}