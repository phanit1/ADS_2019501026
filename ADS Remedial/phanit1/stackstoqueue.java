import java.util.*;
public class stackstoqueue {
    Stack s1 = new Stack();
    Stack s2 = new Stack();
    public int deque() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int a = Integer.parseInt(String.valueOf(s2.pop()));
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return a;
    }
    public void push(int item) {
        s1.push(item);
    }
    public static void main(String[] args) {
        stackstoqueue sq = new stackstoqueue();
        sq.push(1);
        sq.push(3);
        sq.push(22);
        System.out.println(sq.deque());
    }
}