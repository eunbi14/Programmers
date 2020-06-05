package hash;
import java.util.*;

public class Incomplete_Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programmers 9 Points
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
        Map<String, Integer> com = new HashMap<>();
        for(int i=0;i<completion.length;i++) {
        	String s = completion[i];
        	if(com.containsKey(s)) com.put(s, com.get(s)+1);
        	else com.put(s, 1); 
        	//com.put(s, com.getOrDefault(s, 0)+1);
        	//위의 if-else문을 이거 한줄로 표현 가능
        }
        
        for(int i=0;i<participant.length;i++) { 
        //for(String s : participant)
        //participant 배열에 있는 스트링 자동으로 해줌 index로 접근 안해도 된다.
        	String s = participant[i];
        	if(com.containsKey(s)) {
        		if(com.get(s)==1) com.remove(s);
        		else com.put(s, com.get(s)-1);
        	}
        	else System.out.println(s);
        }
        System.out.println(participant[participant.length-1]);

	}

}
