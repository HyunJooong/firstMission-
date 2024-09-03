import java.util.Scanner; //Scanner 클래스 호출
public class CashBack {

    public static void main(String[] args) {

        //스캐너 함수 사용
        Scanner sc = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");

        int money = sc.nextInt(); // 받을 금액

        // 지불 금액에서 10% 가격에서 십의자리 버리기 위한 로직
        int cashBack = ((money / 10) /100) * 100;

        // 캐시백이 300 보다 클 수 없음
        if(cashBack > 300) {
            cashBack = 300;
        }

        System.out.println("결제 금액은 " + money + "원이고, " + "캐시백은 " + cashBack + "원 입니다.");


    }
}
