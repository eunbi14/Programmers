package hash;

import java.util.HashMap;
import java.util.Iterator;

public class 위장{
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}

	private static int solution(String[][] clothes) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> closet = new HashMap<String, Integer>();
		int answer = 1;
		
		for(int i=0;i<clothes.length;i++) {
			if(closet.containsKey(clothes[i][1])) {
				closet.replace(clothes[i][1], closet.get(clothes[i][1])+1);
			}
			else {
				closet.put(clothes[i][1], 1);
			}
		}
		
		Iterator<Integer> it = closet.values().iterator();
		while(it.hasNext()) {
			answer = answer * (it.next() + 1);
		}
		
		return answer -1;
	}

}




/*
package hash;
// 5 Points
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class 위장 {
	static ArrayList<String> category = new ArrayList<String>();
	static HashMap<String, LinkedList<String>> closet = new HashMap<String, LinkedList<String>>();
	static  int answer = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"a","head"},{"b","head"},{"c","head"},{"d","eye"},{"f","eye"}, {"h","pants"}};
		
			//{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
			//{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
       
        for(int i=0;i<clothes.length;i++) {
        	if(closet.containsKey(clothes[i][1])) {
        		closet.get(clothes[i][1]).add(clothes[i][0]);
        	
        	}
        	else {
        		closet.put(clothes[i][1], new LinkedList<String>());
        		closet.get(clothes[i][1]).add(clothes[i][0]);
        		category.add(clothes[i][1]);
        	}
        }
        
        for(String s : category) {
        	answer = answer * (closet.get(s).size() + 1);
        }

        return answer -1;
    }

}

*/