class Solution {
    public String solution(int[] numbers, String hand) {
        String answer ="";
        //시작
        String[][] map = new String[4][3];

        int left[] = new int[]{3,0};
        int right[] = new int[]{3,2};
        map[3][0] = "L";
        map[3][2] = "R";

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] % 3 == 1 ){ // 왼쪽 손 움직여
                int y = numbers[i]/3;
                map[left[0]][left[1]] = null;
                map[y][0] = "L";

                left[0] = numbers[i]/3;
                left[1] = 0;
                answer += "L";
            }
            else if(numbers[i] != 0 &&  numbers[i] % 3 == 0){ // 오른쪽 손 움직여
                int y = numbers[i]/3 -1;

                map[right[0]][right[1]] = null;
                map[y][2] = "R";

                right[0] = numbers[i]/3-1;
                right[1] =2;
                answer += "R";
            }else{
                int dest[] = new int[2];
                if(numbers[i] == 0){
                    dest[0] = 3; dest[1] = 1;
                }else{
                    dest[0] = numbers[i]/3;
                    dest[1] = numbers[i]%3-1;
                }

                int left_distance = Math.abs(dest[0] - left[0]) + Math.abs(dest[1] - left[1]);
                int right_distance = Math.abs(dest[0] - right[0]) + Math.abs(dest[1] - right[1]);

                if(left_distance < right_distance){
                    left[0] = dest[0];
                    left[1] = dest[1];
                    answer += "L";
                }else if(left_distance == right_distance){
                    if(hand.equals("right")){
                        right[0] = dest[0];
                        right[1] = dest[1];
                        answer += "R";
                    }else{
                        left[0] = dest[0];
                        left[1] = dest[1];
                        answer += "L";
                    }
                }else{
                    right[0] = dest[0];
                    right[1] = dest[1];
                    answer += "R";
                }
            }
        }

        return answer;
    }
}
