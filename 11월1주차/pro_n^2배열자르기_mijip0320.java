package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/87390
import java.util.*;

public class pro_n2배열자르기_mijip0320 {
    public static void main(String[] args) {
    int n = 3;
    long left = 2;
    long right = 5;

    long temp = right - left + 1;
    int[] answer = new int[Long.valueOf(temp).intValue()];
    //arr[row][col]는 row와 col 중 큰 값 + 1
    int c = 0;

    for(long i = left; i<right + 1; i++){
        long row = i / n;
        long col = i % n;
        answer[c++] = Math.max((int)row, (int)col) + 1;
    }



    for(int i : answer){
        System.out.println(i);
    }
    }
}
