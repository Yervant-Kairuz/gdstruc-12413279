public class CardNode {
    private Card card;
    private CardNode next;
    private CardNode prev;

    public CardNode getPrev() {
        return prev;
    }

    public void setPrev(CardNode prev) {
        this.prev = prev;
    }

    public CardNode(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardNode getNext() {
        return next;
    }

    public void setNext(CardNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + card;
    }
}
