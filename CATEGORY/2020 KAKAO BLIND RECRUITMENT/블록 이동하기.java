// 9 points

import java.util.*;

class Robot{
    int x1, y1, x2, y2;
    int count;
    
    public Robot(int x1, int y1,int x2,int y2,int count){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.count = count;
    }
}

class Solution {
    static int answer;
    static boolean flag;
    static boolean[][][][] visited;
    static boolean f;
    public int solution(int[][] board) {
        Queue<Robot> s = new LinkedList<>();
        int N = board.length;
        visited = new boolean[N][N][N][N];
       
        s.offer(new Robot(0, 0, 0, 1, 0));
       
        dfs(s, board);
        
       
        return answer;
    }
    
    public void dfs(Queue<Robot> s, int[][] board){
        
        if(flag) return;
        if(s.isEmpty())  return;
    
        Robot r = s.poll();
       
        while(!s.isEmpty()&&visited[r.x1][r.y1][r.x2][r.y2]){
            r = s.poll();  
        }
     
        int x1 = r.x1;
        int x2 = r.x2;
        int y1 = r.y1;
        int y2 = r.y2;

        visited[x1][y1][x2][y2] = true;
        int count = r.count;
        int N = board.length;
        if(x1==x2){
            if(y2+1<N&&board[x1][y2+1]==0) {
                if(x2==N-1&&y2+1==N-1) finish(count);
                if(!visited[x2][y2][x2][y2+1]) s.offer(new Robot(x2, y2, x2, y2+1, count+1));
            }
            if(y1-1>=0&&board[x1][y1-1]==0){
                if(!visited[x1][y1-1][x1][y1]) s.offer(new Robot(x1, y1-1, x1, y1, count+1));
            }
            if(x1+1<N&&board[x1+1][y1]==0&&board[x1+1][y2]==0) {
                if(x1+1==N-1&&y2==N-1) finish(count);
                if(!visited[x1+1][y1][x1+1][y2]) s.offer(new Robot(x1+1, y1, x1+1, y2, count+1));
                if(x1+1==N-1&&y2==N-1) finish(count);
                if(!visited[x2][y2][x1+1][y2]) s.offer(new Robot(x2, y2, x1+1, y2, count+1));
                if(x1+1==N-1&&y1==N-1) finish(count);
                if(!visited[x1][y1][x1+1][y1]) s.offer(new Robot(x1, y1, x1+1, y1, count+1));
            }
            if(x1-1>=0&&board[x1-1][y1]==0&&board[x2-1][y2]==0) {
                if(!visited[x1-1][y1][x2-1][y2]) s.offer(new Robot(x1-1, y1, x2-1, y2, count+1));
                if(!visited[x1-1][y2][x2][y2]) s.offer(new Robot(x1-1, y2, x2, y2, count+1));
                if(!visited[x2-1][y1][x1][y1]) s.offer(new Robot(x2-1, y1, x1, y1, count+1));
            }
        }
        else if(y1==y2){
            if(x2+1<N&&board[x2+1][y2]==0) {
                if(x2+1==N-1&&y2==N-1) finish(count);
                if(!visited[x2][y2][x2+1][y2]) s.offer(new Robot(x2, y2, x2+1, y2, count+1));
            }
            if(x1-1>=0&&board[x1-1][y1]==0){
                if(!visited[x1-1][y1][x1][y1]) s.offer(new Robot(x1-1, y1, x1, y1, count+1));
            }
            if(y1+1<N&&board[x1][y1+1]==0&&board[x2][y2+1]==0) {
                if(x2==N-1&&y2+1==N-1) finish(count);
                if(!visited[x1][y1+1][x2][y2+1]) s.offer(new Robot(x1, y1+1, x2, y2+1, count+1));
                if(x2==N-1&&y1+1==N-1) finish(count);
                if(!visited[x2][y2][x2][y1+1]) s.offer(new Robot(x2, y2, x2, y1+1, count+1));
                if(x1==N-1&&y1+1==N-1) finish(count);
                if(!visited[x1][y1][x1][y1+1]) s.offer(new Robot(x1, y1, x1, y1+1, count+1));
            }
            if(y1-1>=0&&board[x1][y1-1]==0&&board[x2][y2-1]==0){
                if(!visited[x1][y1-1][x2][y2-1]) s.offer(new Robot(x1, y1-1, x2, y2-1, count+1));
                if(!visited[x1+1][y2-1][x2][y2]) s.offer(new Robot(x1+1, y2-1, x2, y2, count+1));
                if(!visited[x2-1][y2-1][x1][y1]) s.offer(new Robot(x2-1, y2-1, x1, y1, count+1));
            }
        }
        
        dfs(s, board);
    }
    
    public void finish(int count){
        answer = count+1;
        flag = true;
    }
}