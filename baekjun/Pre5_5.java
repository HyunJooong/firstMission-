package baekjun;

public class Pre5_5 {
    public static void main(String[] args) {
        Pre5_5 p = new Pre5_5();
        System.out.println(p.solution("Naver"));

    }

    public String solution(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 대문자인 경우 소문자로, 소문자인 경우 대문자로 변환
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c); // 알파벳이 아닌 경우 그대로 추가
            }
        }

        return result.toString();
    }
}
