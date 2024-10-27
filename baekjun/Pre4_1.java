package baekjun;

public class Pre4_1 {
    public static void main(String[] args) {
        int[] arr = {71,111,111,103,108,101};
        Pre4_1 obj = new Pre4_1();

        //System.out.println(result.toString());
        System.out.println(obj.solution(arr));

    }
    public String solution(int[] arr) {
        StringBuilder result = new StringBuilder();

        for (int ascii : arr) {
            result.append((char) ascii);  // 아스키 코드를 문자형으로 변환
        }

        return result.toString();
    }
}
