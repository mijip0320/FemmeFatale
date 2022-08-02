package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12899
import java.util.*;

public class pro_124나라의숫자_mijip0320 {
    public static void main(String[] args) {
        int n = 4;
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        //나머지 : 0 -> 4
        //1 -> 1
        //2 -> 2
        while(n > 0){
            int remainder = n % 3;
            n /= 3;

            if(remainder == 0) n--;

            answer = numbers[remainder] + answer;
        }


        System.out.println(answer);
    }
}
