public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            answer[0]++;
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char d = s.charAt(i);
                if (d == '1') {
                    cnt++;
                } else
                    answer[1]++;
            }
            String str = "";
            for (int i = cnt; i > 0; i /= 2) {
                str = String.valueOf(i % 2) + str;
            }
            s = str;
        }
        return answer;
    }
