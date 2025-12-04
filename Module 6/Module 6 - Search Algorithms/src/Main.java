void main() {
    int numbers[] = { 60 , 33, 12, 64, 17, 105, -53 };

    System.out.println("── Linear Search ──");
    System.out.println(linearSearch(numbers, 105));
    System.out.println(linearSearch(numbers, 420));

    Arrays.sort(numbers);

    System.out.println("── Binary Search ──");
    System.out.println(binarySearch(numbers, 33));
    System.out.println(binarySearch(numbers, 69));

    System.out.println("── Exponential Search ──");
    System.out.println(binarySearch(numbers, 105));
    System.out.println(binarySearch(numbers, 20));
}

// O(n) time complexity
int linearSearch(int[] input, int value) {
    for (int i = 0; i < input.length; i++) {
        if (input[i] == value) {
            return i;
        }
    }
    return -1;
}

// Only works with ORDERED lists/arrays
// O(log(N))
int binarySearch(int[] input, int value) {
    int start = 0;
    int end = input.length - 1;

    while (start <= end) {
        int middle = (start + end) / 2;

        if (input[middle] == value) {
            return middle;
        } else if (value < input[middle]) { // value might be at the left half
            end = middle - 1;
        } else if (value > input[middle]) { // value might be at the right half
            start = middle + 1;
        }
    }
    return -1;
}

// Only works with ORDERED lists/arrays
// O(log(N))
/*
Not my own creation, however the steps are:
1. First you check if the array is empty or not
2. Next you check if our value is right on the first index
3. Here's the tedious part, use a repeated doubling search to find the range
    by searching the indexes in powers of 2, hence the name exponential search
4. Once you've found the range 'i', perform the binary search we learned from
    i/2 to i or arraySize-1 (cuz we want it to be within the size of the array)
5. The binary search will only happen in a smaller area compared to if you did
    binary search on the whole array.
6. This algorithm is faster the closer the item is to the first position.
7. Am not creative >.< but I here u go
*/

int exponentialSearch(int[] input, int value) {
    int arraySize = input.length;

    // Empty Array
    if (arraySize == 0) {
        return -1;
    }
    // First position?
    if (input[0] == value) {
        return 0;
    }

    // Find range for binary search through repreated doubling
    int i = 1;
    while (i < arraySize && input[i] <= value) {
        i *= 2;
    }

    // Perform binary search in the determined range
    // The range is from i/2 to Math.min(i, arraySize-1)
    return Arrays.binarySearch(input, i/2, Math.min(i, arraySize -1), value);
}