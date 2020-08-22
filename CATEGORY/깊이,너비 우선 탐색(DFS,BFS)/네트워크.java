//4 points

import java.util.*;

class Solution {
    static int[] network;
    static int answer = 1;
    public int solution(int n, int[][] computers) {
        
        network = new int[n];
        for(int i=0;i<n;i++){
            if(network[i]!=0) continue;
            
            Queue<Integer> q = new LinkedList<>();
            bfs(i, q, computers);
            answer++;
        }
        
        for(int i=0;i<n;i++){
            if(network[i]==answer) return answer;
        }
        return answer-1;
    }
    
    public void bfs(int i, Queue q, int[][] computers){
        network[i] = answer;
        for(int j=0;j<computers[i].length;j++){
            if(i==j) continue;
           
            if(network[j]!=0) continue;
         
            if(computers[i][j]==1) q.offer(j);
        }
        
        if(!q.isEmpty()) bfs((int)q.poll(), q, computers);
        
    }
}