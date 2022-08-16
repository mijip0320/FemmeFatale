import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
       if(check(p)){ //올바른 괄호 문자열이라면 바로 리턴
            answer = p;
        }else{ //균형잡힌 괄호 문자열이라면
            answer = split(p);
        }
        return answer;
    }
    
      public static boolean check(String p){
        //(의 개수
        int open = 0;

        //첫 문자가 ) 이면 false
        if(p.charAt(0) == ')') return false;

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') open++; //( 개수 증가
            else{
                open--; //)일 때 ( 개수 감소
                if(open < 0) return false; // ) 개수가 (의 개수보다 많아지면 올바른 괄호 X

            }
        }

        return true;

    }
    // 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열 변환 메소드.
    public static String split(String p){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(p == "") return "";

        int open = 0;
        for(int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') open++;
            else open--;
            //균형잡힌 괄호일때
            if (open == 0) {
                // 해당 인덱스를 기점으로 u와 v로 분리.
                u.append(p.substring(0, i + 1));
                v.append(p.substring(i + 1, p.length()));

                //u가 올바른 괄호 문자열이라면 v에 대한 재귀 호출 후 u에 이어붙임임
                if (check(u.toString())) {
                    u.append((split(v.toString())));
                } else {
                    StringBuilder newS = new StringBuilder();

                    newS.append("(");
                    newS.append(split(v.toString()));
                    newS.append(")");
                    newS.append(reverse(u.toString()));
                    return newS.toString();
                }
                break;
            }
        }
    return u.toString();
    }
    
     public static String reverse(String str){
        StringBuilder s = new StringBuilder();

        // 첫 번째, 마지막 문자를 제외하고 반복.
        for(int i = 1; i<str.length()-1;i++){
            // ( -> )
            if(str.charAt(i) == '(') s.append(")");
            //  ) -> (
            else s.append("(");
        }

        return s.toString();
    }
}