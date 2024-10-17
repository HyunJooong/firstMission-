package baekjun; //백준에서 빼주기

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PoStack { //백준에서 main으로 바꿔주기

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        List<Integer> sunList = new ArrayList<>(); // 순열 원소들을 담을 배열 선언

        int n = sc.nextInt(); //순열의 길이
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            sunList.add(number); // 순열 원소들 반복문을 이용해 배열에 add
        }

        Stack<Integer>[] stack = new Stack[4]; // 4개의 stack 배열 함수 선언
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Stack<>();
            stack[i].push(0); // 순열 원소에서 가장 작은 수는 1이기 때문에 모든 스택의 첫 번째에 0을 가장 먼저 push
        }


        for (int i = 0; i < sunList.size(); i++) {
            boolean flag = false; // false는 NO
            for (int j = 0; j < stack.length; j++) {
                if (stack[j].peek() < sunList.get(i)) {
                    stack[j].push(sunList.get(i));
                    flag = true; //true는 YES
                    break;
                }
            }
            //반복문이 끝났는데 false이면 no
            if (!flag) {
                System.out.println("NO");
                return; // return을 안해주면 no랑 밑에 yes가 같이 출력 return을 해줘서 끝내줘야 함(출력초과 이슈)
            }
        }
        System.out.println("YES");
    }
}


