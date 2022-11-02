class Solution {
    public int[] solution(int n, long left, long right) {
        
        //2차원배열에 값을 넣자.
        // int[][] arr2 = new int[n][n];
        // for(int i = 1; i<= n; i++){
        //     for(int y = 0; y<i;y++){
        //         for(int x = 0; x<i; x++){
        //             if(arr2[y][x] != 0) continue;
        //             arr2[y][x] = i;
        //         }                
        //     }
        // }
        
        //print하자
        int len = (int)(right-left)+1;
        int starty = (int)(left/n);
        int startx = (int)(left%n);
       // System.out.println(starty+" "+startx);        
        
        int[] answer = new int[len];
        int index =0;
        for(int i = 0; i< len; i++){
            //answer[i]=arr2[starty][startx];
            answer[i] = Math.max(starty, startx) +1;
            startx++;
            if(startx == n){
                startx = 0; 
                starty ++;
            }
        }        
        
        return answer;
    }
}
