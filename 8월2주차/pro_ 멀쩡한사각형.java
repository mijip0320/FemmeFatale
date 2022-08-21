class Solution {
    public static long solution(int w, int h) {
        
        //최대 공약수를 구해        
        int a = w; int b = h;
        if(a< b) {
        	a= h; b= w;
        }        
        
        long great  = gcd(a,b);
        
        //최대공약수안에서 대각선의 값은 
        long line = ((long)w/great)+((long)h/great) -1; // (a*b)-((a*b)-(a+b-1));
        
        //System.out.println(line +" "+great);
        return ((long) w * (long) h) - (line * great);
    }

	private static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a= b;
			b= r;
		}
		return a;
	}
}
