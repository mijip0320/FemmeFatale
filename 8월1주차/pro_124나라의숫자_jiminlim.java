public class pro_124나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(500000000));
    }
     private static final String[] DIGIT = { "4", "1", "2" };
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){

            int index = n % 3;

            n /= 3;

            // 인덱스가 0일 경우
            if (index == 0)
            {
                n--;
            }

            sb.insert(0,DIGIT[index]);

        }
        return sb.toString();
    }
}
