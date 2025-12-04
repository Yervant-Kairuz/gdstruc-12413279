void startMatch() {

}

void generatePlayers(ArrayQueue playerQueue, Random rand) {
    int newPlayers = rand.nextInt(7) + 1;
    for (int i = 0; i < newPlayers; i++) {
        int randomID =rand.nextInt(100) + 1;
        Player newPlayer = new Player(randomID, "player" + randomID, rand.nextInt(500) + 1);
        playerQueue.add(newPlayer);
        System.out.println("[SYSTEM]: Player " + newPlayer.getName() + " has been added to the queue");
    }
}

void main() {
//    ArrayQueue queue = new ArrayQueue(5);
//
//    queue.add(new Player(1, "aceu", 100));
//    queue.add(new Player(2, "Sinatraa", 100));
//    queue.add(new Player(3, "Subroza", 95));
//    queue.add(new Player(4, "ploo", 90));
//
//    queue.printQueue();
//    queue.add(new Player(5, "tenZ", 95));
//
//    System.out.println("\n── After adding element ──\n");
//    queue.printQueue();
//
//    System.out.println("\n── After popping element ──\n");
//    System.out.println("Popped: " + queue.remove());
//    queue.printQueue();

    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    ArrayQueue playerQueue = new ArrayQueue(10);
    int matchesStarted = 0;

    while (matchesStarted < 10) {
        System.out.println("── New Turn ──");
        generatePlayers(playerQueue, rand);

        System.out.println("── Current Queue ──");
        playerQueue.printQueue();

        System.out.println("\n\u001b[90mPress enter to continue\u001b[0m");
        scanner.nextLine();

        if (playerQueue.size() >= 5) {
            System.out.println("── Match " + ++matchesStarted + " Found ──");
            System.out.println("─ Players ─");
            for (int i = 0; i < 5; i++) {
                System.out.print(playerQueue.remove().getName() + " ");
            }

            System.out.println("\n\u001b[90mPress enter to continue\u001b[0m");
            scanner.nextLine();
        }
    }
}