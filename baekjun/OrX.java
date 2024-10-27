package baekjun;

public class OrX {
    public static void main(String[] args) {
        String[] arr = {"10110","1010","11110"};
        OrX orX = new OrX();
        System.out.print(orX.solution(arr));
    }

    public int solution(String[] arr) {
        int result = 0;

        for (String binary : arr) {
            result ^= Integer.parseInt(binary, 2);  // 이진수를 정수로 변환하고 XOR 연산
        }
        return result;
    }
}
