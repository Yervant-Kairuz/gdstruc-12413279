String newCardName(Random rand) {
    int randomNumber = rand.nextInt(11); // A - K
    char randomLetter = (char) ('A' + randomNumber);
    String pairedNumber = Integer.toString((rand.nextInt(9) + 1)); // 1 - 9

    return randomLetter+pairedNumber;
}

void clearScreen() {
    for (int i = 0; i < 50; i++) {
        System.out.println(" ");
    }
}

void GameCommand(int randomCommand, Random rand, CardStack playerDeck, CardStack discardPile, CardStack playerHand) {
    switch (randomCommand) {
        case 0: { // Draw x cards
            int randomNumberX = rand.nextInt(5) + 1;
            // Check if we can draw that amount of cards, if not get all.
            if (randomNumberX > playerDeck.size()) { randomNumberX = playerDeck.size(); }
            System.out.println("[COMMAND] Draw " + randomNumberX + " amount of cards");

            System.out.println("[Draw] Got: ");
            for (int i = 1; i <= randomNumberX; i++) {
                Card drawnCard = playerDeck.pop();
                System.out.print(drawnCard.getName() + " ");
                playerHand.push(drawnCard);

            }
            break;
        }
        case 1: { // Discard x cards
            int randomNumberX = rand.nextInt(5) + 1;

            // Check if we can discard that amount of cards, if not discard all.
            if (randomNumberX > playerHand.size()) { randomNumberX = playerHand.size(); }
            System.out.println("[COMMAND] Discard " + randomNumberX + " amount of cards");

            System.out.println("[Discard] Discarding: ");
            for (int i = 1; i <= randomNumberX; i++) {
                Card discardCard = playerHand.pop();
                System.out.print(discardCard.getName() + " ");
                discardPile.push(discardCard);
            }
            break;
        }

        case 2: { // Get x cards from the discarded pile
            int randomNumberX = rand.nextInt(5) + 1;
            // Check if we can get that amount of cards, if not get all that's left.
            if (randomNumberX > discardPile.size()) { randomNumberX = discardPile.size(); }
            System.out.println("[COMMAND] Get " + randomNumberX + " amount of cards from the discard pile");

            System.out.println("[Get] Got: ");
            for (int i = 1; i <= randomNumberX; i++) {
                Card getCard = discardPile.pop();
                System.out.print(getCard.getName() + " ");
                playerHand.push(getCard);
            }
            break;
        }
    }
}

void GameRound(Random rand, Scanner scanner, int Round, CardStack playerDeck, CardStack discardPile, CardStack playerHand) {
    // UI
    System.out.println("Round " + Round);
    System.out.println("Player Deck: " + playerDeck.size() + " cards left");
    System.out.println("Discard Pile: " + discardPile.size() + " cards");
    System.out.print("Player Hand: ");
    playerHand.printCards();

    System.out.println("\n\u001b[90mPress enter to continue\u001b[0m");
    scanner.nextLine(); // Pause

    int randomCommand = rand.nextInt(3);
    if (randomCommand == 2 && discardPile.isEmpty()) {
        randomCommand = rand.nextInt(2);
    }
    if (randomCommand == 1 && playerHand.isEmpty()) {
        randomCommand = 0;
    }

    GameCommand(randomCommand, rand, playerDeck, discardPile, playerHand);

    System.out.println("\n\u001b[90mPress enter to continue\u001b[0m");
    scanner.nextLine(); // Pause
    clearScreen();
}

void main() {
    clearScreen();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    CardStack playerDeck = new CardStack();
    CardStack discardPile = new CardStack();
    CardStack playerHand = new CardStack();

    // Filling playerDeck
    for (int i = 0; i < 30; i++) {
        playerDeck.push(new Card(newCardName(rand)));
    }

    // Game
    int Round = 1;
    while (!playerDeck.isEmpty()) {
        GameRound(rand, scanner, Round, playerDeck, discardPile, playerHand);
        Round++;
    }

    // Game Over
    System.out.println("Game Over!");
    System.out.println("Cards remaining in your hand: ");
    playerHand.printCards();
    System.out.println("\nRounds taken: " + Round);
}