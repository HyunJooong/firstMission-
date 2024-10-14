import java.util.ArrayList;
import java.util.Scanner;

public class Tax {
    public static int[] standard = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000, 0};  //과세표준
    public static int[] rate = {6, 15, 24, 35, 38, 40, 42, 45}; //세율
    public static int[] deductionMoney = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000}; //누진공제
    public static int[] standardForCalc = {12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000, 0}; //세율을 계산하기 위한 배열

    public static void calculateTaxOfRate(int inputMoney) { //세율에 의한 세금 계산하는 메소드

        int tmp = inputMoney;
        ArrayList<Integer> list = new ArrayList<Integer>();


        for (int i = 0; tmp >0; i++) { //세율에 의한 세금 계산하는 반복문

            if (tmp > standardForCalc[i]) {
                list.add(standardForCalc[i]);
                tmp -= standardForCalc[i];
            }
            if (tmp <= standard[0]) {
                list.add(tmp);
                break;
            }
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {

            int answer = list.get(i) / 100 * rate[i];
            sum += answer;
            System.out.printf("%10d * %3d%% = % 10d\n",list.get(i),rate[i],answer);

        }

        System.out.printf("\n[세율에 의한 세금]: \t\t\t%10d\n",sum);
    }

    public static void calculateTaxOfDeduction(int inputMoney) { //누진공제 계산에 의한 세금 계산하는 메소드
        int result = 0;

        for (int i = 0; i < standard.length; i++) {

            if (inputMoney <= standard[i]) {
                result = inputMoney / 100 * rate[i] - deductionMoney[i];
                break;
            } else if (inputMoney > 1000000000) {
                i = 7;
                result = inputMoney / 100 * rate[i] - deductionMoney[i];
                break;
            }

        }
        System.out.printf("[누진공제 계산에 의한 세금]:\t%10d\n", result);

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[과제금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.: ");

        int inputMoney = sc.nextInt();


        calculateTaxOfRate(inputMoney);
        calculateTaxOfDeduction(inputMoney);

    }
}