import java.util.Stack;
public class Asst2 {
    Stack s1 = new Stack();
    Stack s2 = new Stack();
    // String deq;
    // int leftN,rightN;
    int sizeL,sizeR;
    public void pushL(String item) {
        s1.push(item);
        sizeL++;
    }
    public void pushR(String item) {
        s2.push(item);
        sizeR++;
    }
    public String popL() {
        sizeL--;
        return String.valueOf(s1.pop());
    }
    public String popR() {
        sizeR--;
        return String.valueOf(s2.pop());
    }
    public static void main(String[] args) {
        Asst2 a2 = new Asst2();
        a2.pushL("22");
        a2.pushL("2");
        a2.pushL("99");
        a2.pushR("7");
        a2.pushR("33");
        a2.pushR("88");
        System.out.println(a2.popL());
        System.out.println(a2.popL());
        System.out.println(a2.popR());
    }
}