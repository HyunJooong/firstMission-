package baekjun;

import java.util.ArrayDeque;
import java.util.Deque;

// 미완성
public class Snowball {
    public static void main(String[] args){

        Snowball s = new Snowball();

        System.out.println(s.solution(5, "snowball", 18));

    }

    public String solution(int n, String s, int t) {
        String answer = "";
        //StringBuilder answer = new StringBuilder();
/*
        char[] a = new char[n];
        for(int i = 0; i < n; i++){
            a[i] = '.';
        }*/

        //전광판
        Deque<Character> dq = new ArrayDeque<Character>();
        for(int i = 0; i < n; i++){
            dq.add('.');
        }

            int cnt = 0;
       // for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t; j++){
                if(j >= 1) {
                    dq.poll();
                    dq.addLast(s.charAt(cnt));
                    cnt++;
                    if(cnt == n){
                        cnt = 0;
                    }
                }
            }
        //}
        for(int i = 0; i < dq.size(); i++){
            answer += dq.poll();
        }



        return answer;
    }
}
