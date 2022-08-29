public static String solution2(String s) {
		String word = "";
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0 ;i<s.length(); i++) {	
			char ss = s.charAt(i);
				
			if(ss == ' ') {
				max = Math.max(max, Integer.parseInt(word));
				min = Math.min(min, Integer.parseInt(word));
				
				word = ""; 
			}else {
				word += ss+"";
			}
			
		} 
		max = Math.max(max, Integer.parseInt(word));
		min = Math.min(min, Integer.parseInt(word));
		
        return min+" "+max;
    }
