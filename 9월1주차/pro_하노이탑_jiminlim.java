public class 하노이탑 { 
 public static void main(String[] args) { 
 Scanner scanner=new Scanner(System.in);
 int num; //원판 갯수 
 num=scanner.nextInt(); 
 hanoi(1,2,3,num); 
 } 
 public static void hanoi(int from,int m,int to,int num){//from -> to 로 원판num이 이동 
 if(num==0)
 return; 
 hanoi(from,to,m,num-1); // 원판num-1은 from -> m으로 이동
 System.out.printf("%d : %d -> %d\n",num,from,to);//원판num이 from -> to 이동 
 hanoi(m,from,to,num-1); // 원판num-1이 m -> to로 이동
} 
}
