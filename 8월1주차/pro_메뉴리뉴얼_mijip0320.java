import java.util.*;


class Solution {
    static ArrayList<String> answerList = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 1. 각 Order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        //2. 각 order 기준으로 course 만큼 조합 만들기
        for(int i=0; i< course.length; i++){
            for(int j=0; j< orders.length; j++){
                dfs("",orders[j], course[i]);
            }

            //3. 가장 많은 조합 answer 추가
            if(!map.isEmpty()){
                ArrayList<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max){
                            answerList.add(key);
                        }
                    }
                }
                map.clear();
            }


        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];

        for(int i=0; i< answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(String pattern, String order, int count){

        //종료 조건: count == 0
        if(count == 0) {
            map.put(pattern, map.getOrDefault(pattern,0) + 1);
            return;
        }

        //0부터 length까지 조합
        for(int i=0; i<order.length(); i++){
            dfs(pattern+order.charAt(i), order.substring(i+1), count - 1);
        }
    }
}