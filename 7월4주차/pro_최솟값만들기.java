package solve;

import java.util.Arrays;

public class pro_최솟값만들기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2}, new int[] {5,4,4}));
		System.out.println();
	}

	public static int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length-1;
        for(int i=0; i< A.length; i++) {
        	answer+=(A[i]*B[len]);
        	len --;
        }

        return answer;
    }
}
