package stack_queue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Truck_Passing_Bridge {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programmers 9 Points
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		Queue<Integer> wait = new LinkedList<Integer>();
		for(int i=0;i<truck_weights.length;i++) {
			wait.add(i);
		}
		
		ArrayList<Integer> on = new ArrayList<Integer>();
		on.add(0, 1);
		wait.poll();
		int time = 1;
		int pre_weight = truck_weights[0];
		int arrive = 0;
		
		while(!wait.isEmpty()) {
			time++;
			for(int i=arrive;i<on.size();i++) {
				int n = on.get(i);
				on.set(i, n+1);
				if(n+1>bridge_length) {
					arrive++;
					pre_weight = pre_weight - truck_weights[i];
				}
				
			}
			int k = truck_weights[wait.peek()]+pre_weight;
			if(k<=weight) {
				on.add(wait.poll(), 1);
				pre_weight = k;
			}else continue;
			
		}
		
		while(arrive!=truck_weights.length) {
			time++;
			for(int i=arrive;i<on.size();i++) {
				int n = on.get(i);
				on.set(i, n+1);
				if(n+1>bridge_length) arrive++;	
			}
		}
	
		System.out.println(time);
	}


    

}

