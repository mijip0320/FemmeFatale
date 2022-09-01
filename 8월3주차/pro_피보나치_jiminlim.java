private static int[] save;
	public static int solution(int n) {
		save= new int[100001];
		        
        return  pibo(n);
    }

	private static int pibo(int n) {
		if(n< 2) return n;
		if(save[n] != 0 ) return save[n] % 1234567;
		
		return  save[n] = (pibo(n-1) + pibo(n-2)) % 1234567;
	}
