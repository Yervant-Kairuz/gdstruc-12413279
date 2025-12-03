void main() {
    LinkedStack stack = new LinkedStack();
    stack.push(new Player(1, "aceu", 100));
    stack.push(new Player(2, "Sinatraa", 100));
    stack.push(new Player(3, "Subroza", 95));
    stack.push(new Player(4, "ploo", 90));

    stack.printStack();

    System.out.println("\nPopping: " + stack.pop());

    stack.printStack();
}