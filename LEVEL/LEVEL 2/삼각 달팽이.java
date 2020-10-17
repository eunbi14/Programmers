// 1 point

class Solution {
    public static int num = 1;
    public static int[][] triangle;
    public int[] solution(int n) {
        triangle = new int[n][n];
   
        int index = 0;
        int count = (n*(n+1))/2;
        while(num<=count){
            int row = down(index, 2*index, n-index);
            if(num>count) break;
            right(row, index+1, row-index);
            if(num>count) break;
            up(row-index-1, row-1, 2*index);
            index++;
        }
        
        int[] answer = new int[count];
        index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(triangle[i][j]==0) break;
                answer[index] = triangle[i][j];
                index++;
            }
       
        }
        
        return answer;
    }
    
    public int down(int index, int start, int end){
        for(int i=start;i<end;i++){
            triangle[i][index] = num;
            num++;
        }
        return end-1;
    }
    
    public void right(int row, int start, int end){
        for(int i=start;i<=end;i++){
            triangle[row][i] = num;
            num++;
        }
    }
    
    public void up(int index, int start, int end){
        for(int i=start;i>end;i--){
            triangle[i][index] = num;
            num++;
            index--;
        }
    }
}
