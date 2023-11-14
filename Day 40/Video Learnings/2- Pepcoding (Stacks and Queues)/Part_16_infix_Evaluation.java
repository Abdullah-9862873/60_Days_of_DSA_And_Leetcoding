/*
----> Assumptions
1) Expression is balanced
2) The only operators used are (+ - * /)
3) Opening and cloing brackets () can be used to show the precedence of operations
4) + and - have equal precedence which is less that * and / which have equal precedence
5) In two operators of equal precedence, the preference will be given to the left operation
6) All operands are single digit number

*/

import java.util.*;

public class Part_16_infix_Evaluation {
    public static void main(String[] args) {
        String str = "2+6*4/8-3";
        int ans = evaluateInfix(str);
        System.out.println(ans);
    }
    public static int evaluateInfix(String str){
        Stack<Character> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i=0;
        while(i < str.length()){
            if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*' || str.charAt(i) == '(' || str.charAt(i) == ')'){
                if(str.charAt(i) == '+'){
                    if(operator.peek() == '-'){
                        int first = operand.peek();
                        operand.pop();
                        int second = operand.peek();
                        operand.pop();
                        int evaluation = first - second;
                        operand.push(char(evaluation));
                    }
                }
            }else{
                operand.push(str.charAt(i));
            }
        }

        return 1;
    }
}
