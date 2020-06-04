package greedy;

public class 큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1924";
		int k = 2;
		solution(number, k);
	}

	public static String solution(String number, int k) {
        int size = number.length(); //4
        int start = 0;
        int end = k; 
        int count = size - k; //4-2 = 2
        StringBuilder sb = new StringBuilder();
        while(count>0){ //count=2
            int max = -1;
            for(int i=start ; i<=end;i++){
                if(max<number.charAt(i) - 48) {
                    max = number.charAt(i) - 48; //max = 9
                    start = i + 1; // start = 2
                }
            }
            sb.append(Integer.toString(max)); // sb = 9
            count--; //count = 1
            if(end<size-1) end++;
        }
        
        return sb.toString();
    }
}
