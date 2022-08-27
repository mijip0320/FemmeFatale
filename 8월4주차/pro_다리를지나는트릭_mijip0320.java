package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/42583
import java.util.*;

public class pro_다리를지나는트릭_mijip0320 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;

        int[] truck_weights = {7,4,5,6};

        int answer = 0;
        Queue<Integer> q = new LinkedList<>(); //다리를 건너는 트럭
        int sum = 0;

        for(int a : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(a);
                    sum += a;
                    answer++;
                    break;
                }else if(q.size() == bridge_length){
                   sum -= q.poll();

                }else{
                   if(sum + a > weight){
                       q.add(0);
                       answer++;
                   }else{
                       q.add(a);
                       sum += a;
                       answer++;
                       break;
                   }

                }
            }
        }
        

        System.out.println(answer+bridge_length);
    }
}
