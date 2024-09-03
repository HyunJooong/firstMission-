import java.util.Scanner;

public class Amusement {
    public static void main(String[] args) {

        /*- 3세미만이면 무료 입장
         - 복지카드와 국가유공자의 경우 일반 할인 적용
         - 13세미만이면 특별 할인 적용
         - 17시이후에 입장하면 특별 할인 적용
         기본 입장료 : 10,000원
         특별 할인의 경우 : 4,000원
         일반 할인의 경우 : 8,000원
        */
        //스캐너 클래스 선언
        Scanner sc = new Scanner(System.in);
        int money = 0; //
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();// 나이
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가 유공자 여부를 입력해주세요.(y/n):");
        String veteran = sc.next();
        System.out.print("복지카드 여부를 입력해주세요.(y/n):");
        String welfare = sc.next();

        if(veteran.equals("y") || welfare.equals("y")) {
            money = 8000;

            if (time >= 17 || age < 13) {
                money = 4000;
            }
           if(age < 3 ) money = 0; // 3세 미만 0원
        }


        System.out.println("입장료: " + money);






    }
}
