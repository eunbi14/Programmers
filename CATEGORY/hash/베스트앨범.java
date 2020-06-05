package hash;
//7 Points
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		solution(genres, plays);
	}
	
	 public static int[] solution(String[] genres, int[] plays) {
	        HashMap<String, ArrayList<Integer>> genres_list = new HashMap<>(); //장르별로 재생횟수 모아놓기
	        HashMap<String, Integer> genres_sum = new HashMap<>(); //장르별로 총 재생횟수 합
	  
	        for(int i=0;i<genres.length;i++){
	            if(!genres_list.containsKey(genres[i])) genres_list.put(genres[i], new ArrayList<Integer>());
	            genres_list.get(genres[i]).add(plays[i]);
	            genres_sum.put(genres[i], genres_sum.getOrDefault(genres[i], 0)+plays[i]);
	        }
	        @SuppressWarnings("rawtypes")
	        Iterator it = sortByValue(genres_sum).iterator();
	        ArrayList<Integer> list = new ArrayList<>();
	        ArrayList<Integer> answer = new ArrayList<>();
	        while(it.hasNext()){
	            String s = (String)it.next();
	            list = genres_list.get(s);
	            Collections.sort(list);

	            Collections.reverse(list);
	            
	            int num = list.get(0);
	            int first = -1;
	            for(int i=0;i<plays.length;i++){
	                if(plays[i]==num&&genres[i].equals(s)) {
	                    answer.add(i);
	                    first = i;
	                    break;
	                }
	            }
	       
	            if(list.size()>1) {
	                num = list.get(1);
	                for(int i=0;i<plays.length;i++){
	                    if(first!=i&&plays[i]==num&&genres[i].equals(s)) answer.add(i);
	                }
	            }
	        }
	        int[] answer_array = new int[answer.size()];
	        for(int i = 0;i<answer.size();i++){
	         
	            answer_array[i] = answer.get(i);
	        }
	        return answer_array;
	    }
	    
	    @SuppressWarnings("unchecked")
		public static List<String> sortByValue(final Map<String, Integer> map){
	        List<String> list = new ArrayList<String>();
	        list.addAll(map.keySet());
	        
	        Collections.sort(list, new Comparator<Object>(){
	            public int compare(Object o1, Object o2){
	                Object v1 = map.get(o1);
	                Object v2 = map.get(o2);
	                return ((Comparable<Object>)v2).compareTo(v1);
	            }
	        });
	 

	        return list;
	    }

}
