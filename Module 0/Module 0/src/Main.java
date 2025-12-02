void main() {
    // Record Start Timestamp
    System.out.println("Hello World");

    // Some Complex Operation

    // Record End Timestamp

    /* The Common Big O Notations
    O(1)        | Constant
    0(log_2n)   | Logarithmic
    0(n)        | Linear
    0(nlog_2n)  | n * log_2 * n
    0(n^2)      | Quadratic
    */

    // Creating an array
    int[] numbers = new int[5];
    numbers[0] = 10;
    numbers[1] = 45;
    numbers[2] = 20;
    numbers[3] = 80;
    numbers[4] = 65;

    // Print out all members of the numbers array
    for (int number : numbers) {
        System.out.println(number);
    }

    int index = -1;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == 20){
            index = i;
            break;
        }
    }

    System.out.println(index);
}