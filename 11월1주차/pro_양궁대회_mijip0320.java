package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/92342
import java.util.*;

public class pro_양궁대회_mijip0320 {
    static int[] ryan;
    static int[] answer = {-1};
    static int max = -1000; //최대로 차이나는 점수

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

        //int[] answer = new int[info.length];

        ryan = new int[11];
        dfs(info, 1, n);

        for(int i : answer){
            System.out.println(i);
        }
    }

    public static void dfs(int[] info, int count, int n){ //static 빼야 시간초과가 안남....
        if( count == n+1){
            int ap = 0;
            int rp = 0;
            for(int i=0; i<=10; i++){
                if(info[i] != 0 || ryan[i] != 0){
                    if(info[i] < ryan[i]) rp += 10-i; //라이언 점수 계산
                    else ap += 10 - i; //어피치 점수 계산
                }
            }

            if(rp > ap) {
                if(rp - ap >= max){ //라이언 승
                    answer = ryan.clone();
                    max = rp - ap;
                }
            }
            return;
        }
        for(int j=0; j<=10 && ryan[j] <= info[j]; j++){
            ryan[j]++;
            dfs(info, count+1, n);
            ryan[j]--;
        }

    }
}
