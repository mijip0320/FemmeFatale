package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/17677
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pro_뉴스클러스터링_mijip0320 {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>(); //두 문자, 문자가 나온 횟수 기
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Pattern pattern = Pattern.compile("[^A-Za-z]"); //영문자 이외에 모든 문자를 제거
        Matcher match = null;
        int totalCnt = 0;
        for(int i = 0; i <= str1.length()-2; i++){
            String key = str1.substring(i, i+2);
            match = pattern.matcher(key); //대상문자열이 영문인지 아닌지 검증
            if(match.find()) continue; //영문 아닌게 있다면 continue;
            map1.put(key, map1.getOrDefault(key, 0) + 1);
            totalCnt++;
        }

        for(int i = 0; i <= str2.length()-2; i++){
            String key = str2.substring(i, i+2);
            match = pattern.matcher(key);
            if(match.find()) continue;
            map2.put(key, map2.getOrDefault(key, 0) + 1);
            totalCnt++;
        }
//둘 중 하나의 맵을 순회하면서 다른 맵의 동일한 key가 있는지 체크하여, 동일한 key가 있으면 value의 Min값의 합을 구함
        int interCnt = 0;
        for(String key : map1.keySet()){
            if(map2.get(key) == null) continue;
            interCnt += Math.min(map2.get(key), map1.get(key));
        }

        //합집합 = 전체 원소 개수 - 교집합 원소 개수
        //공집합일 경우 65536
        int unionCnt = totalCnt - interCnt;
        if(unionCnt == 0) answer = 65536;
        answer = interCnt*65536/unionCnt;
        System.out.println(answer);
    }
}
