 public static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int len = words.length;
        //첫번쨰
        if(words[0].length() == 1) return new int[]{1,1};
        Character before = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        //두번쨰
        boolean stop_flag = false;
        int play_time = 1;
        int player = 2;
        for(int i = 1; i<len; i++){

            //단어 크기
            if(words[i].length() == 1) {
                stop_flag = true;
//                System.out.println("1");
                break;
            }
            //말 잇기
            if(before!= words[i].charAt(0)){
                stop_flag = true;
//                System.out.println("2");
                break;
            }
            //중복 체크
            if(set.contains(words[i])){
                stop_flag = true;
//                System.out.println("3");
                break;
            }
//            System.out.println(play_time+" "+player);
            if(player == n){
                play_time ++;
                player = 1;
            }else {
                player++;
            }
            before =  words[i].charAt(words[i].length()-1);
            set.add(words[i]);
        }
//        System.out.println(play_time+" "+player+" 000000");
        if(!stop_flag){
            return new int[]{0,0};
        }
        return new int[]{player, play_time};
    }
