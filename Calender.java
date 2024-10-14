import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");

        // 해당 년도 및 월 입력 받기
        System.out.print("달력의 년도를 입력해 주세요(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        // 이전 달, 현재 달, 다음 달 계산
        int previousMonth = month == 1 ? 12 : month - 1;
        int previousYear = month == 1 ? year - 1 : year;
        int nextMonth = month == 12 ? 1 : month + 1;
        int nextYear = month == 12 ? year + 1 : year;

        // 각 달력을 저장할 리스트
        List<String[]> previousCalendar = generateCalendar(previousYear, previousMonth);
        List<String[]> currentCalendar = generateCalendar(year, month);
        List<String[]> nextCalendar = generateCalendar(nextYear, nextMonth);

        // 가로로 달력 출력
        printHorizontalCalendars(previousCalendar, currentCalendar, nextCalendar);
    }

    // 달력을 생성하여 문자열 배열로 반환
    private static List<String[]> generateCalendar(int year, int month) {
        List<String[]> calendar = new ArrayList<>();
        LocalDate date = LocalDate.of(year, month, 1);
        int firstDayOfWeek = date.getDayOfWeek().getValue();
        int lastDayOfMonth = date.lengthOfMonth();

        // 달력 제목
        calendar.add(new String[]{"[" + year + "년 " + month + "월]"});
        calendar.add(new String[]{"일", "월", "화", "수", "목", "금", "토"});

        // 첫 주 빈칸 채우기
        String[] week = new String[7];
        int dayIndex = firstDayOfWeek % 7;
        for (int i = 0; i < dayIndex; i++) {
            week[i] = "  ";
        }

        // 날짜 채우기
        for (int day = 1; day <= lastDayOfMonth; day++) {
            week[dayIndex++] = String.format("%02d", day);
            if (dayIndex == 7) { // 한 주가 끝나면 새 주를 추가
                calendar.add(week);
                week = new String[7];
                dayIndex = 0;
            }
        }
        // 마지막 주 남은 공간 빈칸으로 채우기
        if (dayIndex > 0) {
            for (int i = dayIndex; i < 7; i++) {
                week[i] = "  ";
            }
            calendar.add(week);
        }
        return calendar;
    }

    // 가로로 달력을 출력
    private static void printHorizontalCalendars(List<String[]> cal1, List<String[]> cal2, List<String[]> cal3) {
        // 각 달의 제목을 먼저 출력
        System.out.print(cal1.get(0)[0] + "\t\t\t");
        System.out.print(cal2.get(0)[0] + "\t\t\t");
        System.out.print(cal3.get(0)[0] + "\n");

        // 요일 헤더를 한 줄씩 출력
        printCalendarRow(cal1, 1);
        System.out.print("\t");
        printCalendarRow(cal2, 1);
        System.out.print("\t");
        printCalendarRow(cal3, 1);
        System.out.println();

        // 각 달의 날짜를 출력
        int maxRows = Math.max(cal1.size(), Math.max(cal2.size(), cal3.size()));
        for (int i = 2; i < maxRows; i++) { // 제목과 요일 헤더를 제외하고 출력
            printCalendarRow(cal1, i);
            System.out.print("\t");
            printCalendarRow(cal2, i);
            System.out.print("\t");
            printCalendarRow(cal3, i);
            System.out.println();
        }
    }

    // 특정 달력의 한 행을 출력
    private static void printCalendarRow(List<String[]> calendar, int row) {
        if (row < calendar.size()) {
            for (String day : calendar.get(row)) {
                System.out.print((day == null ? "  " : day) + "\t");
            }
        } else {
            // 비어 있는 줄은 빈칸을 출력하여 다른 달력과 높이 맞추기
            System.out.print(" \t \t \t \t \t \t \t");
        }
    }
}

