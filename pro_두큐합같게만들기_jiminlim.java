import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0 ;
    	long sum2 = 0 ;
    	int length = queue1.length ;
    	Queue<Long> que1 = new LinkedList<Long>() ;
    	Queue<Long> que2 = new LinkedList<Long>() ;
    	int cnt = 0 ;
    	
    	long midValue = 0 ;

    	
    	for(int i =0; i < length ; i++) {
    		midValue += queue1[i] + queue2[i] ;
    		sum1 += queue1[i] ;
    		sum2 += queue2[i] ;
    		que1.add((long) queue1[i]) ;
    		que2.add((long) queue2[i]) ;
    		
    	}

//    	예외 케이스
    	if((sum1 + sum2) % 2 == 1) {
    		return - 1;
    	}

    	midValue /= 2 ;
    	
    	while(true) {
    		if(cnt >= length * 3)
    			break ;
            
//    		첫번째 큐가 더 크다면 첫번째 큐에 값을 추가해준다.
    		if(sum1 > sum2) {
    			que2.add(que1.peek()) ;
    			sum1 -= que1.peek() ;
    			sum2 += que1.poll() ;
    		}
    		
//    		두번째 큐가 더 크다면 두번째 큐에 값을 추가해준다.
    		else if(sum1 < sum2) {
    			que1.add(que2.peek()) ;
    			sum2 -= que2.peek() ;
    			sum1 += que2.poll() ;
    		}
    		
//    		sum1 == sum2
    		else {
    			if(sum1 == midValue) {
                   return cnt ;
                }
    				
    			break ;
    		}
    		
    		cnt++ ;
    	}
    	       
        return -1;
    }
}
