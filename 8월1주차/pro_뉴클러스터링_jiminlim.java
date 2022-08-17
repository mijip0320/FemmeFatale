package solve;

import java.util.HashMap;

public class pro_뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("A+C", "DEF"));
	}
	public static int solution(String str1, String str2) {
		//첫번째 두개씩 유효한 거 끊어 map에 넣어
		HashMap<String, Integer> map = new HashMap<>();
		int str1_len = str1.length();
		int str1_size = 0;
		
		int gyo = 0;
		for(int i=0; i<str1_len-1; i++) {
			//두개씩 끊자
			String word = str1.substring(i,i+2);
			word = IsValid(word);
			System.out.println(word);
			if(word.equals("")) continue;
			if(map.containsKey(word)) {
				int num = map.get(word);
				map.put(word, num+1);
			}else {
				map.put(word, 1);
			}			
			str1_size++;
		}
		
		System.out.println();
		//두번째 유효한거 끊어서 map에 비교해. 
		int str2_len = str2.length();
		int str2_size = 0;
		for(int i=0; i<str2_len-1; i++) {
			//두개씩 끊자
			String word = str2.substring(i,i+2);
			word = IsValid(word);
			System.out.println(word);
			if(word.equals("")) continue;			
			if(map.containsKey(word)) {
				int num = map.get(word);
				if(num-1 == 0) map.remove(word);
				else map.put(word, num-1);
				gyo++;
			}		
			str2_size++;
		}
		
		//교집합 숫자 구해		
		int hap = str1_size +  str2_size - gyo;			
		if(gyo == 0 && hap == 0) {
			return 65536;
		}
		
			
        double answer = (double)gyo/hap;
        return (int) Math.floor(answer*65536);
    }
	private static String IsValid(String word) {		
		//소문자로 다 바꿔.
		word = word.toUpperCase();
		//영어야?
		int fn = word.charAt(0)-'A';
		int sn = word.charAt(1)-'A';
		if(fn >= 0 && fn< 26 && sn >= 0 && sn < 26) {
			return word;
		}else {
			return "";
		}
		
	}
}
