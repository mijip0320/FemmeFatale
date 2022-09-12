package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12949
import java.util.*;

public class pro_행렬의곱셈_mijip0320 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3,3},{3,3}};

        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i< arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                int m=0;
                while(m < arr1[0].length){
                    answer[i][j] += arr1[i][m] * arr2[m][j];
                    m++;
                }
            }

        }

        //정답출력용 
        for(int k=0; k<answer.length; k++){
            for(int kk=0; kk<answer[0].length; kk++){
                System.out.println(answer[k][kk]);
            }
        }

    }
}
