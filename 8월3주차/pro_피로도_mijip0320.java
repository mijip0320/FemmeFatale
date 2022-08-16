import java.util.*;

class Solution {
     public static boolean[] visited;
    public static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
          visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    public static void dfs(int count, int k, int[][] dungeons){
        for(int i=0; i< dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                //count 증가, k 값 재조정
                dfs(count+1,k - dungeons[i][1], dungeons);
                visited[i] = false;
              
            }
        }
        answer = Math.max(count, answer);
    }
}