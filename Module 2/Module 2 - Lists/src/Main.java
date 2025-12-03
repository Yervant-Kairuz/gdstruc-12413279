void main() {
    // ── LISTS ── \\
//    List<Player> playerList = new ArrayList<>();
//    playerList.add(new Player(1, "Asuna", 100));
//    playerList.add(new Player(2, "LethalBacon", 205));
//    playerList.add(new Player(3, "HPDeskjet", 34));
//
//    playerList.add(2, new Player(553, "Arctis", 55)); // O(n)
//    playerList.remove(2); // O(n)
//
//    System.out.println(playerList.contains(new Player(2, "LethalBacon", 205)));
//    System.out.println(playerList.indexOf(new Player(2, "LethalBacon", 205)));
//
//    playerList.forEach(player -> System.out.println(player));

    // ── LINKED LISTS ── \\
    Player asuna = new Player(1, "Asuna", 100);
    Player lethalBacon = new Player(2, "LethalBacon", 205);
    Player hpDeskJet = new Player(3, "HPDeskjet", 34);

    PlayerLinkedList playerLinkedList = new PlayerLinkedList();

    playerLinkedList.addToFront(asuna);
    playerLinkedList.addToFront(lethalBacon);
    playerLinkedList.addToFront(hpDeskJet);
    playerLinkedList.removeFront();

    playerLinkedList.printList();

    System.out.println("Size: " + playerLinkedList.getSize());
    System.out.println("Does it contain HPDeskjet: " + playerLinkedList.contains(hpDeskJet));
    System.out.println("Index of Asuna: " + playerLinkedList.indexOf(asuna));
}