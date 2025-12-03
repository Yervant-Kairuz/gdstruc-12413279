public class PlayerLinkedList {
    private PlayerNode head;
    private int size = 0;

    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head.setPreviousPlayer(playerNode);
        head = playerNode;
        size++;
    }

    public void removeFront() {
        PlayerNode playerNode = head;
        head = playerNode.getNextPlayer();
        head.setPreviousPlayer(null);
        playerNode.setNextPlayer(null);
        size--;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    public boolean contains(Player player) {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) return true;
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getPlayer().equals(player)) return index;
            current = current.getNextPlayer();
            index++;
        }
        return -1; // -1 Meaning Non-Existent
    }

    public int getSize() {
        return size;
    }
}
