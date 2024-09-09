import java.time.LocalDate;
import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");
        //해당 년도 입력 받기
        System.out.print("달력의 년도를 입력해 주세요(yyyy):");
        //해당 월 입력 받기
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        getThisYear(year, month);
        //요일 출력
        System.out.print("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토" + "\t");
        System.out.print("\t" + "일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토" + "\t");
        System.out.print("\t" + "일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");



    }

    public static void getThisYear(int y, int m) {

        //해당 월 달력 만들기
        LocalDate thisCalender = LocalDate.of(y, m, 1);

        //3개의 달 기준
        int previousMonth = m == 1 ? 12 : m - 1;
        int nextMonth = m == 12 ? 1 : m + 1;
        int previousYear = m == 1 ? y - 1: y;
        int nextYear = m == 12 ? y + 1 : y;

        System.out.println(thisCalender);
    }
}

