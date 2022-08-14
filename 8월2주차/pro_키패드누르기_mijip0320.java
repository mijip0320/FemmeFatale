import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //직전 왼손, 오른손 위치 저장
        int left =10;
        int right =12;

        for(int i=0; i< numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right = numbers[i];
            }else{
                //int tmp = numbers[i];
                if(numbers[i]==0) numbers[i]=11;
                //leftdist, rightdist = 왼손과 입력받은 값의 거리, 오른손과 입력받은 값의 거리
                //키패드 위아래로 3차이, 양옆으로 1차이 
                int leftdist = Math.abs(numbers[i]-left)/3+Math.abs(numbers[i]-left)%3;
                int rightdist = Math.abs(numbers[i]-right)/3+Math.abs(numbers[i]-right)%3;

                if(leftdist<rightdist){
                    answer+="L";
                    left = numbers[i];
                }else if(leftdist>rightdist){
                    answer+="R";
                    right = numbers[i];
                }else{
                    if(hand.equals("left")){
                        answer+="L";
                        left = numbers[i];
                    }else{
                        answer+="R";
                        right = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
