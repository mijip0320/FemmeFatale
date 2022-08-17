import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = {1,2,3,4,5}; int countA = 0;
        int[] b = {2,1,2,3,2,4,2,5}; int countB = 0;
        int[] c = {3,3,1,1,2,2,4,4,5,5}; int countC = 0;
        
       for(int i =0; i<answers.length; i++){
            if(a[i%a.length] == answers[i]) countA++;
            if(b[i%b.length] == answers[i]) countB++;
            if(c[i%c.length] == answers[i]) countC++;
        }
       int max = Math.max(Math.max(countA, countB),countC); // max값 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(max==countA) list.add(1); 
        if(max==countB) list.add(2);
        if(max==countC) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}