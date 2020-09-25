package stack_queue;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Arrays;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programmers 6 Points
		int[] priorities = {1, 1, 9 ,1, 1, 1};
		int location = 0;
		
		Queue<Integer> order = new LinkedList<>();
		for(int i=0;i<priorities.length;i++) order.offer(priorities[i]);
		int[] maxorder = priorities;
		Arrays.sort(maxorder);
		
		int n = maxorder.length-1; //maxorder index
		
		while(true) {
			int k = order.poll();
			if(k!=maxorder[n]) {
		
				order.offer(k);
	
				
				if(location!=0) location--;
				else location = order.size()-1;
			}
			else {
		
				if(location!=0) location--;
				else {
					System.out.println(maxorder.length-n);
					break;
				}
				n--;
			}
		}
	}

}
