//7 points

class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        //a b c d e f g h i j k l m
        //n o p q r s t u v w x y z
        //알파벳을 바꾸는 횟수
        for(int i=0;i<size;i++){
            char c = name.charAt(i);
            if(c<='M') answer += c - 'A';
            else answer += ('Z'-c+1);
        }
        
        int j = size - 1;
        int tmp = 0;
        int right = 0;
        int left = 0;
        
        //왼쪽으로 쭉 가기 ex. BABCD
        int move = size - 1;
        for(int i=1;i<size;i++){
            if(name.charAt(i)=='A') move--;
            else break;
        }
        
        //오른쪽으로 쭉 가기 ex. BCDAA
        int move2 = size - 1;
        for(int i=size-1;i>0;i--){
            if(name.charAt(i)=='A') move2--;
            else break;
        }
  
        //오른쪽으로 갔다가 다시 왼쪽으로 가기 ex. ABCAAB
        int move3 = 0;
        for(int i=1;i<=j;i++){
            if(name.charAt(i)=='A'&&name.charAt(j)!='A') {
                    move3++;
                    move3 += tmp;
                    j--;
                    tmp = 0;
                left++;
            }
            else if(name.charAt(i)=='A'&&name.charAt(j)=='A'){
                tmp++;
                j--;
                continue;
            }
            else {
                move3++;
                move3 += tmp;
                tmp = 0;
                right++;
                continue;
            }
        
        }
        
        if(right>0&&left>0) move3 += right;
        
        return answer + Math.min(Math.min(move, move2), move3);
    }
}
