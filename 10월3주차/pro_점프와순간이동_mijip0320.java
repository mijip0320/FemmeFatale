package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12980
import java.util.*;

public class pro_점프와순간이동_mijip0320 {
    public static void main(String[] args) {
        int n = 5000;
        int ans=0;

        while(true){
            if(n % 2 == 1){
                ans++;
                n = n/2;
                if(n == 0){
                    break;
                }
            }else{
                n = n/2;
            }
        }


        System.out.println(ans);
    }
}
