// 5 points

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> s = new PriorityQueue<>();
        for(int i : scoville) s.add(Long.valueOf(i));
        int answer = 0;
      
        while(s.size()>1){
            if(s.peek()>=K) return answer;
            else {
                long a = s.poll();
                long b = s.poll();
                s.add(a + (b * 2));
                
                answer++;
                }

        }
        
        if(s.peek()>=K) return answer;
        else return -1;
    }
}