import java.util.*;

public class InsertionSort {

    public static void main (String[] args) {
        
    }

    public static void Insertion(int nums[], int numSize) {
        int m = 0;
        int n = 0;
        int temp = 0;

        for (m = 1; m < numSize; ++m) {
            n = m;
            while (n > 0 && nums[n] < nums[n - 1]) {
                temp = nums[n];
                nums[n] = nums[n -1];
                nums[n - 1] = temp;
                --n;
            }
        }
    }
}