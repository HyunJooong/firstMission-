package baekjun;

public class Pre4_4 {
    public static void main(String[] args) {
        Pre4_4 p = new Pre4_4();
        String s = "f4";
        System.out.println(p.solution(s));
    }
    public String solution(String s) {
        String answer = "";
        int decimal = Integer.parseInt(s, 16);
        answer = Integer.toBinaryString(decimal);
        return answer;
    }
}
