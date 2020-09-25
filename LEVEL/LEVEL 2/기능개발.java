// 문제가 개편되었습니다. 이로 인해 함수 구성이나 테스트케이스가 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
//1 point
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int d = (100 - progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) d++;
            q.add(d);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int d = q.poll();
            int count = 1;
            while(!q.isEmpty()&&q.peek()<=d){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        int[] out = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            out[i] = answer.get(i);
        }
   
        return out;
    }
}
