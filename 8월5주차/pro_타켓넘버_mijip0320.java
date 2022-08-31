class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target){
        
        dfs(numbers, target, 0);
        return answer;
    }
    public static void dfs(int[] numbers, int target, int index){
       if(index == numbers.length){
           int sum = 0;
           for(int i : numbers){
               sum += i;
           }
           
           if(sum == target){
               answer++;
           }
           
       }else{
            numbers[index] *= 1;
            dfs(numbers, target, index+1);
            
            numbers[index] *= -1;
            dfs(numbers, target, index+1);
       }
    }
}