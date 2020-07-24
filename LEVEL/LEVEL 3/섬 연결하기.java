import java.util.*;
// 8 points
class Build implements Comparable<Build>{
    int from;
    int to;
    int cost;
    int index;
    
    public Build(int from, int to, int cost, int index){
        this.from = from;
        this.to = to;
        this.cost = cost;
        this.index = index;
    }
    
    @Override
    public int compareTo(Build build) {
        if (this.cost < build.cost) {return -1;}
        else if (this.cost == build.cost) { return 0;}
        else { return 1; }
	}

}

class Solution {
    public int solution(int n, int[][] costs) {
        List<Build> up = new ArrayList<>();
        for(int i=0;i<costs.length;i++){
            up.add(new Build(costs[i][0], costs[i][1], costs[i][2], i));
        }
        Collections.sort(up);
        
        boolean[][] visit = new boolean[n][n];
        for(int i=0;i<visit.length;i++) visit[i][i] = true;
        int answer = 0;
        for(int i=0;i<up.size();i++){
            if(connect(visit)) break;
            int t = up.get(i).to;
            int f = up.get(i).from;
            
            int flag = 0;
            for(int j=0;j<visit.length;j++){
                if(visit[t][j]&&!visit[f][j]) {
                    visit[f][j] = true;
                    visit[j][f] = true;
                    flag = 1;
                    for(int k=0;k<visit.length;k++){
                        if(visit[k][f]){
                            visit[k][j] = true;
                            visit[j][k] = true;
                        }
                    }
                }
                if(visit[f][j]&&!visit[t][j]) {
                    visit[t][j] = true;
                    visit[j][t] = true;
                    flag = 1;
                    for(int k=0;k<visit.length;k++){
                        if(visit[k][t]){
                            visit[k][j] = true;
                            visit[j][k] = true;
                        }
                    }
                }
            }
            
            if(flag==1) {
                answer += up.get(i).cost;
                visit[f][t] = true;
                visit[t][f] = true;
            }
            else if(!visit[t][f]){
                answer += up.get(i).cost;
                visit[f][t] = true;
                visit[t][f] = true;
            }
            
        }

        
      
        return answer;
    }
    
    public boolean connect(boolean[][] visit){
        for(int i=0;i<visit.length;i++){
            for(int j=i+1;j<visit.length;j++){
                if(!visit[i][j]) return false;
            }
        }
        return true;
    }
}
