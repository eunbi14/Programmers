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
        	//���� if-else���� �̰� ���ٷ� ǥ�� ����
        }
        
        for(int i=0;i<participant.length;i++) { 
        //for(String s : participant)
        //participant �迭�� �ִ� ��Ʈ�� �ڵ����� ���� index�� ���� ���ص� �ȴ�.
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
