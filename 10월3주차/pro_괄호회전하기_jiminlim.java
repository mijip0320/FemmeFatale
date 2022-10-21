import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        int len = s.length();
        Stack<Character> stack = new Stack<>(); 
        
        while(cnt < len){
            for(int i =0; i<len; i++){
                
                char now = s.charAt(i); 
                if( i == 0 &&(now == ')' || now == '}' || now == ']')){
                    
                    stack.push('s');//조건 용 임의값 넣어줌.
                    break;
                }else if(now == '(' || now == '{' || now == '['){
                    
                    stack.push(now);
                }else{
                    if(stack.size() > 0){
                        
                        char compare = stack.peek(); 
                        if(compare  == '(' && now == ')'){
                            stack.pop();
                        }else if(compare == '{' && now == '}'){
                            stack.pop();
                        }else if(compare == '[' && now == ']'){
                            stack.pop();
                        }
                    }else{
                        stack.push(now);
                    }
                    
                }
            }
           
            if(stack.size() == 0){
                answer++;
            }
            cnt++;
            stack.clear();
            s = s.substring(1)+ s.charAt(0);
        }
        return answer;
    }
}
