
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("./src/file/시험감독"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(tk.hasMoreTokens()) {
			list.add(Integer.parseInt(tk.nextToken()));			
		}
		tk = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(tk.nextToken());
		int C =Integer.parseInt(tk.nextToken());
		
		long result = list.size();
		
		for(int i =0 ;i<list.size(); i++) {
			int classCnt = list.get(i) - B;
			if(classCnt > 0) {
				result += classCnt / C;
				if(classCnt % C != 0) {
					result ++;
				}
			}
			
		}

		System.out.println(result);
	}

}
