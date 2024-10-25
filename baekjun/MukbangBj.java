package baekjun;

import java.util.ArrayList;

public class MukbangBj {

    public String solution(String[] bj, String[] one, String[] two) {
        String answer = "";

        ArrayList<String> al = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < one.length; i++) {
            al.add(one[i]);
            cnt++;
        }
        for(int i = 0; i < two.length; i++) {
            al.add(two[i]);
            cnt += 2;
        }
        for(int i = 0; i < bj.length; i++) {
            if(!al.contains(bj[i])) {
                cnt += 3;
                answer = cnt * 150+"만원" + "(" + bj[i] + ")";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] BJ = {"현준","하반","양상","심심이","소스왕"};
        String[] one = {"현준","양상"};
        String[] two = {"심심이","소스왕"};
        MukbangBj mb = new MukbangBj();
        System.out.println(mb.solution(BJ, one, two));

    }
}
