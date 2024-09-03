import java.util.Random;
import java.util.Scanner;

public class IdNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int sex = 4;
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        int month = sc.nextInt();
        System.out.print("출생일을 입력해 주세요.(dd):");
        int day= sc.nextInt();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String mf = sc.next();
        if(mf.equals("m")){
            sex = 3;
        }else if(mf.equals("f")){
            sex = 4;
        }
        int backNumber = rand.nextInt(1000000);

        System.out.println(year - 2000 + String.format("%02d", month) + String.format("%02d", day) + "-" + sex + backNumber );


    }
}
