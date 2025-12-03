import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> cards;
    public CardStack() { cards = new LinkedList<Card>(); }

    public void printCards() {
        ListIterator<Card> iterator = cards.listIterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public int size() { return cards.size(); }
    public void push(Card card) { cards.add(card); }
    public Card pop() { return cards.pop(); }
    public Card peek() { return cards.peek(); }
    public boolean isEmpty() { return cards.isEmpty(); }
}
