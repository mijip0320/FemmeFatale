package solve;

import java.util.Stack;

public class pro_올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution(")()()"));
	}

	static boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack();
        if(s.charAt(0)==')') return false;
        for(int i =0; i< s.length(); i++) {
        	char ss = s.charAt(i);
        	
        	if(ss=='(') {
        		stack.push(ss);
        	}else {
        		if(!stack.isEmpty())stack.pop();
        	}
        }

        return stack.isEmpty()? true:false;
    }
}
