public class Main {
    public static void main(String[] args) throws Exception {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(3);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(9);
        stack.print();
        stack.push(6);
        stack.print();
        stack.push(8);
        stack.print();

        System.out.println(stack.top());

        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
