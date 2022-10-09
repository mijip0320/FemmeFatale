public static int[] solution(int[] fees, String[] records) {
        int default_time =fees[0], default_fee =fees[1],
                unit_time =fees[2], unit_fee=fees[3];
        ArrayList<int[]> list= new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>(); // save IN time
        HashMap<Integer,Integer> total = new HashMap<>(); // total calculation
        for(int i =0 ;i<records.length; i++){
            String[] str = records[i].split(" ");
            String[] timeArr = str[0].split(":");
            int time = (Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]));
            int number = Integer.parseInt(str[1]);
            if(str[2].equals("IN")){
                map.put(number,time);
            }else{//out
                int inTime = map.get(number);
                int duration = time - inTime;
                if(total.containsKey(number)){
                    duration += total.get(number);
                }
                total.put(number,duration);
                map.remove(number);
            }
        }

        int twentyThree = 23 * 60 + 59;
        //출차안한경우  23:59으로 계산
        if(map.size() > 0){
            for(int key : map.keySet()){
                int value = map.get(key);
                int duration = twentyThree - value;
                if(total.containsKey(key)){
                    duration += total.get(key);
                }
                total.put(key,duration);
            }
        }

        for(int key : total.keySet()){
            int value = total.get(key);
            //기본요금 + [ out - in /단위시간] * 추가요금
                int cost = default_fee;
                if (default_time < value) {
                    double cal = (double)(value-default_time)/unit_time;
                    cost += (int)Math.ceil(cal) * unit_fee;
                }
            list.add(new int[]{key,cost});
        }

        //정렬
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });

        //입력
        int[] answer = new int[list.size()];
        for(int i =0 ;i<list.size(); i++){
            int[] data = list.get(i);
            answer[i] = data[1];
        }

        return answer;
    }
