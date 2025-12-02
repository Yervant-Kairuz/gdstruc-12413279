void main() {
    int[] numbers = new int[10];

    numbers[0] = 25;
    numbers[1] = 10;
    numbers[2] = 85;
    numbers[3] = 45;
    numbers[4] = 40;
    numbers[5] = 15;
    numbers[6] = 90;
    numbers[7] = 65;
    numbers[8] = 100;
    numbers[9] = 120;

    System.out.println("Before algorithmic sorting:");
    printArrayElements(numbers);

//    // Bubble Sort
//    System.out.println("\n\nAfter bubble sort:");
//    bubbleSort(numbers);
//    printArrayElements(numbers);

    // Selection Sort
    System.out.println("\n\nAfter selection sort:");
    selectionSort(numbers);
    printArrayElements(numbers);

}

void printArrayElements(int[] array) {
    for (int j : array) {
        System.out.print(j + " ");
    }
}
// O(n^2) Quadratic Time Complexity
void bubbleSort(int[] array) {
    for (int lastSortedIndex = array.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
        for (int i = 0; i < lastSortedIndex; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
    }
}

// O(n^2) Quadratic Time Complexity
// Unstable Algorithm
void selectionSort(int[] array) {
    for (int lastSortedIndex = array.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
        int largestIndex = 0;

        for (int i = 0; i <= lastSortedIndex; i++) {
            if (array[i] > array[largestIndex]) {
                largestIndex = i;
            }
        }

        int temp = array[lastSortedIndex];
        array[lastSortedIndex] = array[largestIndex];
        array[largestIndex] = temp;
    }
}