import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        //int[] answer = {};
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=1; i<arr.length; i++){
            if(i-1 == 0) answer.add(arr[0]);
            if(arr[i-1] != arr[i]){
                answer.add(arr[i]);
            }else if(arr[i-1] == arr[i]){
                continue;
            }
        }

        return answer;
    }
}