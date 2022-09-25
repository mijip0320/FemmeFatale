package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/42885
import java.util.*;

public class pro_구명보트_mijip0320 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;


        int answer = 0;

        int min = 0;
        Arrays.sort(people);

        for(int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) {
                min++;
            }
            //if문에서 걸리지 않으면 현재 최댓값 혼자 구명보트를 탄 걸로 처리
            answer++;
        }



        System.out.println(answer);

    }
}
