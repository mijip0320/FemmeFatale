import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {};
        int[] work = new int[100];
        int day = 0;
        
        for(int i=0; i<progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            
            work[day]++;
        }
        
        int count = 0;
        
        //temp에 들어간 배열의 길이를 알기위한 코드임.
     
        for(int n : work){
            if(n != 0){ 
                count ++; 
            }
        }
        //count만큼 answer 정답 개수 선언 
         int[] answer = new int[count];
       
        count = 0; 
        for(int n : work){
            if(n != 0){
                answer[count++] = n;
            }
        }
        
        return answer;
    }
}
