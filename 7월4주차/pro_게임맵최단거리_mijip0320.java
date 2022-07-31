package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;

public class pro_게임맵최단거리_mijip0320 {
    // 좌표에서의 상,하,좌,우 탐색을 위한 배열.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    //static boolean[][] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = 0;
        //int[] countList = new int[maps.length];
        ArrayList<Integer> numList = new ArrayList<>();
        //int max = 0;
        //1,0,1,1,1
        //1,0,1,0,1
        //1,0,1,1,1
        //1,1,1,0,1
        //0,0,0,0,1

        bfs(maps);
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }

    public static void bfs(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] cur = {0,0,1};
        q.add(cur); //시작점 추가
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();

            //종료 조건 : 종료 지점에 도착했을때 min 값 비교, return
            if(current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                min = min > current[2] ? current[2] : min;
                return;
            }

            //계속 탐색한다면 x,y값에 새로운 값 적용, 탐색 실행
            for(int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];
                int count = current[2] + 1;
                //탐색 조건에 맞을 때 탐색 실행
                if(newX >= 0 && newY >= 0 && newX < maps.length && newY < maps[0].length) {

                    if(maps[newX][newY] != 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        int[] newCur = new int[3];
                        newCur[0] = newX;
                        newCur[1] = newY;
                        newCur[2] = count;
                        q.add(newCur);
                    }
                }
            }
        }
    }
}
