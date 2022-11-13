package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/87377
import java.util.*;

//① Ax+By+E=0
//② Cx+Dy+F=0
//-----------------------
//① x= -(By+E)/A
//② x= -(Dy+F)/C
//1, 2번 식을 통해서 (By+E)*C=(Dy+F)*A
//(BC-AD)*y = (AF-CE)
//y=(AF-CE)/(BC-AD)

public class pro_교점에별만들기_mijip0320 {
    static long minx= Long.MAX_VALUE, miny= Long.MAX_VALUE;
    static long maxx= Long.MIN_VALUE, maxy= Long.MIN_VALUE;

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        String[] answer = {};
        HashSet<Point> pSet= new HashSet<>();

        //x= (bf-ed)/(ad-bc)
        //y= (ec-af)/(ad-bc)
        long x, y;
        for(int i=0; i<line.length-1; i++){
            long a= line[i][0];
            long b= line[i][1];
            long e= line[i][2];
            for(int j=i+1; j<line.length; j++){
                long c= line[j][0];
                long d= line[j][1];
                long f= line[j][2];

                long adbc= a*d-b*c;
                if(adbc==0) continue; //비교대상 직선과 평행함

                long bfed= b*f-e*d;
                if(bfed%adbc!=0) continue; //x가 정수가 아님

                long ecaf= e*c-a*f;
                if(ecaf%adbc!=0) continue; //y가 정수가 아님

                x= bfed/adbc;
                y= ecaf/adbc;
                pSet.add(new Point(x, y));

                minx= Math.min(minx, x); //구한 교점으로 x의 최댓값과, 최솟값, y의 최댓값과 최솟값을 갱신해나감
                miny= Math.min(miny, y);
                maxx= Math.max(maxx, x);
                maxy= Math.max(maxy, y);
            }
        }

        long height= maxy-miny+1;
        long width= maxx-minx+1;
        answer= new String[(int)height];
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<width; i++){
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        long nx, ny;
        for(Point p: pSet){
            ny= maxy-p.y;
            nx= p.x-minx;
            answer[(int)ny]= answer[(int)ny].substring(0, (int)nx)+"*"
                    +answer[(int)ny].substring((int)nx+1);
        }

        for(String s : answer){
            System.out.println(s);
        }

    }

    public static class Point{
        long x;
        long y;
        public Point(long x, long y){
            this.x= x;
            this.y= y;
        }
    }
}
