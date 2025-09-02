package programmers.cote1;

import java.util.Arrays;

public class Week1_1 {
    public static void main(String[] args){

        int n = 12;
        int answer = (int)Math.sqrt(11);
        Week1_1 obj = new Week1_1();
        System.out.println(answer);

    }
    //에라토스테네스의 체
    public int solution(int n) {
        //0,1은 소수가 아님
        if(n < 2 ){
            return  0;
        }

        int[] isPrime = new int[n];
        // 배열에 모두 1을 대입
        for (int i = 2; i < n; i++) {
            isPrime[i] = 1;
        }

        //루트 씌우기
       for(int i = 2; i <= (int)Math.sqrt(n); i++){
           if(isPrime[i] == 0) continue;

           //만일 소수가 아닌 경우 0으로 변환
           int num = i * 2;
           while(num < n){
               isPrime[num] = 0;
               num += i;
           }
       }

        return Arrays.stream(isPrime).sum();
    }
}
