import java.util.*;
class Solution {
    public static int answer;
    public int solution(int n, int k) {
        answer = 0;
        
        String numstr = "";
        while(n >= k){
            int num = n % k;
            n = n/k;
            numstr = num + numstr;   
            
        }
        numstr = n + numstr;
       // System.out.println(numstr);
        String[] num_array = numstr.split("0");

        for(String s:num_array){
           
            if(s.equals("")) continue;
            long number = Long.parseLong(s);
            if(isPrime(number)){
                answer++;
            }
        }

        return answer;
    }
    public static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        
        if(num == 2) return true;
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
