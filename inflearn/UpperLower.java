package inflearn;

import java.util.Scanner;

public class UpperLower {
    public String solution(String obj){
        String answer = "";
        int tmp = 0;
        for(int i = 0; i < obj.length(); i++){
            tmp = obj.charAt(i); // 아스키문자로 변환
            if(tmp>= 97 && tmp<=122 ){ // 소문자 경우
                answer += (char)(tmp-32);
            }else if(tmp>=65 && tmp<=90){ // 대문자 경우
                answer += (char)(tmp+32);
            }
        }
        return answer;

    }
    public static void main(String[] args) {
        UpperLower obj = new UpperLower();
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();


        System.out.println(obj.solution(a));


    }


}
