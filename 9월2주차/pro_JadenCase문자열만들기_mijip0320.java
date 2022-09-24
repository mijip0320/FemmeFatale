package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12951
import java.util.*;

public class pro_JadenCase문자열만들기_mijip0320 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String answer = "";

        for(int i=0; i<s.length(); i++){
            if(i==0 && s.charAt(i) >= 65 && s.charAt(i) <= 122){
                answer += Character.toString(s.charAt(i)).toUpperCase();
            }else{
                if(s.charAt(i) >= 65 && s.charAt(i) <= 122){
                    if(s.charAt(i-1) == ' '){
                        answer += Character.toString(s.charAt(i)).toUpperCase();
                    }else{
                        answer += Character.toString(s.charAt(i)).toLowerCase();
                    }
                }else{
                    answer += Character.toString(s.charAt(i));
                }
            }
        }


        System.out.println(answer);
    }
}
