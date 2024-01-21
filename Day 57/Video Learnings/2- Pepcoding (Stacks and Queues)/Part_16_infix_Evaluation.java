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
        // String str = "2+(5-3*6/2)";
        float ans = evaluateInfix(str);
        System.out.println(ans);
    }

    public static float evaluateInfix(String str) {
        Stack<Float> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'
                    || str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (operator.size() == 0 || str.charAt(i) == '(') {
                    operator.push(str.charAt(i));
                    i++;
                } else {
                    if (str.charAt(i) == '+') {
                        if (operator.peek() == '-' || operator.peek() == '*' || operator.peek() == '/') {
                            if (operand.size() > 1) {
                                float value2 = operand.pop();
                                float value1 = operand.pop();
                                float evaluation = 0;
                                if (operator.peek() == '-') {
                                    evaluation = value1 - value2;
                                } else if (operator.peek() == '*') {
                                    evaluation = value1 * value2;
                                } else if (operator.peek() == '/') {
                                    evaluation = value1 / value2;
                                }
                                operand.push(evaluation);
                                operator.pop();
                                continue;
                            }
                        } else {
                            operator.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '-') {
                        if (operator.peek() == '+' || operator.peek() == '*' || operator.peek() == '/') {
                            if (operand.size() > 1) {
                                float value2 = operand.pop();
                                float value1 = operand.pop();
                                float evaluation = 0;
                                if (operator.peek() == '+') {
                                    evaluation = value1 + value2;
                                } else if (operator.peek() == '*') {
                                    evaluation = value1 * value2;
                                } else if (operator.peek() == '/') {
                                    evaluation = value1 / value2;
                                }
                                operand.push(evaluation);
                                operator.pop();
                                continue;
                            }
                        } else {
                            operator.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '*') {
                        if (operator.peek() == '/') {
                            if (operand.size() > 1) {
                                float value2 = operand.pop();
                                float value1 = operand.pop();
                                float evaluation = value1 / value2;
                                operand.push(evaluation);
                                operator.pop();
                                continue;
                            }
                        } else {
                            operator.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '/') {
                        if (operator.peek() == '*') {
                            if (operand.size() > 1) {
                                float value2 = operand.pop();
                                float value1 = operand.pop();
                                float evaluation = value1 * value2;
                                operand.push(evaluation);
                                operator.pop();
                                continue;
                            }
                        } else {
                            operator.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == ')') {
                        while (operator.peek() != '(') {
                            if (operand.size() > 1) {
                                float value2 = operand.pop();
                                float value1 = operand.pop();
                                float evaluation = 0;
                                if (operator.peek() == '+') {
                                    evaluation = value1 + value2;
                                } else if (operator.peek() == '-') {
                                    evaluation = value1 - value2;
                                } else if (operator.peek() == '*') {
                                    evaluation = value1 * value2;
                                } else if (operator.peek() == '/') {
                                    evaluation = value1 / value2;
                                }
                                operand.push(evaluation);
                            }
                            operator.pop();
                        }
                        operator.pop();
                        i++;
                    }
                }
            } else {
                String charAsString = String.valueOf(str.charAt(i));
                float myFloat = Float.parseFloat(charAsString);
                operand.push(myFloat);
                i++;
            }
        }

        while (operator.size() > 0) {
            if (operand.size() > 1) {
                float value2 = operand.pop();
                float value1 = operand.pop();
                float evaluation = 0;
                if (operator.peek() == '+') {
                    evaluation = value1 + value2;
                } else if (operator.peek() == '-') {
                    evaluation = value1 - value2;
                } else if (operator.peek() == '*') {
                    evaluation = value1 * value2;
                } else if (operator.peek() == '/') {
                    evaluation = value1 / value2;
                }
                operand.push(evaluation);
                operator.pop();
            }
        }
        return operand.peek();
    }
}