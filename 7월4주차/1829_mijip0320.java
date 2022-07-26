import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1829

class Solution {
    
     // 좌표에서의 상,하,좌,우 탐색을 위한 배열.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    static int count;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        count =0;
        visit = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visit[i][j] ){ //아직 방문하지 않았을 때
                    numberOfArea++;
                    dfs(i,j,picture);
                }
                if(count > maxSizeOfOneArea) maxSizeOfOneArea = count;
                count=0;
            }
        }

        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static void dfs(int x, int y, int[][] picture){
        visit[x][y] = true;
        count++;
        for(int i=0; i<4; i++){ //좌표 이동
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx < 0 || nx>= picture.length || ny<0 || ny>= picture[0].length) continue;

            //값이 같고 아직 탐색하지 않았을 때
            if(picture[x][y] == picture[nx][ny] && !visit[nx][ny]){
                dfs(nx, ny, picture);
            }
        }
    }
}