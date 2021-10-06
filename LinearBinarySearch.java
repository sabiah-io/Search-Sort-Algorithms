import java.util.*;

public class LinearBinarySearch {
    
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);

        // Display program title
        System.out.println();
        System.out.println("\t\t\t\t\tLinear and Binary Search");
        System.out.println();

        // Requesting size of the list/array from user
        System.out.print("Enter your list size(number of elements in the list): ");
        int arraySize = scanner.nextInt();
        System.out.println();

        // Initialize the array size to value received from user
        int[] array = new int[arraySize];

        // Iterate through the array size with each iteration requesting the user for a value.
        for (int x = 0; x < arraySize; ++x) {
            System.out.print("Value for index " + x + ": ");
            int input = scanner.nextInt();
            // Adding the value to array index x
            array[x] = input;

        }

        // Requesting search key from user
        System.out.println();
        System.out.print("Enter the search key(value in the list to search for): ");
        int searchKey = scanner.nextInt();
        System.out.println();


        // The type of search algorithm user would like to perform
        System.out.println("Which search operation would you like to performing?");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Reply with 1 or 2");
        int searchType = scanner.nextInt();

        if (searchType == 1) {
            int searchIndex = LinearSearch(array, arraySize, searchKey);

            if (searchIndex == -1) {
                System.out.println();
                System.out.println("Oops, search key was not found in the list.");
            } else {
                System.out.println();
                System.out.println("Search key was found at index " + searchIndex + ".");
            }
        } else if (searchType == 2) {
            int searchIndex = BinarySearch(array, arraySize, searchKey);

            if (searchIndex == -1) {
                System.out.println();
                System.out.println("Oops, search key was not found in the list.");
            } else {
                System.out.println();
                System.out.println("Search key was found at index " + searchIndex + ".");
            }
        } else {
            System.out.println();
            System.out.println("Sorry wrong input.");
        }
        
        scanner.close();
    }


    // Linear Search Algorithm
    public static int LinearSearch (int nums[], int numSize, int searchKey) {
        // Initializing variables to be used
        int index = 0;

        for (index = 0; index < numSize; ++index) { 
            if (searchKey == nums[index]) {
                // Return index of search key
                return index;
            }
        }

        return -1; // not found
    }

    // Binary Search Algorithm
    public static int BinarySearch (int nums[], int numSize, int searchKey) {
        // Initializing variables to be used
        int mid = 0;
        int left = 0;
        int right = numSize - 1;

        while (right >= left) {
            // Half the array size and proceed to compare values on both sides
            mid = (left + right) / 2;
            if (nums[mid] < searchKey) {
                // Increase left side index by 1
                left = mid + 1;
            }
            else if (nums[mid] > searchKey) {
                // Decrease right side index by 1
                right = mid - 1;
            }
            else {
                // return the mid value as search key index
                return mid;
            }
        }

        return -1; // not found
    }
}