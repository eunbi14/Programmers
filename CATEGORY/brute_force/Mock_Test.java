package brute_force;

public class Mock_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5 Points
		int[] answers = {1,2,3,4,5};
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int one_answer = 0;
		int two_answer = 0;
		int three_answer = 0;
		
		for(int i=0;i<answers.length;i++) {
			int a = answers[i];
			if(a==one[i%5]) one_answer++;
			if(a==two[i%8]) two_answer++;
			if(a==three[i%10]) three_answer++;
		}
		
		int max = Math.max(one_answer, two_answer);
		max = Math.max(max, three_answer);
		
		String ans = "";
		if(one_answer==max) ans ="1";
		if(two_answer==max) ans = ans+"2";
		if(three_answer==max) ans= ans+"3";
		
		String[] str_answer = ans.split("");
		int[] answer = new int[str_answer.length];
		for(int i=0;i<str_answer.length;i++) answer[i] = Integer.parseInt(str_answer[i]);
		System.out.println(answer[0]);
	}

}
