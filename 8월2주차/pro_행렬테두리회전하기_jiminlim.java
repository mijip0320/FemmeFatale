package solve;

public class pro_행렬테두리회전하기 {

	public static void main(String[] args) {
		
		System.out.println(solution(6,6,new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}}));
	}
	
	private static int[][] map, dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 우 하 좌 상

	public static int[] solution(int rows, int columns, int[][] queries) {
        
		map = new int[rows][columns];
		//값넣어
		int num =1;
        for(int i=0 ;i< rows; i++) {
        	for(int j =0;j<columns; j++) {
        		map[i][j] = num++;
        	}
        }
        
        for(int i=0 ;i< rows; i++) {
        	for(int j =0;j<columns; j++) {
        		System.out.print(map[i][j]+" ");
        	}System.out.println();        	
        }
        System.out.println();
        
        //시뮬 돌려
        
        int[] answer = new int[queries.length];
        for(int q =0 ; q < queries.length; q++) 
        {
        	answer[q] = simul(rows, columns, queries[q]);
        	
        }
        
        
        //최솟값 출력해
		
		
		
        return answer;
    }
	private static int simul(int rows, int columns,int[] query) {
		int ny=query[0]-1, nx = query[1]-1;
		
				int next=0;
		int temp =map[ny][nx];
		int Min = Integer.MAX_VALUE;
		//4방향으로 가긴함
		//우
		int distance = query[3] - query[1];
		for(int i =0; i< distance; i++) {
			ny = ny + dir[0][0];
			nx = nx+ dir[0][1];
			next = map[ny][nx];
			map[ny][nx] = temp;
			
			Min = Math.min(temp, Min);
			temp = next;
		}
		
		
		//하
		ny = query[0]-1;
		nx = query[3]-1;
		distance = query[2] - query[0];
		for(int i =0; i< distance; i++) {
			ny = ny + dir[1][0];
			nx = nx+ dir[1][1];
			next = map[ny][nx];
			map[ny][nx] = temp;
			Min = Math.min(temp, Min);
			temp = next;
		}
        
		
		//좌
		ny = query[2]-1;
		nx = query[3]-1;
		distance = query[3] - query[1];
		for(int i =0; i< distance; i++) {
			ny = ny + dir[2][0];
			nx = nx+ dir[2][1];
			next = map[ny][nx];
			map[ny][nx] = temp;
			Min = Math.min(temp, Min);
			temp = next;
		}
		
		
		//상
		ny = query[2]-1;
		nx = query[1]-1;
		distance = query[2] - query[0];
		 int last =0;
		for(int i =0; i< distance; i++) {
			System.out.print(map[ny][nx]+" ");
			ny = ny + dir[3][0];
			nx = nx+ dir[3][1];
			last = temp;
			next = map[ny][nx];
			map[ny][nx] = temp;
			Min = Math.min(temp, Min);
			temp = next;
						
		}
		map[query[0]-1][query[1]-1]=last;			
     
        return Min;
	}

}
