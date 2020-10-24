// 4 points

import java.util.*;

class Location{
    int x1, y1, x2, y2;
    public Location(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }
}
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0, arr.length, arr.length));
        while(!q.isEmpty()){
            Location size = q.poll();
            
            boolean flag = false;
            int std = arr[size.x1][size.y1];
            for(int i=size.x1;i<size.x2;i++){
                for(int j=size.y1;j<size.y2;j++){
                    if(arr[i][j]!=std) {
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            
            if(!flag) answer[std]++;
            else{
                q.add(new Location(size.x1, size.y1, (size.x1+size.x2)/2, (size.y1+size.y2)/2));
                q.add(new Location(size.x1, (size.y1+size.y2)/2, (size.x1+size.x2)/2, size.y2));
                q.add(new Location((size.x1+size.x2)/2, size.y1, size.x2, (size.y1+size.y2)/2));
                q.add(new Location((size.x1+size.x2)/2, (size.y1+size.y2)/2, size.x2, size.y2));
            }
            
            
        }
        
        
        return answer;
    }
}
