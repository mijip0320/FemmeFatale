import java.util.LinkedList;
import java.util.Queue;

public class pro_게임맵최단거리 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1}
                ,{1,1,1,0,1},{0,0,0,0,1}}));
    }


    private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int solution(int[][] maps) {
        int answer = 1;

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        v[0][0] = true;
        boolean flag = false;
        Loop1:while(!que.isEmpty()){
           int size = que.size();
           for(int s =0; s<size; s++){
               int[] q = que.poll();

               for( int  d =0; d<4; d++){
                   int ny = q[0] + dir[d][0];
                   int nx = q[1] + dir[d][1];

                   if(ny<0 || ny>=n || nx <0 || nx>=m) continue;
                   if(v[ny][nx]) continue;
                   if(maps[ny][nx]==0) continue;
                   if(ny == n-1 && nx == m-1) {
                       flag = true;
                       answer++;
                       break Loop1;
                   }
                    v[ny][nx] = true;
                   que.offer(new int[]{ny,nx});
               }

           }

//           for(int i=0; i<n; i++){
//               for(int j=0 ;j<n; j++){
//                   System.out.print(v[i][j]+" ");
//               }System.out.println();
//           }
//            System.out.println();
            answer++;
        }

        return flag?answer:-1;
    }
}
