package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12911
import java.util.*;

public class pro_다음큰숫자_mijip0320 {
    public static void main(String[] args) {
        int n = 15;
        int newN = n+1;
        String nBin = Integer.toBinaryString(n);
        int answer = 0;
        while(true){
            String newBin = Integer.toBinaryString(newN);
            int count1 = 0;
            int count2 =0;
            for(int i=0; i<nBin.length(); i++){
                if(nBin.charAt(i) == '1'){
                    count1++;
                }
            }

            for(int j=0; j<newBin.length(); j++){
                if(newBin.charAt(j) == '1'){
                    count2++;
                }
            }

            if(count1 == count2){
                answer = newN;
                break;
            }else{
                newN++;
            }
        }


        System.out.println(answer);
    }
}
