/**
 * Created by zhaobo on 3/19/17.
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * Example
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 */
public class MergeSortedArray {

    public int[] mergeSortedArray(int[] A, int[] B) {

        int aStart = 0;
        int bStart = 0;
        int[] temp = new int[A.length + B.length];
        int index = 0;

        while (aStart < A.length && bStart < B.length) {
           if(A[aStart] <= B[bStart]) {
               temp[index++] = A[aStart++];
           } else{
               temp[index++] = B[bStart++];
           }
        }

        while (aStart < A.length) {
            temp[index++] = A[aStart++];
        }
        while (bStart < B.length) {
            temp[index++] = B[bStart++];
        }
        return temp;
    }
}
