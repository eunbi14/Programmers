package hash;
import java.util.*;

public class Phone_Number_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programmers 8 Points
		String[] phone_book = {"119","97674223","1195524421"};
		HashSet<String> prefix = new HashSet<>();
		for(String s : phone_book) prefix.add(s);
		Iterator<String> iter = prefix.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			for(int i=0;i<phone_book.length;i++) {
				if(s.equals(phone_book[i])) continue;
				else if(s.startsWith(phone_book[i])) {
					System.out.println("false");
					break;
				}
			}
		}
		System.out.println("true");
	}

}
