package kakao;

import java.util.Stack;
//4 Points
public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int[] index = new int[board.length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][i]!=0) {
                    index[i] = j;
                    break;
                }
                if(j==board.length-1) index[i] = j+1;
            }
        }
        
        int answer = 0;
        for(int i=0;i<moves.length;i++){
            int location = moves[i] - 1;
            if(index[location]<board.length){
                int new_block = board[index[location]][location];
           
                if(!basket.isEmpty()&&basket.peek()==new_block) {
                    basket.pop();
                    answer += 2;
                }
                else basket.push(new_block);
             
            
                board[index[location]][location] = 0;
                index[location]++;
                
            }
        }

        return answer;
    }
}
