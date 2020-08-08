// 테스트케이스 11~15, 24, 27~29 통과 못 하는데 왠지 모르겠다.
// operand ArrayList Type Integer -> Long 변경 후 해결

import java.util.*;

class Solution {
    public static ArrayList<Long> or_operand = new ArrayList<>();
    public static ArrayList<Character> or_operator = new ArrayList<>();
    public static ArrayList<Long> operand = new ArrayList<>();
    public static ArrayList<Character> operator = new ArrayList<>();
    public long solution(String expression) {
        
        int index = 0;
        for(int i=0;i<expression.length();i++){
            switch(expression.charAt(i)){
                case '*': case '+': case '-': 
                    or_operand.add(Long.parseLong(expression.substring(index, i)));
                    index = i+1;
                    or_operator.add(expression.charAt(i));
                    break;
            }
        }
        or_operand.add(Long.parseLong(expression.substring(index)));
        operator.addAll(or_operator);
        operand.addAll(or_operand);
        long answer = 0;
        cal('*', '+', '-');
        answer = operand.get(0);
        operand.remove(0);
        operand.addAll(or_operand);
operator.addAll(or_operator);
  if(operator.indexOf('-')!=-1&&operator.indexOf('+')!=-1){
      cal('*', '-', '+');
        answer = Math.max(Math.abs(answer), Math.abs(operand.get(0)));
        operand.remove(0);
    operator.addAll(or_operator);
        operand.addAll(or_operand);
  }
        
        
        cal('+', '*', '-');
        answer = Math.max(Math.abs(answer), Math.abs(operand.get(0)));
        operand.remove(0);
        operand.addAll(or_operand);
        operator.addAll(or_operator);
        cal('+', '-', '*');
        answer = Math.max(Math.abs(answer), Math.abs(operand.get(0)));
        operand.remove(0);
        operand.addAll(or_operand);
    operator.addAll(or_operator);
        cal('-', '*', '+');
  
       
        answer = Math.max(Math.abs(answer), Math.abs(operand.get(0)));
        operand.remove(0);
        operand.addAll(or_operand);
        operator.addAll(or_operator);
        cal('-', '+', '*');
        answer = Math.max(Math.abs(answer), Math.abs(operand.get(0)));
    
        return answer;
    }
    
    public void cal(char a, char b, char c){
        order(a);
        order(b);
        order(c);
        
    }
    
    public void order(char a){
        switch(a){
            case '*': 
                mul();
                break;
            case '+':
                plus();
                break;
            case '-':
                minus();
                break;
        }
    }
    
    public void mul(){
    
        int index = operator.indexOf('*');

        if(index==-1) return;
        while(index!=-1){
            operand.set(index, operand.get(index)*operand.get(index+1));

            operand.remove(index+1);
 
            operator.remove(index);
            index = operator.indexOf('*');
    
        }
    }
    
    public void plus(){
        int index = operator.indexOf('+');
        if(index==-1) return;
        while(index!=-1){
            operand.set(index, operand.get(index)+operand.get(index+1));
            operand.remove(index+1);
            operator.remove(index);
            index = operator.indexOf('+');
        }
    }
    
    public void minus(){
        int index = operator.indexOf('-');
        if(index==-1) return;
        while(index!=-1){
            operand.set(index, operand.get(index)-operand.get(index+1));
            operand.remove(index+1);
            operator.remove(index);
            index = operator.indexOf('-');
        }
    }
}
