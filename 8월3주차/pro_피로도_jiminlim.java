import java.util.Arrays;
import java.util.Comparator;

public class pro_피로도 {
    public static void main(String[] args) {
        System.out.println(solution(80,new int[][]{{80,20},{50,40},{30,10},{10,10},{10,10}}));
    }

    private static int max,Len;
    public static int solution(int k, int[][] dungeons) {

        Arrays.sort(dungeons, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });


        max = -1;
        Len = dungeons.length;
        boolean[] visit = new boolean[Len];
        advanture(visit,k,0,dungeons);

        return max;
    }

    private static void advanture(boolean[] visit, int k, int cnt, int[][] dungeons) {

        //System.out.println(Arrays.toString(visit));

        if(cnt == Len ){
            max = Len;
            return;
        }
        max = Math.max(max,cnt);
        for(int i=0; i<Len; i++){
            int small = dungeons[i][0];
            int use = dungeons[i][1];
            if(visit[i])continue;
            if(k < small) continue;

            visit[i] = true;
            advanture(visit,k-use, cnt+1,dungeons);
            visit[i] = false;
        }
    }
}
