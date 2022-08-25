import java.util.*;
class Solution {
    public static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        //설문돌려
        for(int i= 0;i< survey.length; i++){
            String type = survey[i];
            char a = type.charAt(0);
            char b = type.charAt(1);
            int num =choices[i]-4;
            char key = ' ';
            if(num > 0)
                key = b;
            else if(num < 0)
                key = a;
            else
                continue;
            int score = map.get(key)+ Math.abs(num);
            map.put(key,score);

        }

        //결과 출력
        String answer = "";
        if(map.get('R') >= map.get('T')) answer+="R";
        else answer +="T";

        if(map.get('C') >= map.get('F')) answer+="C";
        else answer +="F";

        if(map.get('J') >= map.get('M')) answer+="J";
        else answer +="M";

        if(map.get('A') >= map.get('N')) answer+="A";
        else answer +="N";

        return answer;
    }
}
