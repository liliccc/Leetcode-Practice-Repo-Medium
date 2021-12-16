package algorithms.level11BinarySearchReview;

public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return -1;
        }
        int start = 0, end = 0;
        for (int page : pages) {
            end += page;
        }
        while (start + 1 < end) {
            int mid = start + (end -start) / 2;
            if (getNumberOfCopiers(pages, mid) <= k) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (getNumberOfCopiers(pages, start) <= k) {
            return start;
        }
         return end;
    }

    private int getNumberOfCopiers(int[] pages, int limit) {
        // 考虑极端情况下，copier为0的情况
        int copiers = 0;
        int lastCopy = limit;
        for (int page : pages) {
            if (page > limit) {
                return Integer.MAX_VALUE;
            }
            if (page + lastCopy > limit) {
                copiers++;
                lastCopy = 0;
            }
            lastCopy += page;
        }
        return copiers;
    }
}
