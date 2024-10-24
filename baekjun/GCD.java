package baekjun;

public class GCD {
    public static void main(String[] args) {
        int[] numbers = {48, 64, 16, 32}; // 임의의 숫자 배열
        GCD ea = new GCD();
        int gcd = ea.findGCD(numbers);
        System.out.println("최대 공약수: " + gcd);
    }

    // 배열의 모든 원소에 대해 최대 공약수를 구하는 메서드
    public int findGCD(int[] numbers) {
        int result = numbers[0]; // 첫 번째 숫자를 기준으로 설정

        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]); // 두 숫자의 최대 공약수를 구함
            // 최대 공약수가 1이면 더 이상 의미가 없으므로 종료
            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    // 유클리드 호제법으로 두 수의 최대 공약수를 구하는 메서드
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
