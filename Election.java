import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Election {
    public static void main(String[] args) {


        // 필요한 데이터를 입력받는 부분
        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요. : ");
        int voteCounter = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요. : ");
        int personCounter = sc.nextInt();
        sc.nextLine(); //뒤에 입력된 '엔터키' 삭제하는 부분

        ArrayList<String> arr = new ArrayList<String>(); //List 인터페이스 사용하여 후보자 이름 저장

        for (int i = 0; i < personCounter; i++) { //반복문을 이용하여 후보자 이름 삽입
            System.out.printf("%d번째 후보자이름을 입력해 주세요. : ", (i + 1));
            String name = sc.nextLine();
            arr.add(name); //List에 입력된 후보자 이름 저장

        }


        //임의 번호 생성을 위한 Random 객체 생성
        Random random = new Random();
        int num = 0; //임의 번호가 생성된 후 대입될 변수 선언 및 초기화

        int[] sum = new int[personCounter]; //투표결과 저장할 배열 선언
        Arrays.fill(sum, 0); //배열을 모두 0으로 초기화

        //투표진행률을 보여주는 부분 구현
        for (int i = 0; i < voteCounter; i++) {
            double rate = (double) (i + 1) / voteCounter * 100;

            num = random.nextInt(personCounter) + 1; //1부터 후보자 인원까지 범위의 임의번호 생성


            System.out.printf("[투표진행률] : %.2f%%, %d명 투표 ==> %s\n", rate, (i + 1), arr.get(num - 1));
            sum[num - 1]++; //투표받은 수 누적

            for (int j = 0; j < personCounter; j++) {

                double personreate = (double) sum[j] / voteCounter * 100; //개인당 투표율 계산

                System.out.printf("[기호:%d] %s:", (j + 1), arr.get(j)); //기호와 이름 출력

                if (arr.get(j).length() < 2) {  //출력화면에서 간격을 유지하기 위한 조건문
                    System.out.print("\t\t");
                } else if (arr.get(j).length() < 4) {
                    System.out.print("\t");
                }

                System.out.printf("\t%.2f%% \t (투표수: %d)\n", personreate, sum[j]); //개인별 비율과 투표수 출력
            }
            System.out.println();


        }

        int max = 0; //최대로 받은 투표수를 판단하기 위한 변수 선언
        int max_index = 0;
        for (int i = 0; i < sum.length ; i++) {

            if (max < sum[i]) { //최대 투표를 받은 사람을 찾는 조건
                max = sum[i];
                max_index = i;
            }

        }

        System.out.println("[투표결과] 당선인 : " + arr.get(max_index) );

    }

}
