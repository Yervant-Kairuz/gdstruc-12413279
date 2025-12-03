import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Player> stack;

    // Constructor
    public LinkedStack() { stack = new LinkedList<Player>(); }

    // Custom Functions
    public void printStack() {
        ListIterator<Player> iterator = stack.listIterator();

        System.out.println("\nPrinting Stack:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Stack Functions
    public void push(Player player) { stack.push(player); }
    public boolean isEmpty() {  return stack.isEmpty(); }
    public Player pop() { return stack.pop(); }
    public Player peek() { return stack.peek(); }
}
