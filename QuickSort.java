package main.java;

/**
 * Created by zhaobo on 3/16/17.
 */
public class QuickSort {
    public void SortInts(int[] A) {
        if (A == null || A.length == 0) {
           return;
        }
        QuickSort(A, 0, A.length - 1);
    }
    private void QuickSort(int[] A, int start, int end) {
       if (start > end ) {
           return;
       }
       int left = start;
       int right = end;
       int pivot = A[(start + end) / 2];

       while (left <= right) {
           while(A[left] < pivot && left <= right) {
               left++;
           }
           while(A[right] > pivot && left <= right) {
               right--;
           }
           if (left <= right) {
               int temp = A[left];
               A[left] = A[right];
               A[right] = temp;
               left++;
               right--;
           }
       }
       QuickSort(A, start, right);
       QuickSort(A, left, end);
    }
}
