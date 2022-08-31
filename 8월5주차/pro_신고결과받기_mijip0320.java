import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] answer = new int[id_list.length];
HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));

        for(String reportInfo : reportSet){
            String reporter = reportInfo.split(" ")[0];  // 신고 한 사람
            String reported = reportInfo.split(" ")[1];  // 신고 당한 사람
            reporterInfoMap.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            reporterInfoMap.get(reporter).add(reported);
            reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0)+1);
        }

        for (String reported : reportedCountInfoMap.keySet()){
            int reportedCount = reportedCountInfoMap.get(reported);
            if(reportedCount >= k){
                // 메일 발송 대상
                for(int i=0; i<id_list.length; i++){
                    if(reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}