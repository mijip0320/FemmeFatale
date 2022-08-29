import java.util.Stack;

public class pro_짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
    public static int solution(String s)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(s);



        Stack<Character> stack = new Stack<Character>();
        stack.push(sb.charAt(0));

        for(int i=1 ;i< sb.length();i++ ){
            char a = sb.charAt(i);
            if(!stack.isEmpty()){
                char b = stack.peek();
                if(a==b){
                    stack.pop();
                }else{
                    stack.push(a);
                }
            }else{
                stack.push(a);
            }
        }

        return stack.isEmpty()? 1: 0;
//        while(sb.length()>0){
//            if(sb.length()<2) break;
//            if(i >= sb.length()-1) break;
//            if(i < 0) i= 0;
//            char a = sb.charAt(i);
//            char b = sb.charAt(i+1);
//            if(a==b){//똑같은 소문자 두개
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i);
//                i = i-1;
//
//            }else{
//                i++;
//            }
//        }

//        return sb.length() == 0 ? 1: 0;
    }
}
