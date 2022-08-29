package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12973
import java.util.*;

public class pro_짝지어제거하기_mijip0320 {
    public static void main(String[] args) {
        String s = "cdcd";
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()) stack.add(s.charAt(i));
            else {
                if(s.charAt(i) == stack.peek()){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            }
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;

      

        System.out.println(answer);
    }
}
