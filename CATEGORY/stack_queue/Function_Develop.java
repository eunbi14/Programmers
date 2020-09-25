package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Function_Develop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = {};
		
		Queue<Integer> day = new LinkedList<>();
		for(int i=0;i<progresses.length;i++) {
			if(progresses[i]%speeds[i]==0) day.add(progresses[i]/speeds[i]);
			else day.add(progresses[i]/speeds[i]+1);
		}
		
		int show = day.poll();
		int n = 1;
		int j = 0;
		
		while(!day.isEmpty()) {
			if(day.poll()<show) n++;
			else {
				answer[j] = n;
				n = 1;
				j++;
				if(day.size()>0) show = day.poll();
			}
		}
		
		answer[j] = n;
		
		System.out.println(answer);
	}

}
