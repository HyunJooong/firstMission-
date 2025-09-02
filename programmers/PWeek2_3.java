package programmers;

import java.util.HashSet;

public class PWeek2_3 {
    public static void main(String[] args) {

    }
    public boolean solution(String p, String s) {
        boolean answer = true;

        HashSet<Character> hashSet1 = new HashSet();
        HashSet<String> hashSet2 = new HashSet();

        for(int i = 0; i < p.length(); i++) {
            hashSet1.add(p.charAt(i));
        }
        //상현 답안은 공백으로 구분됨
        String[] arr = s.split(" ");
        for(String sang : arr){
            hashSet2.add(sang);
        }

        // hash는 중복을 허용하지 않고 만약 패턴이 같으면 같은 사이즈 패턴이 다를 경우 두 사이즈가 다를 것이다.
        if(hashSet1.size() != hashSet2.size()) {
            answer = false;
        }
        return answer;
    }


}
