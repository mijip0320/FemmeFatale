import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String,Integer> map  = new HashMap<>();
        for(int i = 0;i< want.length; i++){
            {
                map.put(want[i], i);
            }
        }
        int answer = 0;
        int len = discount.length;
        for(int i =0 ;i< len; i++){
            if(map.containsKey(discount[i])){
               // System.out.println("discount[i]    "+discount[i]);
                int[] newnumber = number.clone();
                int cnt = 0;
                for(int j =0 ;j<10; j++){       
                    int find = i+j;
                    if(find >= len){
                        break;
                    }
                    if(map.containsKey(discount[find])){
                        int val = map.get(discount[find]);
                        
                        if(newnumber[val] >0) {
                            newnumber[val]--;
                            cnt++;
                        }else{
                           // System.out.println("breka;");
                            break; // 10연속 깨짐
                        }                        
                    }else{
                       // System.out.println("breka;");
                        break; // 10연속 깨짐
                    }
                }
                if(cnt == 10){
                    answer++;
                  //  System.out.println("count"+i);
                }
            }
            
        }
        
        // for(String key : map.keySet()){
        //     System.out.println(key);
        // }
        
      
        return answer;
    }
}
