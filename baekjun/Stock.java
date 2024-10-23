package baekjun;

import java.util.ArrayList;
import java.util.Collections;

public class Stock {

    public int solution(int[] a){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] < a[j]){
                    list.add(a[j] - a[i]);
                }
            }
        }
        Collections.sort(list);
        answer = list.size() == 0 ? 0 : list.get(list.size() - 1);
        return answer;
    }


    public static void main(String[] args){

        System.out.println(new Stock().solution(new int[]{10000, 9800, 9500, 9800, 9200}));
        System.out.println(new Stock().solution(new int[]{100000, 99000, 99000, 98000, 97000}));



    }


}
