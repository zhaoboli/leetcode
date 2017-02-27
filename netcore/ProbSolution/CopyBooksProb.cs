namespace ProbSolution
{
    public class CopyBooksProb
    {

        /**
        * @param pages: an array of integers
        * @param k: an integer
        * @return: an integer
        */
        public int CopyBooks(int[] pages, int k) {

            // write your code here
            if(pages == null || pages.Length ==0) {
                return 0;
            }
        
            int max = 0;
            int sum = 0;
            for (int i = 0; i < pages.Length; i++) {
                if(pages[i] > max) {
                    max = pages[i];
                }
                sum += pages[i];
            }
        
            int start = max;
            int end = sum;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (countCopiers(pages, mid) <= k) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
        
            if (countCopiers(pages, start) <= k) {
                return start;
            }
            if (countCopiers(pages, end) <= k) {
                return end;
            }
            return -1;
        
            }
    
        private int countCopiers(int[] pages, int copyTarget) {
            int copier = 1;
            int sum = 0;
            for (int i = 0; i < pages.Length; i++) {
                if (sum + pages[i] <= copyTarget) {
                    sum += pages[i];
                    continue;
                }
                sum = pages[i];
                copier++;
                //if (sum + pages[i] > copyTarget) {
                //    sum = 0;
                //    copier++;
                //}
                 //sum += pages[i];
                }
            return copier;
        }
    }
}