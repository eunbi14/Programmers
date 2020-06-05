package practice;

public class one_two_three나라의숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1; // n = 1~500,000,000
		System.out.println(solution(n));
	}

	 public static String solution(int n) {

	        int ten = n;
	        StringBuilder sb = new StringBuilder();
	        int r = 0;
	        while(ten>0){
	            r = ten % 3;
	         ten = ten / 3;
	            if(r==0){
	                ten--;
	                 sb.insert(0, "4");
	            }
	            else if(r==1) sb.insert(0, "1");
	            else sb.insert(0, "2");
	           
	        }
	        
	    
	        return sb.toString();
	    }
}
