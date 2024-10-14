import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("[로또 당첨 프로그램]");


        ArrayList<ArrayList<Integer>> lottoNumbers = new ArrayList();

        //넘버 만들기
        char alphaNum = 'A';
        System.out.print("로또 개수를 입력해 주세요(숫자 1~10):");
        int lottoCount = sc.nextInt();

        //첫번째 반복문에서 각 로또 순서 출력 후 알파벳 하나씩 더하기
        for (int i = 0; i < lottoCount; i++) {
            ArrayList<Integer> lottoNumber = new ArrayList<>();
            System.out.print(alphaNum + "\t");
            alphaNum++;
            //두번째 반복문에서 로또 번호 랜덤 출력
            for (int j = 0; j < 5; j++) {
                int backNumber = rand.nextInt(45) + 1;
                while (lottoNumber.contains(backNumber)) {
                    backNumber = rand.nextInt(45) + 1;
                }
                lottoNumber.add(backNumber);
                System.out.print(backNumber + "\t");
            }
            lottoNumbers.add(lottoNumber);  // 그룹을 전체 리스트에 추가
            //두번째 반복문 끝나면 줄 바꿈
            System.out.println();
        }

        System.out.println("[로또 발표]");
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int resultNum = rand.nextInt(45) + 1;
            while (winningNumbers.contains(resultNum)) {
                resultNum = rand.nextInt(45) + 1;
            }
            winningNumbers.add(resultNum);
            System.out.print(resultNum + "\t");
        }
        System.out.println();

        char alphaSecondNum = 'A';
        System.out.println("[내 로또 결과]");
        for (ArrayList<Integer> lotto : lottoNumbers) {
            System.out.print(alphaSecondNum + "\t");
            alphaSecondNum++;
            int matchCount = 0;
            for (int number : lotto) {
                System.out.print(number + "\t");
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }
            System.out.println("=> 일치 개수: " + matchCount);
        }
    }
}
