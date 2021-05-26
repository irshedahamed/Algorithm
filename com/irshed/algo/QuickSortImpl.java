package Algorithm.com.irshed.algo;

/**
 * Video : https://www.youtube.com/watch?v=MZaf_9IZCrc
 * Watch for better clarity
 */

public class QuickSortImpl {

    public static void quickSort(int[] arr, int left, int right) {
        /**Remember Base Condition**/
        if (left < right) {
            int pivot = right;
            int partitionIndex = partition(arr, left, right, pivot);

            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        swap(arr, pivot, right);
        int i = left - 1;
        int j = left;
        for (; j < right; j++) {
            if (arr[j] < arr[right]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 2, 3, 9, 5, 7, 8};
        quickSort(arr, 0, 8);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
