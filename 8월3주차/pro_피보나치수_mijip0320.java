import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] calc = new int[n+1];
        calc[0] = 0;
        calc[1] = 1;
      for(int i=2; i<=n; i++){
        
              int sum = calc[i-2] + calc[i-1];
              calc[i] = sum % 1234567; //int 범위 안에서 구하기 위해 1234567으로 나눈 값의 나머지를 저장
          
      }
      answer = calc[n];
        return answer;
    }
}