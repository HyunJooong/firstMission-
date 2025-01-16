package baekjun.programmers.week11;

import java.util.*;

class Week11_2 {
    public int[] week11_2(int n) {
        Integer[] tempArray = new Integer[n];

        // Populate the array with numbers from 1 to n
        for (int i = 0; i < n; i++) {
            tempArray[i] = i + 1;
        }

        // Sort the array lexicographically based on the problem's requirements
        Arrays.sort(tempArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String strA = a.toString();
                String strB = b.toString();
                return strA.compareTo(strB); // Compare strings lexicographically
            }
        });

        // Convert Integer[] to int[]
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = tempArray[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Week11_2 week1 = new Week11_2();
        int n = 15; // Example input
        int[] result = week1.week11_2(n);

        // Print the sorted result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
