package algorithms.level11BinarySearchReview;

public class SmallestRectangleEnclosingBlackPixels {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
     // 用四个二分法搜索边缘的小黑块
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        int n = image.length;
        int m = image[0].length;
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n  - 1);
        return (right - left + 1) * (bottom - top + 1);
    }

    private boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyColumn(char[][] image, int column) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][column] == '1') {
                return false;
            }
        }
        return true;
    }

    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (isEmptyColumn(image, start)) {
            return end;
        }
        return start;
    }

    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (isEmptyColumn(image, end)) {
            return start;
        }
        return end;
    }

    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (isEmptyRow(image, start)) {
            return end;
        }
        return start;
    }

    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (isEmptyRow(image, end)) {
            return start;
        }
        return end;
    }
}
