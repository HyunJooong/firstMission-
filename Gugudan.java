public class Gugudan {
    public static void main(String[] args) {

        System.out.println("[구구단 출력]");

        // 이중 반복문을 이용해 곱셈을 구함
        // format 함수를 사용해 특정 자릿수 채우기
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10 ; j++) {
                // i와 j 형식에 맡게 자리 바꿔주기
                System.out.print(String.format("%02d", j) + " x " + String.format("%02d", i) + " = " + String.format("%02d", i * j) + "\t");
            }
            // 안쪽 반복문 돌면 아래 칸으로
            System.out.println();

        }

    }

}

