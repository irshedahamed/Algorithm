package Algorithm.com.irshed.algo;

public class HeapSort {


    public void heapSort(int[] heap) {
        //heapify

        for (int i = heap.length / 2 - 1; i >= 0; i--)
            sink(i,heap);

        for (int i = heap.length - 1; i > 0; i--) {
            // Move current root to end
            swap(heap,0,i);


        }

    }

    private void sink(int k,int[] arr) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = k;
            if (left < arr.length && less(arr,left, smallest))
                smallest = left;
            if (right < arr.length && less(arr,right, smallest))
                smallest = right;

            if (smallest != k) {
                swap(arr,k, smallest);
                sink(smallest,arr);
            }else{
                break;
            }
        }
    }

    private boolean less(int[] arr,int left, int right) {
        if(arr[left]<arr[right])
            return true;
        return false;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
