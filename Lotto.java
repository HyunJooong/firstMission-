import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");

        System.out.print("로또 개수를 입력해주세요(숫자 1~10):");
        int lottoCnt = sc.nextInt();

        System.out.println("[로또 결과]");
        int[] rstLotto = newLotto();

        System.out.println(rstLotto);

    }

    //로또 결과
    public static int[] lottoRst(){
        int[] rstLotto = new int[6];
        for(int i = 0; i < rstLotto.length; i++){
            rstLotto[i] = new Random().nextInt(45) + 1;
        }
        Arrays.sort(rstLotto);
        return rstLotto;
    }

    //로또 생성
    public static int[] newLotto() {
        int[] newLotto = new int[6];

        for (int i = 0; i < newLotto.length; i++) {
            newLotto[i] = new Random().nextInt(45) + 1; // 0빼고 45까지 숫자 랜덤 돌리기
            for (int j = 0; j < i; j++) {
                if (newLotto[j] == newLotto[i]) { // 중복제거
                    i--;
                }
            }
        }
        Arrays.sort(newLotto);
        return newLotto;
    }
}
