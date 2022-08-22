import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class pro_기능개발 {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{93, 30, 55}
                ,new int[]{1,30,5}
        ));
    }
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> que = new LinkedList<>();
        for(int i=0 ;i<progresses.length; i++){
            int pro = progresses[i];
            int speed = speeds[i];

            int num = 100-pro ;
            int time = num % speed == 0 ?  num/speed:  num/speed +1;
            que.offer(time);
        }

        LinkedList<Integer> list = new LinkedList<>();
        int now = que.poll();
        System.out.println(now);
        int cnt =1;
        while(!que.isEmpty()){
            int ready = que.peek();
           // System.out.println(ready+" "+now);
            if(now >= ready){
                cnt++;
                que.poll();
                if(que.isEmpty()){
                    //System.out.println("--------8---"+cnt);
                    list.add(cnt);
                }
            }else{
                list.add(cnt);
                //System.out.println("-----------"+cnt);
                cnt=0;
                if(!que.isEmpty())
                    now = que.peek();
            }

        }


        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
           // System.out.print(answer[i]+" , ");

        }
        return answer;
    }
}

