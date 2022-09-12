	public static void main(String[] args) {
		System.out.println(solution(new int[] {4, 1, 2, 1}, 4));

	}
	
	private static int count ;
	public static int solution(int[] numbers, int target) {
		count =0;
		
		back(numbers, 0,0,target); 
		
		return count;
	}
	private static void back(int[] numbers, int idx, int sum, int target) {
		if(numbers.length == idx) {
			if(target == sum) {
				count ++;
			}			
			return;
		}
		//더하기 먼저 시작
		back(numbers, idx+1, sum+numbers[idx], target);
		//뺄셈 먼저 시작
		back(numbers, idx+1, sum-numbers[idx], target);
	}


