import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
       int[] answer = new int[2];
        boolean flag = true;

        ArrayList<String> list = new ArrayList<>();


        //조건1 : 전 String의 마지막 문자와 현재 String의 첫번째 문자가 같아야함
        //조건2 : 현재 String이 배열에 포함X
        //조건 3: 한글자 단어 X

        for(int i=0; i<words.length; i++) {
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
                    || list.contains(words[i])){   // 이전에 등장한 단어인경우
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }

            list.add(words[i]); // 현재 단어 리스트에 넣기
        }
       if(flag) {
           answer[0] = 0;
           answer[1] = 0;
       }


        return answer;
    }
}