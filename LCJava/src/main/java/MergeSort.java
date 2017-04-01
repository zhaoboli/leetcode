/**
 * Created by zhaobo on 3/18/17.
 */
public class MergeSort {

    public void sortIntegers(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
       if (start >= end) {
           return;
       }

       int mid = (start + end) / 2;
       mergeSort(A, 0, mid, temp);
       mergeSort(A, mid + 1, end, temp);
       merge(A, start, mid, end, temp);
    }

    private void  merge(int[] A, int start ,int mid, int end, int[] temp) {
       int index = start;
       int left = start;
       int right = mid + 1;

       while (left <= mid && right <= end) {
           if (A[left] <= A[right]) {
                temp[index++] = A[left++];
           } else {
               temp[index++] = A[right++];
           }
       }

       while (left <= mid) {
           temp[index++] = A[left++];
       }
       while (right <= end) {
           temp[index++] = A[right++];
       }

       for (index = start; index <= end; index++) {
            A[index] = temp[index];
       }
    }
}
