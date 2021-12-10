package com.company.level10DoublePointerReview;

public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    // 分治法用到左右两个指针，相向双指针
    // k/2 = midColor
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
       colorSort(colors, 0, colors.length - 1, 1, k);
    }

    private void colorSort(int[] colors, int startFrom, int endAt, int colorFrom, int colorTo) {
        if (startFrom >= endAt) {
            return;
        }
        if (colorFrom == colorTo) {
            return;
        }
        int left = startFrom;
        int right = endAt;
        int midColor = (colorFrom + colorTo) / 2;
        // forget while (left <= right)
        while (left <= right){
            while (left <= right && colors[left] <= midColor) {
                left++;
            }
            while (left <= right && colors[right] > midColor) {
                right--;
            }
            if (left <= right) {
                swap(colors, left, right);
                left++;
                right--;
            }
        }
        colorSort(colors, startFrom, right, colorFrom, midColor);
        colorSort(colors, left, endAt, midColor + 1, colorTo);

    }

    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
