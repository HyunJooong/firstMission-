package baekjun.programmers.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week2_2 {
    //chatGpt 코드
    public int[] solution2(int[] a, int[] b){
        List<Integer> resultList = new ArrayList<>();
        int carry = 0; // 자리 올림수

        int i = a.length - 1;
        int j = b.length - 1;

        // 두 배열의 끝에서부터 더하기
        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = (i >= 0) ? a[i] : 0;
            int digitB = (j >= 0) ? b[j] : 0;
            int sum = digitA + digitB + carry;

            resultList.add(sum % 10); // 현재 자릿수 추가
            carry = sum / 10; // 올림수 계산

            i--;
            j--;
        }

        // 결과 배열 뒤집기 (현재는 역순으로 되어 있음)
        Collections.reverse(resultList);

        // 결과가 0이면 빈 배열 반환
        if (resultList.size() == 1 && resultList.get(0) == 0) {
            return new int[] {};
        }

        // 리스트를 배열로 변환하여 반환
        int[] answer = resultList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    //내가 작성한 코드
    public int[] solution(int[] a, int[] b) {

        StringBuilder sb = new StringBuilder();
        // 첫 번째 배열의 숫자 이어 붙이기
        for (int num : a) {
            sb.append(num);
        }
        long numA = Long.parseLong(sb.toString());
        sb.setLength(0); // StringBuilder 초기화

        // 두 번째 배열의 숫자 이어 붙이기
        for (int num : b) {
            sb.append(num);
        }
        long numB = Long.parseLong(sb.toString());
        sb.setLength(0);

        // 두 값을 더한 결과
        long sum = numA + numB;

        // 값이 0이면 빈 배열 반환
        if (sum == 0) {
            return new int[] {};
        }

        sb.append(sum);
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Character.getNumericValue(sb.charAt(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5,2,1,4,6};
        int[] b = {6,1,0,4,4};
        Week2_2 w = new Week2_2();
      //  System.out.println(w.solution(a, b));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }

        // 파라미터로 받은 두 배열 값 int로 바꾸고 StringBuilder 비우기
        int inSb = Integer.parseInt(sb.toString());
        sb.setLength(0);

        for(int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        int inSbb = Integer.parseInt(sb.toString());
        sb.setLength(0);

        // 두 값 더하기
        int sum = inSb + inSbb;

    }
}
