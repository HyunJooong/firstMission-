package baekjun;


import java.util.Scanner;

public class Baek_5597 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        //출석부
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }

        //결석 학생 2명(과제 안낸 사람)
        int[] arr = new int[28];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            a[arr[i]] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                System.out.println(i);
            }
        }
    }
}