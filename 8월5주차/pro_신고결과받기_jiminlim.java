import java.util.*;
class Solution {
    public  static int[] solution(String[] id_list, String[] report, int k){
       // ArrayList<Integer> list = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Map<String, Integer> id = new HashMap<String, Integer>();
        //동일 유저 신고 1회
        int len = id_list.length;
        for(int i=0; i<len ; i++){
            String name = id_list[i];
            id.put(name,0);
        }
        int r_len = report.length;
        for(int i =0; i<r_len; i++){
            String[] str = report[i].split(" ");
            String b = str[0];
            String a = str[1];
           // System.out.println("             "+a+" "+b);
            if(map.containsKey(a)){
               // System.out.println(a+" 2 "+b);
                Set<String> set = map.get(a);
                set.add(b);
            }else{
               // System.out.println(a+" 3 "+b);
                Set<String> set =  new HashSet<>();
                set.add(b);
                map.put(a,set);
            }
        }
        int[] answer = new int[len];


        for(int i =0; i<len; i++) {

            Set<String> s = map.get(id_list[i]);

            if(s != null &&  s.size() >= k){
                //신고 한사람한테 메일가도록 수정해야함.
                for(String n : s){
                    int cnt = id.get(n)+1;
                    id.put(n,cnt);
                }
            }
            else
                answer[i] = 0;
        }

        for(int i =0; i<len; i++) {
            answer[i] = id.get(id_list[i]);
        }

        return answer;
    }
}
