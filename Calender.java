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

        //3개의 달 기준
        int previousMonth = month == 1 ? 12 : month - 1;
        int previousYear = month == 1 ? year - 1 : year;
        int nextMonth = month == 12 ? 1 : month + 1;
        int nextYear = month == 12 ? year + 1 : year;

        getPreviousMonth(previousYear,previousMonth);
        System.out.println();
        getThisYear(year, month);
        System.out.println();
        getNextYear(nextYear,nextMonth);
    }

    private static void getNextYear(int year, int month) {

        //해당 월 달력 만들기
        LocalDate thisCalender = LocalDate.of(year, month, 1);

        //해당 달 시작 요일 변수
        int firstDay = thisCalender.getDayOfWeek().getValue();

        System.out.println("[" + year + "년 " + month + "월" + "]");
        System.out.print("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
        System.out.println();

        //해당 달의 시작 요일이 될 때까지 반복문
        if (firstDay != 7) {
            for (int i = 0; i < firstDay; i++) {
                System.out.print("\t");
            }
        }

        //모든 일 출력
        int lastDay = thisCalender.lengthOfMonth();
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%02d\t", i);
            firstDay++;
            if (firstDay % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void getThisYear(int thisYear, int thisMonth) {

        //해당 월 달력 만들기
        LocalDate thisCalender = LocalDate.of(thisYear, thisMonth, 1);

        //해당 달 시작 요일 변수
        int firstDay = thisCalender.getDayOfWeek().getValue();

        System.out.println("[" + thisYear + "년 " + thisMonth + "월" + "]");
        System.out.print("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
        System.out.println();

        //해당 달의 시작 요일이 될 때까지 반복문
        if (firstDay != 7) {
            for (int i = 0; i < firstDay; i++) {
                System.out.print("\t");
            }
        }

        //모든 일 출력
        int lastDay = thisCalender.lengthOfMonth();
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%02d\t", i);
            firstDay++;
            if (firstDay % 7 == 0) {
                System.out.println();
            }
        }
    }

    private static void getPreviousMonth(int previousYear, int previousMonth) {

        //해당 월 달력 만들기
        LocalDate thisCalender = LocalDate.of(previousYear, previousMonth, 1);

        //해당 달 시작 요일 변수
        int firstDay = thisCalender.getDayOfWeek().getValue();

        System.out.println("[" + previousYear + "년 " + previousMonth + "월" + "]");
        System.out.print("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
        System.out.println();

        //해당 달의 시작 요일이 될 때까지 반복문
        if (firstDay != 7) {
            for (int i = 0; i < firstDay; i++) {
                System.out.print("\t");
            }
        }

        //모든 일 출력
        int lastDay = thisCalender.lengthOfMonth();
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%02d\t", i);
            firstDay++;
            if (firstDay % 7 == 0) {
                System.out.println();
            }
        }


    }
}

