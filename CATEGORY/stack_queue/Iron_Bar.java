package stack_queue;

import java.util.Stack;

public class Iron_Bar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programmers 7 points
		String arrangement = "()(((()())(())()))(())";
		int answer = 0;
		Stack<String> st = new Stack<>();
		arrangement = arrangement.replace("()", "r");
		
		String ir[] = arrangement.split("");
		
		for(int k=0;k<ir.length;k++) {
			st.add(ir[k]);
			if(ir[k].equals(")")) {
				String cut = "";
				while(!st.peek().equals("(")) {

					if(!st.peek().equals(")")) cut = cut+st.peek();
					st.pop();
				}
				st.pop();
				
				answer = answer+cut.length()+1;
				st.push(cut);
			}
		}
		
		System.out.println(answer);
		
	}

}
