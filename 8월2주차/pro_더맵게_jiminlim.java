import java.util.*;
class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int answer =0;
        for(int a : scoville){
            pq.add(a);
        }
        while(true){

             int first_num = pq.peek();
            if(first_num < K && pq.size() > 1){
                pq.poll();
                answer++;
                int second_num = pq.poll();
                int shake_num = first_num + (second_num * 2) ;

                pq.add(shake_num);
            }else if(first_num < K && pq.size() == 1){
                answer = -1;
                break;
            }else {
                break;
            }
        }

        return answer;
    }
}
