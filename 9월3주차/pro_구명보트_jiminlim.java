public static int solution(int[] people, int limit) {

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int i =0 ;int j = people.length -1;
        int answer = 0;
        while (i<= j){
//            System.out.println();
            int weight = people[j];

            int sum = weight;
//            System.out.println(sum);
            while(sum <= limit){
                sum += people[i];
                if(sum <= limit) i++;
            }
            answer++;
            j--;
        }

        return answer;
    }
