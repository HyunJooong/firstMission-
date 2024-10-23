package baekjun;

public class Pre1_5 {
    public static void main(String[] args) {

        Pre1_5 pre = new Pre1_5();
        int i = pre.solution("1101");
        System.out.println(i);
    }

    public int solution(String s){
        int answer = 0;
        //이진수를 십진수로 변환
        int t = Integer.parseInt(s,2);

        while(t != 0){
            if(t % 2 == 0){
                t /= 2;
                answer++;
            }else{
                t--;
                answer++;
            }
        }
        return answer;
    }
}
