package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/42578
import java.util.*;

public class pro_위장_mijip0320 {
    public static void main(String[] args) {
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
//{옷 종류}:{총 개수} 와 같은 형태로 매칭 (key : value)
        for(int i=0; i<clothes.length; i++){
            if(map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);

            }else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);

            }
        }

        //(하나를 입거나 + 안입거나) * (하나를 입거나 + 안입거나)...
        for(String keys: map.keySet()) {
            //(a+1) * (b+1) *...
            answer *= (map.get(keys) + 1);

        }

        answer -= 1; //아무것도 안입었을 때 경우의 수 빼기
        System.out.println(answer);
    }
}
