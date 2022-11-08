import java.util.*;
class Solution {
    public static int[][] map;

    public static int n, a,b;
    public static boolean[] visit;
    public int solution(int n, int[][] wires) {
        ArrayList<int[]> wire = new ArrayList<>();
         //hash = new HashMap<>();
        n = 0;
        for(int i =0; i< wires.length; i++){
            wire.add(new int[]{wires[i][0], wires[i][1]});
            n = Math.max(n, Math.max(wires[i][0],wires[i][1]));
        }
        map = new int[n+1][n+1];
        //System.out.println("ddddd "+n);
        for(int i = 0;i< wire.size(); i++){
            int[] arr = wire.get(i);
            map[arr[0]][arr[1]] = 1;
            map[arr[1]][arr[0]] = 1;
        }

        // for(int i = 0;i< n+1; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        // int index = 0;
        // for(Integer key : hash.keySet()){            
        //     hash.put(key,index);
        //     index ++;
        // }

        int answer = Integer.MAX_VALUE;
        for(int i = 1;i<=n; i++){
            for(int j =i+1; j<=n; j++){      
                if(map[i][j] == 0) continue;
                visit = new boolean[n+1];
                visit[i] = true;
                a=1; b=1;
               // System.out.println("first"+ i);
                dfs(i,j,1,n);
                //System.out.println("second" + j);
                visit[j] = true;
                dfs(j,i,0,n);
                //System.out.println(a+" "+b);
                answer = Math.min(Math.abs(a-b), answer);
            }
        }


        return answer;
    }
    public static void dfs(int num,int cut, int flag, int len){
        //System.out.println("num : "+num+ "    "+n+"  "+len);        

        for(int i =1; i<= len; i++){
            if(cut == i) continue;
           // System.out.println("> "+i);
            if(map[num][i] == 0) continue;  
            //System.out.println(">>>>> "+i);
            if(visit[i]) continue;            
            visit[i] = true;
            if(flag == 1){
                a ++;   
            } 
            if(flag == 0) {
                b++;
            }
            dfs(i,cut,flag,len);

        }


    }
}
