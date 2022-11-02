import java.util.*;

class Solution {
    private int min,len ;
    static class Node{
        String value ; int dept;
        public Node(String value, int dept){
            this.value = value; this.dept= dept;
        }
    }
    public int solution(String begin, String target, String[] words) {
        min = Integer.MAX_VALUE;
        len = words.length;
        boolean[] visit = new boolean[len];
        
        //bfs로 풀어보자. 
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(begin,0));       
        
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.value.equals(target)){
                min= node.dept;
                break;
            }
            int count = 0;
            for(int i =0 ; i<len; i++){
                if(visit[i]) continue;
                
                if(isNext(node.value, words[i])){
                    visit[i] = true;                
                    que.offer(new Node(words[i], node.dept+1));
                }
            }
        }
        
        //dfs(begin, target,0,visit,words);
        return min== Integer.MAX_VALUE? 0 : min;
    }
    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }    
    public void dfs(String begin, String target, int cnt, boolean[] visit, String[] words){
        //System.out.println(cnt+" "+begin);
        if(begin.equals(target)){
            //System.out.println("equals"+ begin);
            min = Math.min(min, cnt);
            return;
        }
        if(cnt > len){
            return;
        }
        if(cnt > min) return;
        
        for(int i=0; i<len; i++){
            if(visit[i]) continue; // 안썼어.
            String word = words[i];
            int word_len= word.length();
            int count = 0;
            
           // System.out.println(word+" vs "+begin);
            for(int j = 0; j< word_len; j++){
                char begin_char = begin.charAt(j);
                char word_char = word.charAt(j);
                if(begin_char == word_char) count++;
            }
            
            if(count == (word_len -1)){
                visit[i] = true;                
                dfs(word, target, cnt+1, visit, words);
                visit[i] = false;
            }
        }
    }
}
