package algorithms.level10TwoPointersTechniqueReview;

public class SumofTwoStrings {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return the sum of two strings
     */
    public static String SumofTwoStrings(String A, String B) {
        if (A == null || B == null) {
            return null;
        }
        String result = "";
        int lenA = A.length();
        int lenB = B.length();
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        // 合并数组或者字串，从后向前处理
        while (indexA >=0 && indexB >=0) {
            int chunk = (A.charAt(indexA) - '0') + (B.charAt(indexB) - '0');
            result = String.valueOf(chunk) + result;
            indexA --;
            indexB --;
        }
        if (indexA >= 0) {
            result = A.substring(0, indexA + 1) + result;
        }
        if (indexB >= 0) {
            result = B.substring(0, indexB + 1) + result;
        }

        return result;
    }

    public static void main(String[] args) {
        SumofTwoStrings("99", "111");
    }
}
