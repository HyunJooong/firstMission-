import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("[로또 당첨 프로그램]");

        int[] lottoNumber = new int[50];

        //아스키 코드로 넘버 만들기
        char alphaNum = 'A';
        System.out.print("로또 개수를 입력해 주세요(숫자 1~10):");
        int lottoCount = sc.nextInt();

        //첫번째 반복문에서 각 로또 순서 출력 후 아스키 코드 하나씩 더하기 
        for (int i = 0; i < lottoCount; i++) {
            System.out.print(alphaNum + "\t");
            alphaNum++;
            //두번째 반복문에서 로또 번호 랜덤 출력
            for (int j = 0; j < 5; j++) {
                int backNumber = rand.nextInt(45) + 1;
                lottoNumber[i] = backNumber;
                System.out.print(lottoNumber[i] + "\t");
            }
            //두번째 반복문 끝나면 줄 바꿈
            System.out.println();
        }

        System.out.println("[로또 발표]");
        for (int i = 0; i < 5; i++) {
            int resultNum = rand.nextInt(45) + 1;
            System.out.print(resultNum + "\t");
        }
        System.out.println();
        char alphaSecondNum = 'A';
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < lottoCount; i++) {
            System.out.print(alphaSecondNum + "\t");
            alphaSecondNum++;
            for (int j = 0; j < lottoNumber.length; j++) {
                System.out.print(lottoNumber[j] + "\t");
            }
            System.out.println();
        }


    }
}
