import java.util.*;
class Solution {
    public static int[][] map;

    public static int n, a,b;
    public static boolean[] visit;
    public int solution(int n, int[][] wires) {
        n=n;
        map = new int[n+1][n+1];
        for(int i = 0;i< wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }


        int answer = Integer.MAX_VALUE;
        for(int i = 1;i<=n; i++){
            for(int j =i+1; j<=n; j++){      
                if(map[i][j] == 0) continue;
                visit = new boolean[n+1];
                visit[i] = true;
                a=1; 
                dfs(i,j,1,n);
                answer = Math.min(Math.abs(a-(n-a)), answer);
            }
        }


        return answer;
    }
    public static void dfs(int num,int cut, int flag, int len){       

        for(int i =1; i<= len; i++){
            if(cut == i) continue;
            if(map[num][i] == 0) continue;  
            if(visit[i]) continue;            
            visit[i] = true;
            if(flag == 1){
                a ++;   
            } 
            
            dfs(i,cut,flag,len);

        }


    }
}
