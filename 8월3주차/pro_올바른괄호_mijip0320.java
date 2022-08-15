package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
import java.util.*;

public class pro_올바른괄호_mijip0320 {
    public static void main(String[] args) {
        String s = "(())()";
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else{
                if(stack.isEmpty())
                    answer = false;
                else
                    stack.pop();   
            }
        }



        // 스택이 비어있으면 모든 괄호가 짝지어 졌으므로 true, 아닐경우 false
        answer = (stack.isEmpty()) ? true : false;
        System.out.println(answer);
    }
}
