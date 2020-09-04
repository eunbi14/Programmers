// 6 points

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(times, n, times[times.length-1]);
     
    }
    
    long binarySearch(int[] times, int n, int max){
        long left = 1;
        long right = (long)max * (long)n;
        long mid = 0;
        long answer = Long.MAX_VALUE;
        while(left<=right){
            mid = (left + right) / 2;
            if(isPassed(times, n, mid)){
                answer = answer>mid?mid:answer;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        
        return answer;
    }
    
    public boolean isPassed(int[] times, int n, long mid){
        long amount = 0;
        for(int i : times) amount += (mid / i);
      
        if(amount>=n) return true;
        else return false;
    }
}
