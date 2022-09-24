class Solution {
  public String solution(int n) {
      String answer = "수박";
      int i= n%2;//나머지
      int j= n/2;//나눗셈
     if(n==1){
      return "수";
     }else{
         for(int z=1;z<j;z++){
          answer=answer+"수박";
      }//System.out.println(i+","+j+","+answer);
     }
      
      if(i==0){//짝수
          return answer;
      }else{//홀수
          answer=answer+"수";
          return answer;
      }
      
      
  }
}
