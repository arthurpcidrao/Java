public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.print();
        stack.push(3);
        stack.print();
        stack.push(9);
        stack.print();
        stack.push(5);
        stack.print();

        System.out.println(stack.top());

        stack.pop();
        stack.print();
        System.out.println(stack.top());
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
