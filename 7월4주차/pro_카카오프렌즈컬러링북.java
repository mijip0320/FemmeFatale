package solve;

import java.util.Arrays;

public class pro_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6,4, new int[][]
			{{1, 1, 1, 0}, 
			{1, 2, 2, 0}, 
			{1, 0, 0, 1},
			{0, 0, 0, 1}, 
			{0, 0, 0, 3}, 
			{0, 0, 0, 3}})));
	}

	
	private static int cnt = 1;
	private static int M,N;
	private static int[][] dir = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	public static int[] solution(int m, int n, int[][] picture) {
        M=m;N=n;

        boolean[][] visit = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i =0; i<m; i++){
        	for(int  j =0; j<n; j++) {
        		if(!visit[i][j] && picture[i][j] != 0) {
        			numberOfArea++;
        			dfs(i,j,picture,visit);
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        			cnt =1;
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

	
	private static void dfs(int i, int j, int[][] picture, boolean[][] visit) {
		
		visit[i][j] = true;
		for(int d = 0; d<4; d++) {
			int next_y = i + dir[d][0];
			int next_x = j + dir[d][1];
			
			if(next_y < 0 || next_y>=M || next_x <0 || next_x >=N)continue;
			if(visit[next_y][next_x])continue;
			if(picture[next_y][next_x] != picture[i][j]) continue;
			cnt++;
			dfs(next_y,next_x, picture,visit);	
			
		}
		
	}
}
