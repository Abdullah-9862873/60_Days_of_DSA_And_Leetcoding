import java.util.*;

public class Part_37_Prefix_Evaluation_And_Convertion {
    public static void main(String[] args) {
        String str = "-+2/*6483";
        String postfix = getPostfix(str);
        String infix = getInfix(str);
        float evaluation = evaluate(str);
        System.out.println("Postfix Expression is: " + postfix);
        System.out.println("Infix Expression is: " + infix);
        System.out.println("Evaluation is: " + evaluation);
    }

    public static String getPostfix(String str) {
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                operators.push(str.charAt(i));
                if (postfix.size() > 1) {
                    String value1 = postfix.pop();
                    String value2 = postfix.pop();
                    String evaluation = value1 + value2 + String.valueOf(operators.peek());
                    operators.pop();
                    postfix.push(evaluation);
                    i--;
                }
            } else {
                postfix.push(String.valueOf(str.charAt(i)));
                i--;
            }
        }

        while (operators.size() > 0) {
            if (postfix.size() > 1) {
                String value1 = postfix.pop();
                String value2 = postfix.pop();
                String evaluation = value1 + value2 + String.valueOf(operators.peek());
                operators.pop();
                postfix.push(evaluation);
            }
        }
        return postfix.peek();
    }

    public static String getInfix(String str) {
        Stack<String> infix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                operators.push(str.charAt(i));
                if (infix.size() > 1) {
                    String value1 = infix.pop();
                    String value2 = infix.pop();
                    String evaluation = "(" + value1 + String.valueOf(operators.peek()) + value2 + ")";
                    operators.pop();
                    infix.push(evaluation);
                    i--;
                }
            } else {
                infix.push(String.valueOf(str.charAt(i)));
                i--;
            }
        }

        while (operators.size() > 0) {
            if (infix.size() > 1) {
                String value1 = infix.pop();
                String value2 = infix.pop();
                String evaluation = "(" + value1 + String.valueOf(operators.peek()) + value2 + ")";
                operators.pop();
                infix.push(evaluation);
            }
        }
        return infix.peek();
    }

    public static float evaluate(String str) {
        Stack<Float> operand = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                operators.push(str.charAt(i));
                if (operand.size() > 1) {
                    float val1 = operand.pop();
                    float val2 = operand.pop();

                    float evaluation = 0;
                    if (operators.peek() == '+') {
                        evaluation = val1 + val2;
                    } else if (operators.peek() == '-') {
                        evaluation = val1 - val2;
                    } else if (operators.peek() == '*') {
                        evaluation = val1 * val2;
                    } else if (operators.peek() == '/') {
                        evaluation = val1 / val2;
                    }
                    operand.push(evaluation);
                    operators.pop();
                    i--;
                }
            } else {
                String myString = String.valueOf(str.charAt(i));
                float myFloat = Float.parseFloat(myString);
                operand.push(myFloat);
                i--;
            }
        }

        while (operators.size() > 0) {
            if (operand.size() > 1) {
                float val1 = operand.pop();
                float val2 = operand.pop();

                float evaluation = 0;
                if (operators.peek() == '+') {
                    evaluation = val1 + val2;
                } else if (operators.peek() == '-') {
                    evaluation = val1 - val2;
                } else if (operators.peek() == '*') {
                    evaluation = val1 * val2;
                } else if (operators.peek() == '/') {
                    evaluation = val1 / val2;
                }
                operand.push(evaluation);
                operators.pop();
            }
        }
        return operand.peek();
    }
}
