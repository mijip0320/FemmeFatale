import java.util.*;
import java.math.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue(); //최대공약수
        answer = ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
        
        return answer;
    }
}