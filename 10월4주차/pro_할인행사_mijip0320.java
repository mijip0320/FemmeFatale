package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/131127
import java.util.*;

public class pro_할인행사_mijip0320 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount ={
                "chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"
        };

        int answer = 0;
        Map<String, Integer> matchMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            matchMap.put(want[i], i);
        }

        int total = 0;
        for(int i = 0; i < number.length; i++) {
            total += number[i];
        }
        int ptr1 = 0;
        int ptr2 = total-1;

        int[] saleNum = new int[number.length];
        for(int i = 0; i < total; i++) {
            if(matchMap.containsKey(discount[i])) {
                saleNum[matchMap.get(discount[i])]++;
            }
        }
        while(true) {
            if(check(number, saleNum))
                answer++;

            if(matchMap.containsKey(discount[ptr1])) {
                saleNum[matchMap.get(discount[ptr1])]--;
            }

            ptr1++;
            ptr2++;

            if(ptr2 == discount.length)
                break;

            if(matchMap.containsKey(discount[ptr2])) {
                saleNum[matchMap.get(discount[ptr2])]++;
            }
        }

        System.out.println(answer);
    }

    public static Boolean check(int[] num, int[] saleNum){
        for(int i=0; i<num.length; i++){
            if(num[i] > saleNum[i]) return false;
        }
        return true;
    }
}
