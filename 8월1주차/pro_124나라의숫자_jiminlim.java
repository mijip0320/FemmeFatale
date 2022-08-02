public class pro_124나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(500000000));
    }
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int number = n;
        while(number > 0){
            if(number < 10){
                if(number == 0) break;
                int val = change124(number);
                sb.insert(0,val);
                break;
            }

            int mok = number/ 3;
            int num = number % 3;
//            System.out.println("------mok : "+mok+" num : "+num);
            if(num == 0) {
                mok -= 1;


                sb.insert(0,"4");
//                System.out.println(mok+" v : "+mok);
            }else{
                int val = change124(num);
                sb.insert(0,val);
//                System.out.println(mok+" v : "+val);
            }
            number = mok;
        }
        return sb.toString();
    }

    private static int change124(int mok) {
        switch (mok){
            case 1:
                mok = 1;
                break;
            case 2:
                mok = 2;
                break;
            case 3:
                mok = 4;
                break;
            case 4:
                mok = 11;
                break;
            case 5:
                mok = 12;
                break;
            case 6:
                mok = 14;
                break;
            case 7:
                mok = 21;
                break;
            case 8:
                mok = 22;
                break;
            case 9:
                mok = 24;
                break;
        }
        return mok;
    }
}
