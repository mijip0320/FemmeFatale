import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans =0;
        while(n>0){
            if(n % 2 == 1){
                n = (n-1)/2;
                ans ++;
            }else{
                n /= 2;
            }
        }
        
        return ans;
    }
//     static int now,min ;
//     static int[] save;
//     public int solution(int n) {
//         now = 1;
//         min = Integer.MAX_VALUE;
//         int energy = 1;
//         save = new int[n+1];
//         Arrays.fill(save, Integer.MAX_VALUE);
//         save[1] = 1;
        
//         step(now,energy, n);

//         return save[n];
//     }
    
//     public static void step(int now ,int energy, int stop){      
//         if(now == stop){
//             return;
//         }    
//         if(now * 2 <= stop){
//             if(save[now*2] > energy){
//                 save[now*2] = energy;
//                 step(now*2, energy, stop);                       
//             }
//         }
//        if(save[now+1]> energy+1){
//             save[now+1] = energy+1;
//             step(now+1,energy+1, stop);    
//         }        
//     }
}
