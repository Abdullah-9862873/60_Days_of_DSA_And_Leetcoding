
/*
---> There are three ways in which mathematical expressions are denoted
1) Infix Representation
2) Prefix Representation
3) Postfix Representation

Infix is a type of denotion that humans use while prefix and postfix are the types of denotions that machine use to evaluate the answer...

Example: Infix Expression => a*(b-c)/d+e

There is an expression tree that is made to convert the infix to prefix and postfix


                                    '+'
                                   / \
                                  '/' 'e'
                                 / \
                                '*' 'd'
                               /  \
                              'a'  '-'
                                   / \
                                'b'  'c'

Now from this expression tree we can make the prefix and postfix expression of the infix expression

To make prefix---> Eular tour the tree and when any thing ecounters from left then write it
Prefix -----------------> +/*a-bcde
Prefix -----------------> Operators before operands

To make Postfix---> Eular tour the tree and when anything encounters from right then write it
Postfix ----------------> a*bc-*d/e+
Postfix -----------------> Operands before Operators


Hint to preform the conversion
------> Infix ---> a+b
------> Prefix ---> +ab
------> Postfix ---> ab+

Apply the same rules of infix evaluation and you are good to go
*/
import java.util.*;

public class Part_17_Infix_Conversions {
    public static void main(String[] args) {
        // String infix = "a*(b-c)/d+e";
        String infix = "2+(6*4)/8-3";
        String prefix = getPrefix(infix);
        String postfix = getPostfix(infix);
        System.out.println("Prefix Expression is: " + prefix);
        System.out.println("Postfix Expression is: " + postfix);
    }

    public static String getPrefix(String str) {
        Stack<String> prefix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'
                    || str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (operators.size() == 0 || str.charAt(i) == '(') {
                    operators.push(str.charAt(i));
                    i++;
                } else {
                    if (str.charAt(i) == '+') {
                        if (operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/') {
                            if (prefix.size() > 1) {
                                String value2 = prefix.pop();
                                String value1 = prefix.pop();
                                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                                prefix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '-') {
                        if (operators.peek() == '+' || operators.peek() == '*' || operators.peek() == '/') {
                            if (prefix.size() > 1) {
                                String value2 = prefix.pop();
                                String value1 = prefix.pop();
                                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                                prefix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '*') {
                        if (operators.peek() == '/') {
                            if (prefix.size() > 1) {
                                String value2 = prefix.pop();
                                String value1 = prefix.pop();
                                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                                prefix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '/') {
                        if (operators.peek() == '*') {
                            if (prefix.size() > 1) {
                                String value2 = prefix.pop();
                                String value1 = prefix.pop();
                                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                                prefix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == ')') {
                        while(operators.peek() != '('){
                            if(prefix.size() > 1){
                                String value2 = prefix.pop();
                                String value1 = prefix.pop();
                                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                                prefix.push(evaluation);
                                operators.pop();
                            }
                        }
                        operators.pop();
                        i++;
                    }
                }
            } else {
                prefix.push(String.valueOf(str.charAt(i)));
                i++;
            }
        }
        while(operators.size() > 0){
            if(prefix.size() > 1){
                String value2 = prefix.pop();
                String value1 = prefix.pop();
                String evaluation = String.valueOf(operators.peek()) + value1 + value2;
                prefix.push(evaluation);
                operators.pop();
            }
        }
        return prefix.peek();
    }

    public static String getPostfix(String str) {
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'
                    || str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (operators.size() == 0 || str.charAt(i) == '(') {
                    operators.push(str.charAt(i));
                    i++;
                } else {
                    if (str.charAt(i) == '+') {
                        if (operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/') {
                            if (postfix.size() > 1) {
                                String value2 = postfix.pop();
                                String value1 = postfix.pop();
                                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                                postfix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '-') {
                        if (operators.peek() == '+' || operators.peek() == '*' || operators.peek() == '/') {
                            if (postfix.size() > 1) {
                                String value2 = postfix.pop();
                                String value1 = postfix.pop();
                                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                                postfix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '*') {
                        if (operators.peek() == '/') {
                            if (postfix.size() > 1) {
                                String value2 = postfix.pop();
                                String value1 = postfix.pop();
                                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                                postfix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == '/') {
                        if (operators.peek() == '*') {
                            if (postfix.size() > 1) {
                                String value2 = postfix.pop();
                                String value1 = postfix.pop();
                                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                                postfix.push(evaluation);
                                operators.pop();
                                continue;
                            }
                        } else {
                            operators.push(str.charAt(i));
                            i++;
                        }
                    } else if (str.charAt(i) == ')') {
                        while(operators.peek() != '('){
                            if(postfix.size() > 1){
                                String value2 = postfix.pop();
                                String value1 = postfix.pop();
                                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                                postfix.push(evaluation);
                                operators.pop();
                            }
                        }
                        operators.pop();
                        i++;
                    }
                }
            } else {
                postfix.push(String.valueOf(str.charAt(i)));
                i++;
            }
        }
        while(operators.size() > 0){
            if(postfix.size() > 1){
                String value2 = postfix.pop();
                String value1 = postfix.pop();
                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                postfix.push(evaluation);
                operators.pop();
            }
        }
        return postfix.peek();
    }
}
