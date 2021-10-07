import java.util.*;

public class SearchSortAlgorithm {
    
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);

        // Display program title
        System.out.println();
        System.out.println("\t\t\t\t\tSearching and Sorting Algorithm Program");
        System.out.println("\t\tThe program allows you to perform searching or sorting operations on your set of inputs.\n");


        try {
            // The type of search algorithm user would like to perform
            System.out.println("Which operation would you like to performing?");
            System.out.println("1. Search Operation");
            System.out.println("2. Sort Operation");
            System.out.print("Reply with 1 or 2: ");
            int type = scanner.nextInt();

            if (type == 1) {
                // Requesting size of the list/array from user
                System.out.print("\nEnter your list size(number of elements in the list): ");
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
                System.out.print("\nEnter the search key(value in the list to search for): ");
                int searchKey = scanner.nextInt();
                System.out.println();

                // Type of Search Operation to perform
                System.out.println("\nWhich search algorithm would you like to use?");
                System.out.println("1. Linear Search");
                System.out.println("2. Binary Search");
                System.out.print("Reply with 1 or 2: ");
                int searchType = scanner.nextInt();


                if (searchType == 1) {
                    int index = LinearSearch(array, arraySize, searchKey);
                    if (index == -1) {
                        System.out.println("\nSorry but search key cannot be found.");
                    } else {
                        System.out.println("\nSearch key was found at index " + index + ".");
                    }
                }
                if (searchType == 2) {
                    int index = BinarySearch(array, arraySize, searchKey);
                    if (index == -1) {
                        System.out.println("\nSorry but search key cannot be found.");
                    } else {
                        System.out.println("\nSearch key was found at index " + index + ".");
                    }
                }
            } else if (type == 2) {
                // Requesting size of the list/array from user
                System.out.print("\nEnter your list size(number of elements in the list): ");
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

                // Type of Search Operation to perform
                System.out.println("\nWhich sort algorithm would you like to use?");
                System.out.println("1. Quick Sort");
                System.out.println("2. Selection Sort");
                System.out.println("3. Insertion Sort");
                System.out.println("4. Bubble Sort");
                System.out.println("5. Merge Sort");
                System.out.print("Reply with 1, 2, 3, 4 or 5: ");
                int sortType = scanner.nextInt();

                if (sortType == 1) {
                    QuickSort(array, 0, arraySize - 1);
                    System.out.println("\nSorted Array in Ascending Order using Quick Sort: ");
                    System.out.println(Arrays.toString(array));
                }
                if (sortType == 2) {
                    SelectionSort(array, arraySize);
                    System.out.println("\nSorted Array in Ascending Order using Selection Sort: ");
                    System.out.println(Arrays.toString(array));
                }
                if (sortType == 3) {
                    Insertion(array, arraySize);
                    System.out.println("\nSorted Array in Ascending Order using Insertion Sort: ");
                    System.out.println(Arrays.toString(array));
                }
                if (sortType == 4) {
                    BubbleSort(array, arraySize);
                    System.out.println("\nSorted Array in Ascending Order using Bubble Sort: ");
                    System.out.println(Arrays.toString(array));
                }
                if (sortType == 5) {
                    MergeSort(array, arraySize);
                    System.out.println("\nSorted Array in Ascending Order using Merge Sort: ");
                    System.out.println(Arrays.toString(array));
                }

            }
        } catch (Exception InputMismatchException) {
            System.out.println("\nSorry you entered wrong input. Program ended.");        
        }
        
        scanner.close();
    }


    // Linear Search 
    public static int LinearSearch (int array[], int arraySize, int searchKey) {
        // Initializing variables to be used
        int index = 0;

        for (index = 0; index < arraySize; ++index) { 
            if (searchKey == array[index]) {
                // Return index of search key
                return index;
            }
        }

        return -1; // not found
    }
    

    // Binary Search 
    public static int BinarySearch (int array[], int arraySize, int searchKey) {
        // Initializing variables to be used
        int mid = 0;
        int left = 0;
        int right = arraySize - 1;

        while (right >= left) {
            // Half the array size and proceed to compare values on both sides
            mid = (left + right) / 2;
            if (array[mid] < searchKey) {
                // Increase left side index by 1
                left = mid + 1;
            }
            else if (array[mid] > searchKey) {
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


    // Insertion Sort
    public static void Insertion(int array[], int arraySize) {
        int m = 0;
        int n = 0;
        int temp = 0; // temporary value to be used for swapping

        for (m = 1; m < arraySize; ++m) {
            n = m;
            while (n > 0 && array[n] < array[n - 1]) {
                temp = array[n];
                array[n] = array[n -1];
                array[n - 1] = temp;
                --n;
            }
        }
    }


    // Bubble Sort
    public static void BubbleSort(int array[], int arraySize) {
        int m;
        int n;
        int temp = 0;
        
        // loop to access each array element
        for (m = 0; m < arraySize - 1; m++) {
            // loop to compare array elements
            for (n = 0; n < arraySize - m - 1; n++) {
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[n] > array[n + 1]) {

                    // swapping occurs if elements
                    // are not in the intended order
                    temp = array[n];
                    array[n] = array[n + 1];
                    array[n + 1] = temp;
                }
            }

        }
    }


    // Selection Sort
    public static void SelectionSort(int array[], int arraySize) {
        int step;
        int m;
    
        for (step = 0; step < arraySize - 1; step++) {
          int min_idx = step;
    
          for (m = step + 1; m < arraySize; m++) {
            // Select the minimum element in each loop.
            if (array[m] < array[min_idx]) {
              min_idx = m;
            }
          }
    
          // put min at the correct position
          int temp = array[step];
          array[step] = array[min_idx];
          array[min_idx] = temp;
        }
      }

    
    public static void QuickSort(int array[], int low, int high) {
        // choose the rightmost element as main
        int main = array[high];

        int m = (low - 1);
    
        // compare each element with main
        for (int n = low; n < high; n++) {
          if (array[n] <= main) {
            m++;    
            // swapping element at i with element at j
            int temp = array[m];
            array[m] = array[n];
            array[n] = temp;
          }
    
        }
        // swapt the pivot element with the greater element specified by i
        int temp = array[m + 1];
        array[m + 1] = array[high];
        array[high] = temp;
    
        if (low < high) {
          // recursive call on the left of pivot
          QuickSort(array, low, m - 1);
    
          // recursive call on the right of pivot
          QuickSort(array, m + 1, high);
        }
    }

    
    // Merge Sort
    public static void MergeSort(int[] array, int arraySize) {

        // Spliting array into two parts
        if (arraySize % 2 == 0) {
            // array with even size
            int mid = arraySize / 2;

            int[] arrayA = new int[mid];
            int[] arrayB = new int[mid];

            // filling first array
            for (int i = 0; i < mid; i++) {
                arrayA[i] = array[i];
            }
            
            // filling second array
            for (int i = 0; i < mid; i++) {
                arrayB[i] = array[i + (mid)];

            }
            
            // sorting arrays separately 
            SelectionSort(arrayA, arrayA.length);
            SelectionSort(arrayB, arrayB.length);
            
            // combining arrays 
            int[] newArray = new int[arrayA.length + arrayB.length];
            System.arraycopy(arrayA, 0, newArray, 0, arrayA.length);
            System.arraycopy(arrayB, 0, newArray, arrayA.length, arrayB.length);
            System.out.println(Arrays.toString(newArray));
        
        } else {
            // array with odd size
            int mid = arraySize / 2;

            int[] arrayA = new int[arraySize / 2];
            int[] arrayB = new int[(arraySize / 2) + 1];
            
            // filling in first array
            for (int i = 0; i < mid; i++) {
                arrayA[i] = array[i];
            }
            
            // filling in second array
            for (int i = 0; i < mid + 1; i++) {
                arrayB[i] = array[i + (mid)];

            }
            
            // sorting arrays separately
            SelectionSort(arrayA, arrayA.length);
            SelectionSort(arrayB, arrayB.length);

            // combining arrays 
            int[] newArray = new int[arrayA.length + arrayB.length];
            System.arraycopy(arrayA, 0, newArray, 0, arrayA.length);
            System.arraycopy(arrayB, 0, newArray, arrayA.length, arrayB.length);
            System.out.println(Arrays.toString(newArray));
        }

    }
}