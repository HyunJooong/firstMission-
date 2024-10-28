package baekjun.programmers;

public class StringInString {
    public static void main(String[] args) {

        StringInString st = new StringInString();
        System.out.println(st.solution("ab6CDE443fgh22iJKlmn1o","6CD"));
        System.out.println(st.solution("ppprrrogrammers","pppp"));
        System.out.println(st.solution("AbcAbcA","AAA"));

    }
    public int solution(String str1, String str2) {
        int answer = 0;

        answer = str1.contains(str2) ? 1 : 2;

        return answer;
    }
}
