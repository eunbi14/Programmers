// 1 point

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] answer = new int[N][N];
        answer[0][0] = triangle[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0) answer[i][j] = answer[i-1][0] + triangle[i][j];
                else answer[i][j] = Math.max(answer[i-1][j-1], answer[i-1][j]) + triangle[i][j];
            }
        }
        
        int out = 0;
        for(int i=0;i<N;i++){
            out = out>answer[N-1][i]?out:answer[N-1][i];
        }
        return out;
        // return Arrays.stream(answer[N-1]).max().getAsInt();
        // for문 안돌리고 이렇게 쓸 수도 있다 근데 for문이 더 빠른듯
    }
}
