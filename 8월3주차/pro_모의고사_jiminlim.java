import java.util.ArrayList;
class Solution {
    static int[] n1 = {1,2,3,4,5},
		    n2 = {2,1,2,3,2,4,2,5}, n3 = {3,3,1,1,2,2,4,4,5,5};
    public static int[] solution(int[] answers) {
    	
    	int cnt1 =0,cnt2 =0, cnt3=0;
    	int idx1 =0 , idx2 =0, idx3=0;
    	for(int i=0; i<answers.length; i++) {
    		int answer = answers[i];
    		if(n1[idx1]==answer ) cnt1 ++;
    		if(n2[idx2]==answer ) cnt2 ++;
    		if(n3[idx3]==answer ) cnt3 ++;
    		
    		idx1++; idx2++; idx3++;
    		if(idx1 == n1.length) idx1 =0;
    		if(idx2 == n2.length) idx2 =0;
    		if(idx3 == n3.length) idx3 =0;
    		
    	}
    	
    	ArrayList<Integer>list = new ArrayList<Integer>();
    	
    	int max = Math.max(cnt1, Math.max(cnt2, cnt3));
    	
    	if(max == cnt1) list.add(1);
    	if(max == cnt2)list.add(2);
    	if(max==cnt3)list.add(3);
    	   	
    	int[] answerlist = new int[list.size()];
    	for(int i=0 ;i<list.size(); i++	) {
    		answerlist[i] = list.get(i);
    	}
    	return answerlist;
    }
}
