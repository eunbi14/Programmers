package brute_force;
//4 Points
public class 숫자야구 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}
	
	public static int solution(int[][] baseball) {
        int size = baseball.length;
        int answer = 0;
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(i==j) continue;
                for(int k=1;k<=9;k++){
                    if(i==k||j==k) continue;
  
                    for(int n=0;n<size;n++){
                        int number = baseball[n][0];
                        int hundred = number/100;
                        int ten = (number/10)%10;
                        int one = number%10;
                        //strike
                        int strike = 0;
                        if(hundred == i) {
                            strike++;
                            hundred = -1;
                        }
                        if(ten == j) {
                            strike++;
                            ten = -1;
                        }
                        if(one == k){
                            strike++;
                            one = -1;
                        }
                        if(strike!=baseball[n][1]) break;
                        //ball
                        int ball = 0;
                        if(hundred!=-1&&(hundred==i||hundred==j||hundred==k)) ball++;
                        if(ten!=-1&&(ten==i||ten==j||ten==k)) ball++;
                        if(one!=-1&&(one==i||one==j||one==k)) ball++;
                        if(ball!=baseball[n][2]) break;
                        if(n==size-1) answer++;
                     }
                }
            }
        }
        return answer;
    }

}
