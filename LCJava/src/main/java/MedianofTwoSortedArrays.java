import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by zhaobo on 4/9/17.
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 *
 * Example:
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 */
public class MedianofTwoSortedArrays {

    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int mid = (A.length + B.length) / 2;
        if ((A.length + B.length) % 2 == 0) {
            return (findKthElement(A, 0, B, 0, mid + 1) +
                    findKthElement(A, 0, B, 0, mid)) / 2;
        } else {
            return findKthElement(A, 0, B, 0, mid + 1);
        }
    }

    // the kth item
    private double findKthElement(int[] A, int indexA, int[] B, int indexB, int k) {
        //recursion exit
        if (indexA >= A.length) {
             return B[indexB + k - 1];
        }

        if (indexB >= B.length) {
            return A[indexA + k - 1];
        }

        if (k == 1)  {
             return Math.min(A[indexA], B[indexB]);
        }

        //one array is shorter than k/2, throw k/2 off from the bigger array
        if (A.length < (indexA + k / 2 - 1)) {
            return findKthElement(A, indexA, B, indexB + k/2, k - k/2);
        }
        if (B.length < (indexB + k / 2 - 1)) {
            return findKthElement(A, indexA + k/2, B, indexB, k - k/2);
        }

        //normal scenario
        if (A[indexA + k/2 -1 ] < B[indexB + k/2 - 1]) {
            return findKthElement(A, indexA + k/2, B, indexB, k - k/2);
        } else {
            return findKthElement(A, indexA, B, indexB + k/2, k - k/2);
        }
    }
}
