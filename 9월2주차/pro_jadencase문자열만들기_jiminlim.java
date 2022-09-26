public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		boolean flag = true;
		for(int i =0; i<len; i++) {
			char temp = s.charAt(i);
			//System.out.println(temp +" "+flag);
			if(temp == ' ') { //띄어쓰기 일때 플래그 수정
				flag = true;sb.append(temp); continue;
			}
			if(!flag) { 
				String emp = (temp+"").toLowerCase();
				sb.append(emp); continue;//첫문자만
			}
			
			
			int num = temp - '0';
			
			if((num >= 49 && num <= 74)|| (num >= 17 && num <= 42)) {//영어라면
				String emp = (temp+"").toUpperCase();
				sb.append(emp);
			}
			else if(num >= 0 && num < 10) {
				sb.append(temp);
			}
			flag = false;
		}
		
        String answer = sb.toString();
        return answer;
    }
