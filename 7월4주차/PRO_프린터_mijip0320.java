package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/42587
import java.util.*;

public class PRO_프린터_mijip0320 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = 0;
        Queue<Printer> queue = new LinkedList<>();

        for(int i=0; i< priorities.length; i++){
            queue.offer(new Printer(i,priorities[i]));
        }

        while(!queue.isEmpty()){
            boolean flag = false;
            int com = queue.peek().prior;
            for (Printer p : queue) { //큐의 값들을 하나씩 Printer p로 꺼내보기
                if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
                    flag = true;
                    break;
                }
            }

            if(flag){ //true값이면 맨 앞으로 가져옴
                queue.offer(queue.poll());
            } else {// 현재 맨앞의 숫자가 가장 클 때(flag = false일때)
                if (queue.poll().location == location) { //Printer 객체의 location과 주어진 location이 같다면
                    answer = priorities.length - queue.size();
                }
            }
        }

        System.out.println(answer);
    }
}

class Printer { //위치, 가중치를 표현하는 클래스
    int location;
    int prior;

    Printer(int location, int prior) {
        this.location = location;
        this.prior = prior;
    }
}
