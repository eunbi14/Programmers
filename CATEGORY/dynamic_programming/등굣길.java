// 7 points

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] d = new long[n+1][m+1];

        for(int i=0;i<puddles.length;i++){
            d[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        d[1][1] = 1;
        for(int i=2;i<=m;i++) {
            if(d[1][i]==-1) break;
            d[1][i] = 1;
        }
        for(int i=2;i<=n;i++) {
            if(d[i][1]==-1) break;
            d[i][1] = 1;
        }
        
        for(int i=2;i<=n;i++){
            for(int j=2;j<=m;j++){
                if(d[i][j]==-1) continue;
                long left = d[i-1][j];
                long up = d[i][j-1];
                if(up==-1&&left==-1) d[i][j] = 0;
                else if(up==-1) d[i][j] = left;
                else if(left==-1) d[i][j] = up;
                else d[i][j] = left + up;
                d[i][j] %= 1000000007;
            }
        }
  
        return (int)d[n][m];
    }
}
