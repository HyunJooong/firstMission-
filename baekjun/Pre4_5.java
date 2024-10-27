package baekjun;

public class Pre4_5 {
    public static void main(String[] args) {
        Pre4_5 p = new Pre4_5();
        String[] arr = {"naver", "Kakao"};
        System.out.println(p.solution(arr));

    }
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
