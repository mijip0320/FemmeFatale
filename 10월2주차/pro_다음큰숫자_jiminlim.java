class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int one_num =0;
        int len = binary.length();
        for(int i=0; i<len; i++){
            if(binary.charAt(i)=='1') one_num ++;
        }

        //계속 돌아
        int next = n;
        while(true){
            next++;
            //System.out.println(next);
            if(next == 1000000){
                break;
            }       

            int next_cnt = 0;
            String next_str = Integer.toBinaryString(next);
            int l = next_str.length();
            for(int i=0; i<l; i++){
                if(next_str.charAt(i)=='1') next_cnt ++;
            }
            //System.out.println(next_cnt+" "+one_num);
            if(next_cnt == one_num) break;
        }

        int answer = next;
        return answer;
    }
}
