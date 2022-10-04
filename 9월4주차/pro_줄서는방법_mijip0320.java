package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12936
import java.util.*;

public class pro_줄서는방법_mijip0320 {
    public static void main(String[] args) {
        int n = 3;
        long k = 5;

        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long f = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            f *= i;
        }

        k--;
        int idx = 0;
        while(idx < n) {
            f /= n - idx; //단위
            answer[idx++] = list.remove((int) (k / f)); //구할 인덱스
            k %= f; //빠진 단위만큼 변경
        }

        for(int a: answer){
            System.out.println(a);
        }

    }
}
