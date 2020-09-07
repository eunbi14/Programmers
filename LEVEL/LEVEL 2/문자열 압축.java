// 4 points

class Solution {
    public int solution(String s) {
        int answer = s.length();
 
        
        for(int unit=1;unit<=s.length()/2;unit++){
            String repeat ="";
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i+=unit){
                if(count==0) {
                    if(i+unit>s.length()) repeat = s.substring(i);
                    else repeat = s.substring(i, i+unit);
                    count++;
                }
                else {
                    if((i+unit>s.length()&&s.substring(i).equals(repeat))||(i+unit<=s.length()&&s.substring(i, i+unit).equals(repeat))) count++;
                    else {
                        if(count==1) sb.append(repeat);
                        else {
                            sb.append(Integer.toString(count));
                            sb.append(repeat);
                        }
                        if(i+unit>s.length()) repeat = s.substring(i);
                        else repeat = s.substring(i, i+unit);
                        count = 1;
                    }
                }

            }
            
            if(count==1) sb.append(repeat);
            else {
                sb.append(Integer.toString(count));
                sb.append(repeat);
            }
            
         
            if(sb.toString().length()<answer) {
             
                answer = sb.toString().length();
            }
        }
        
        return answer;
    }
}
