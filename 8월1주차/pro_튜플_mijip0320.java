import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        //int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-"); // "1,2,3-2,1-1,2,4,3-2
        String str[] = s.split("-"); // {"1,2,3","2,1","1,2,4,3"}
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){

                return Integer.compare(o1.length(), o2.length());
            }
        });

        //각 문자열을 탐색
        for(String ss : str){
            String[] temp = ss.split(",");
            for(int i = 0 ; i < temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                if(!answer.contains(n))
                    answer.add(n);
            }
        }

        return answer;
    }
}
