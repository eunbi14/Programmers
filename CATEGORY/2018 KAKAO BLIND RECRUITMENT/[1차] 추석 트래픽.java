import java.io.*;
import java.text.*;
import java.util.*;

class Solution {
    //7 points
    // B 부분 없으면 테스트 2,3 실패
    // 시작시간 기준(A)은 왜 안 잡아줘도 되는건지
    // B가 왜 필요한지
    public int solution(String[] lines) {
        int answer = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date[] endTime = new Date[lines.length];
        Date[] startTime = new Date[lines.length];
        for(int i=0;i<lines.length;i++){
            try{
                String[] line = lines[i].split(" ");
                String end = line[0]+" "+line[1];
                endTime[i] = format.parse(end);
                int procMilli = (int) (Double.parseDouble(line[2].substring(0, line[2].length()-1)) * -1000);
                startTime[i] = addMilli(endTime[i], procMilli+1);
            } catch(ParseException e){
                e.printStackTrace();
            }
        }
     
        for(int i=0;i<lines.length;i++){
            /*
            // A
            long s = startTime[i].getTime();
            long e = addMilli(startTime[i], 1000).getTime();
            System.out.println("start "+i+" : "+s);
            System.out.println("end "+i+" : "+e);
            int count = 0;
            for(int j=0;j<lines.length;j++){
                long stLong = startTime[j].getTime();
                long etLong = endTime[j].getTime();
                 if(e<=stLong) continue;
                if(stLong>=s&&stLong<e) count++;
                else if(etLong>=s&&etLong<e) count++;    
            }
            if(answer<count) answer = count;
            */
            
            long s = endTime[i].getTime();
            long e = addMilli(endTime[i], 1000).getTime();
            int  count = 0;
            for(int j=0;j<lines.length;j++){
                long stLong = startTime[j].getTime();
                long etLong = endTime[j].getTime();
                if(e<=stLong) continue;
                if(stLong>=s&&stLong<e) count++;
                else if(etLong>=s&&etLong<e) count++;  
                // B
                else if(stLong<=s&&etLong>s) count++;
                
            }
            if(answer<count) answer = count;
        }
        
        return answer;
    }
    
    public Date addMilli(Date date, int milli){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, milli);
        return c.getTime();
    }
}