import java.util.NoSuchElementException;

public class ArrayQueue {
    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
    }

    public void add(Player player) {
        // Resize if Full
        if (back == queue.length) {
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[back] = player;
        back++;
    }

    public Player remove() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) { // reset trackers when queue is empty
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
