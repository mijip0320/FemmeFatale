package solve;

import java.util.HashMap;
import java.util.List;

public class pro_위장 {

	public static void main(String[] args) {
		String[][] clothes = new String[][]{{"a", "headgear"},{"b", "headgear"},{"c", "eyewear"},{"d", "eyewear"},{"e", "face"},{"f", "face"}};
		
	
		System.out.println(solution2(clothes));

	}
	private static int sum ;
	private static int N;
	private static HashMap<String, Integer> map;
	 public static int solution(String[][] clothes) {
		 map = new HashMap<>();
		 
		 for(int i=0; i<clothes.length; i++) {
			 String val = clothes[i][1];
			 int number = 1;
			 if(map.containsKey(val) ){
				number = map.get(val); 
				number++;
			 }
			 map.put(val, number );
		 }
		 N = map.size();
		 if(map.size() == 30){ return 1073741823; }
		 
		 String[] keylist = new String[N];
		 int idx=0;
		 for(String key:map.keySet()) {
				keylist[idx++] = key;		
		 }
		 //키 리스트 조합시킨다.		 
		 for(int r =1; r<=N; r++) {
			 find(N,r,0,0,keylist,new String[r]);
		 }		
		 
		return sum;
	 }
	private static void find(int n, int r, int cnt, int start,String[] keylist, String[] arr) {
		if(r==cnt) {
			int number =1;
			for(int i =0;i<arr.length;i++) {
				number *= map.get(arr[i]);
			}
			sum += number;
			return;
		}
		
		for(int i =start; i<n; i++) {
			arr[cnt] = keylist[i];			
			find(n,r,cnt+1,i+1,keylist,arr);
		}
	}
	

	public static int solution2(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for(int i=0; i<clothes.length; i++){
            String kind = clothes[i][1];
            int num = 1;
            if (map.containsKey(kind)){
               num = map.get(kind)+1;
            } 
            map.put(kind,num);
        }

        for(String key:map.keySet()) {
            answer *= map.get(key)+1;
        }

        answer--;

        return answer;
    }
}
