package baekjun;

public class EnglishWord {
    public static void main(String[] args) {

        String ab = "one4seveneight";

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //배열 안에 문자열이 있으면 숫자로 바꿔주기
        for (int i = 0; i < arr.length; i++) {
            if (ab.contains(arr[i])) {
                ab = ab.replace(arr[i], Integer.toString(i));
            }
        }

        System.out.println(ab);
    }

}
