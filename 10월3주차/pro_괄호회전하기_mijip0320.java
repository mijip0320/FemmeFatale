package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/76502
import java.util.*;

public class pro_괄호회전하기_mijip0320 {
    public static void main(String[] args) {
        String s = "}}}";
        int answer = 0;
        //테케는 다 돌아가지만 모두 통과 X 코드
        /*s = s+s;

        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            char cn = s.charAt(i+1);
            if(c == '[' && cn == ']' ){
                answer++;
            }else if(c == '{' && cn == '}' ){
                answer++;
            }else if(c == '(' && cn == ')' ){
                answer++;
            }

            if(i == s.length()/2-1) break;
        }

        System.out.println(answer);
*/

        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder(s);
            String subString = sb.substring(0, i);
            sb.delete(0,i);
            sb.append(subString);
            if(isString(sb)){
                answer += 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean isString(StringBuilder sb){

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < sb.length(); i++){
            if(stack.isEmpty()){
                stack.push(sb.charAt(i));
            }else{
                if(sb.charAt(i) == ']'){
                    if(stack.peek() == '['){
                        stack.pop();
                    }else{
                        stack.push(sb.charAt(i));
                    }
                }else if(sb.charAt(i) == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(sb.charAt(i));
                    }
                }else if(sb.charAt(i) == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else{
                        stack.push(sb.charAt(i));
                    }
                }else{
                    stack.push(sb.charAt(i));
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;

    }
}
