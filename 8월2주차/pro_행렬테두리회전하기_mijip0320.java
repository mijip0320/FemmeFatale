package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/77485
import java.util.*;

//다시 풀어보기!!!
//https://yline.tistory.com/3

public class pro_행렬테두리회전하기_mijip0320 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] answer = new int[queries.length];
        // 숫자를 담을 행렬
        int[][] arr = new int[rows][columns];
        // 행렬 초기화(ex. 1~36)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) arr[i][j] = i * columns + j + 1;
        }
        // queries안에 정보를 rotation을 통해 회전
        for(int i = 0; i < queries.length; i++)
            answer[i] = rotation(arr, queries[i][1] - 1, queries[i][0] - 1, queries[i][3] - 1, queries[i][2] - 1);


        for(int j=0; j<answer.length; j++){
            System.out.println(answer[j]);
        }
    }
//// 왼쪽 위, 오른쪽 아래 좌표를 받으면 시계방향으로 회전 후 가장 작은 값을 반환하는 함수
    public static int rotation(int[][] arr, int x1, int y1, int x2, int y2){
        int min = arr[y1][x1];  // 시작값을 최소 값으로 초기화
        int tmp = arr[y1][x1];  // 처음 시작값을 마지막에 넣어주기 위해 임시 저장
        // 오른쪽 회전
        for(int i = y1; i < y2; i++){
            arr[i][x1] = arr[i + 1][x1];
            min = Math.min(min, arr[i][x1]);
        }
        // 아래쪽 회전
        for(int i = x1; i < x2; i++){
            arr[y2][i] = arr[y2][i + 1];
            min = Math.min(min, arr[y2][i]);
        }
        // 왼쪽 회전
        for(int i = y2; i > y1; i--){
            arr[i][x2] = arr[i - 1][x2];
            min = Math.min(min, arr[i][x2]);
        }
        // 위쪽 회전
        for(int i = x2; i > x1 + 1; i--){
            arr[y1][i] = arr[y1][i - 1];
            min = Math.min(min, arr[y1][i]);
        }
        // 마지막 값 이동
        arr[y1][x1 + 1] = tmp;

        return min;
    }
}
