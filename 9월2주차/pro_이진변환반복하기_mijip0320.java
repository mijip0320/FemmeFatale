package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/70129
import java.util.*;

public class pro_이진변환반복하기_mijip0320 {
    public static void main(String[] args) {
        int[] answer = new int[2];

        String s = "110010101001";

        int count = 0;
        int count_zero = 0;

        while(!s.equals("1")){
            int count_one = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    count_one++;
                }else{
                    count_zero++;
                }
            }
            s = Integer.toBinaryString(count_one);
            count++;
        }

        answer[0] = count;
        answer[1] = count_zero;

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
