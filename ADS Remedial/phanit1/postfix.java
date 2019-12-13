import java.util.*;
public class postfix {
    public static int evaluatePostfix(String exp) {
        int result;
        Stack stack = new Stack();   
        for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);
        if (ch >= '0' && ch <= '9') {
            stack.push(ch);
        } else {
            int n1 = Integer.parseInt(""+stack.pop());
            int n2 = Integer.parseInt(""+stack.pop());
            switch (ch) {
                case '+':
                stack.push(n1 + n2);
                break;
                case '-':
                stack.push(n1 - n2);
                break;
                case '*':
                stack.push(n1 * n2);
                break;
                case '/':
                stack.push(n1 / n2);
                break;
            }
        }
    }
    result = Integer.parseInt("" + stack.pop());
    return result;
    }
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter postfix expression:");
    String expression = scan.next();
    System.out.println("Evaluated Expression result:"+evaluatePostfix(expression));
    }
}