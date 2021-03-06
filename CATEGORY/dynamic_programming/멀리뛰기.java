// 10 points
class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+1];
        if(n<=3) return n;
        for(int i=1;i<=3;i++) dp[i] = i;
  
        for(int i=4;i<=n;i++) dp[i] = (dp[i-1]+dp[i-2])%1234567;
     
        return dp[n] % 1234567;
    }
}