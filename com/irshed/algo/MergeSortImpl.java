package Algorithm.com.irshed.algo;


public class MergeSortImpl {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, right, mid);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int ptr1 = left;
        int ptr2 = mid + 1;
        int[] temp = new int[right - left + 1];
        int count = 0;
        while (ptr1 <= mid && ptr2 <= right) {
            if (arr[ptr1] < arr[ptr2]) {
                temp[count++] = arr[ptr1++];
            } else {
                temp[count++] = arr[ptr2++];
            }
        }

        while (ptr1 <= mid) {
            temp[count++] = arr[ptr1++];
        }
        while (ptr2 <= right) {
            temp[count++] = arr[ptr2++];
        }

        for (int i = right; i >= left; i--) {
            arr[i] = temp[--count];
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 2, 3, 9, 5, 7, 8};
        mergeSort(arr, 0, 8);
    }
}
