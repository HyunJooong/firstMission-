package baekjun;

import java.util.ArrayList;
import java.util.List;

public class OrderCancel {
    public static void main(String[] args) {
        OrderCancel obj = new OrderCancel();
        int[] orders = {2,4,5,7};
        int n = 3;
        System.out.println(obj.solution(orders, n));
        List<Integer> or = new ArrayList<Integer>();

       /* for(int i = 0; i < orders[orders.length - 1] ; i++) {
            or.add(i + 1);
        }
        for(int i : or){
            System.out.print(i);
        }*/

    }
    public int solution(int[] orders, int n) {
        int answer = 0;
        List<Integer> or = new ArrayList<Integer>();
        //배열안에 주문 다 넣기
        for(int i = 0; i < orders[orders.length - 1]; i++) {
            or.add(i + 1);
        }

        if(n != 0) {
            for (int i = 0; i < orders.length; i++) {
                if (or.contains(orders[i])) {
                    or.remove(Integer.valueOf(orders[i]));
                }
            }
            answer = or.get(n - 1);
        } else answer = 0;

        return answer;
    }
}
