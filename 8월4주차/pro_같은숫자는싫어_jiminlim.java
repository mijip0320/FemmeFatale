import java.util.*;

public class Solution {
   public static int[] solution(int []arr) {
       int l = 1000000;

        int len = arr.length;
        ArrayList<Integer>list = new ArrayList<Integer>();
        int save =arr[0];

        for(int i =1; i<len ; i++) {
            if(save != arr[i]) {
                list.add(save);
                save = arr[i];              
            }
        }
       if(list.size() == 0) list.add(save);
        if(list.get(list.size()-1) != save) list.add(save);
        int[] answer = new int[list.size()];
        for(int i=0 ;i<list.size(); i++) {
            answer[i] = list.get(i);

        }

        return answer;
    }
}
