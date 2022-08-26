class Solution {
    
    // 변환 과정에 맞게 u를 변환하는 메소드.
    public static String reverse(String str){
        // 1. 변환한 문자열을 저장 할 StringBuilder 객체.
        StringBuilder s = new StringBuilder();
         
        // 2. 첫 번째, 마지막 문자를 제외하고 반복.
        for(int i = 1; i<str.length()-1;i++){
            // 3. ( -> )
            if(str.charAt(i) == '(') s.append(")");
            // 4. ) -> (
            else s.append("(");
        }
        // 5. 새로운 문자열을 반환.
        return s.toString();
    }
    
    // 올바른 괄호 문자열 판단 메소드.
    public static boolean check(String str){
        // 1. ( 의 개수를 세는 변수.
        int open = 0;            
        // 2. 첫 문자가 )인 경우는 올바른 괄호 문자열인 경우가 아니므로 false.
        if(str.charAt(0) ==')') return false;
        // 3. 문자열 탐색.
        for(int i =0;i<str.length();i++){
            // 4. (의 개수를 카운팅.
            if(str.charAt(i) == '(') open++;
            else {
                // 5. )를 만나면 open 감소.
                open--;
                // 6. 카운팅 과정에서 open이 음수가 되면 (의 개수보다 )의 개수가 많아지는 순간이므로 올바른 괄호 문자열이 아니다. 따라서 false.
                if(open<0) return false;
            }
        }
        // 7. 위 조건을 모두 통과하면 올바른 괄호 문자열이다.
        return true;
    }
    
    // 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열 변환 메소드.
    public static String split(String w){
        
        // 1. 입력된 문자열 w를 u와 v로 나누어 저장하는 StringBuilder클래스 객체.
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        // 2. 빈 문자열인 경우, 빈 문자열을 반환.
        if(w.length() == 0) return "";
        
        // 3. (의 개수를 저장하는 변수.
        int open = 0;
        for(int i =0;i<w.length();i++){ 
            // 4. 한 문자가 (인 경우 open은 증가.
            if(w.charAt(i) == '(') open++;    
            // 5. )인 경우 open은 감소.
            else open--;
            
            // 6. 처음 open이 0이 된 경우가 가장 작은 단위의 "균형잡힌 괄호 문자열".
            if(open == 0){
                // 7. 해당 인덱스를 기점으로 u와 v로 분리.
                u.append(w.substring(0,i+1));
                v.append(w.substring(i+1,w.length()));
                
                // 8. u가 "올바른 괄호 문자열"이라면,
                if(check(u.toString())){
                    // 9. v에 대해 재귀호출 후, u에 이어 붙인다. 이 과정 후 break에 걸려 u를 반환하므로 변환 과정에 성립.
                    u.append(split(v.toString())); 
                // 10. u가 "올바른 괄호 문자열"이 아니라면,    
                }else{
                    // 11. 새로운 StringBuilder 객체 생성.
                    StringBuilder str = new StringBuilder();
                    // 12. (를 붙인다.
                    str.append("(");
                    // 13. v에 대해 재귀호출 후 붙인다.
                    str.append(split(v.toString()));
                    // 14. )를 붙인다.
                    str.append(")");
                    // 15. u를 조작해 붙인다.
                    str.append(reverse(u.toString()));
                    // 16. 새로운 문자열을 반환한다.
                    return str.toString();
                }
                break;             
            }
        }
        // 17. u가 올바른 문자인 경우에만 반환되는 u.
        return u.toString();        
    }
    
    public String solution(String p) {
        String answer;
        
        // 1. 올바른 괄호 문자열이라면, 바로 문자열을 반환한다.
        if(check(p))
            return p;
        // 2. 나머지 균현잡힌 괄호 문자열 => 올바른 괄호 문자열 변환 메소드 호출 및 answer에 저장.        
        answer = split(p);
    
        return answer;
    }
}
