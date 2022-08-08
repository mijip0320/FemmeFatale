import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
       int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< scoville.length; i++){
            pq.add(scoville[i]);
        }

        while(pq.peek() <= K){
            if(pq.size() == 1){ //힙 사이즈가 1일때(예외처리)
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + (second*2);
            
            pq.add(sum);
            answer++;
        }



        return answer;
    }
}