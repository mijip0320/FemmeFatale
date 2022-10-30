package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/92335
import java.util.*;

public class pro_k진수에서소수개수구하기_mijip0320 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        int answer = 0;

        int i, j=0;
        String s = Integer.toString(n,k);
        for(i = 0; i < s.length(); i = j) {
            for(j = i + 1; j < s.length() && s.charAt(j) != '0'; j++);
            if(isPrime(Long.parseLong(s.substring(i,j))))
                answer++;
        }

        System.out.println(answer);

    }

    // 소수 판별 메소드
    public static Boolean isPrime(long number) {

        // 0 과 1 은 소수가 아니다
        if(number < 2) {

            return false;
        }

        // 2 는 소수다
        if(number == 2) {
            return true;
        }

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {

            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }
}
