import java.util.*;

public class Part_21_Postfix_to_Infix {
    public static void main(String[] args) {
        // String postfix = "abc-*d/e+";
        String postfix = "264*8/+3-";
        String infix = getInfix(postfix);
        String prefix = getPrefix(postfix);
        float evaluation = evaluate(postfix);
        System.out.println("Infix Expression is: " + infix);
        System.out.println("Prefix Expression is: " + prefix);
        System.out.println("Evaluation is: " + evaluation);
    }

    public static String getInfix(String str) {
        Stack<String> infix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (infix.size() > 1) {
                    operator.push(str.charAt(i));
                    String value2 = infix.pop();
                    String value1 = infix.pop();
                    String evaluation = "(" + value1 + String.valueOf(operator.peek()) + value2 + ")";
                    infix.push(evaluation);
                    operator.pop();
                    i++;
                } else {
                    operator.push(str.charAt(i));
                    i++;
                }
            } else {
                infix.push(String.valueOf(str.charAt(i)));
                i++;
            }
        }

        while (operator.size() > 0) {
            if (infix.size() > 1) {
                String value2 = infix.pop();
                String value1 = infix.pop();
                String evaluation = "(" + value1 + String.valueOf(operator.peek()) + value2 + ")";
                infix.push(evaluation);
            }
        }
        String ans = infix.peek();
        return ans.substring(1, ans.length() - 1);
    }

    public static String getPrefix(String str) {
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (prefix.size() > 1) {
                    operator.push(str.charAt(i));
                    String value2 = prefix.pop();
                    String value1 = prefix.pop();
                    String evaluation = String.valueOf(operator.peek()) + value1 + value2;
                    prefix.push(evaluation);
                    operator.pop();
                    i++;
                } else {
                    operator.push(str.charAt(i));
                    i++;
                }
            } else {
                prefix.push(String.valueOf(str.charAt(i)));
                i++;
            }
        }

        while (operator.size() > 0) {
            if (prefix.size() > 1) {
                String value2 = prefix.pop();
                String value1 = prefix.pop();
                String evaluation = String.valueOf(operator.peek()) + value1 + value2;
                prefix.push(evaluation);
            }
        }
        return prefix.peek();
    }

    public static float evaluate(String str) {
        Stack<Float> values = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                if (values.size() > 1) {
                    operator.push(str.charAt(i));
                    float value2 = values.pop();
                    float value1 = values.pop();
                    float evaluation = 0;
                    if (str.charAt(i) == '+') {
                        evaluation = value1 + value2;
                    } else if (str.charAt(i) == '-') {
                        evaluation = value1 - value2;
                    } else if (str.charAt(i) == '*') {
                        evaluation = value1 * value2;
                    } else if (str.charAt(i) == '/') {
                        evaluation = value1 / value2;
                    }
                    values.push(evaluation);
                    operator.pop();
                    i++;
                } else {
                    operator.push(str.charAt(i));
                    i++;
                }
            } else {
                String myString = String.valueOf(str.charAt(i));
                Float myFloat = Float.parseFloat(myString);
                values.push(myFloat);
                i++;
            }
        }

        while (operator.size() > 0) {
            if (values.size() > 1) {
                float value2 = values.pop();
                float value1 = values.pop();
                float evaluation = 0;
                if (str.charAt(i) == '+') {
                    evaluation = value1 + value2;
                } else if (str.charAt(i) == '-') {
                    evaluation = value1 - value2;
                } else if (str.charAt(i) == '*') {
                    evaluation = value1 * value2;
                } else if (str.charAt(i) == '/') {
                    evaluation = value1 / value2;
                }
                values.push(evaluation);
                operator.pop();
            }
        }
        return values.peek();
    }
}
