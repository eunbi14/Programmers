// 4 points 

import java.util.*;

class File implements Comparable<File>{  
    String head;
    int number;
    String tail;
    int index;

    public File(String head, int number, int index){
        this.head = head;
        this.number = number;
        this.index = index;
    }
    
    public int compareTo(File file){
        if(this.head.compareTo(file.head)<0) return -1;
        else if(this.head.equals(file.head)){
            if(this.number<file.number) return -1;
            else if(this.number==file.number){
                if(this.index<file.index) return -1;
                else return 1;
            }
            else return 1;
        }
        else return 1;
    }
}

class Solution {
    public String[] solution(String[] files) {
        File[] f = new File[files.length];
        for(int i=0;i<files.length;i++){
            String s = files[i];
            int number_start = -1;
            int tail_start = s.length();
            for(int j=1;j<s.length();j++){
                
                if(s.charAt(j)>=48&&s.charAt(j)<=57){
                    if(number_start==-1) number_start = j;
                }
                else if(number_start!=-1){
                    tail_start = j;
                    break;
                }
            }
            
            f[i] = new File(s.substring(0, number_start).toLowerCase(), Integer.valueOf(s.substring(number_start, tail_start)),  i);
        }
        
        Arrays.sort(f);
        String[] answer = new String[files.length];
    
        for(int i=0;i<files.length;i++){
            answer[i] = files[f[i].index];
            
        }
        
        return answer;
    }
}
