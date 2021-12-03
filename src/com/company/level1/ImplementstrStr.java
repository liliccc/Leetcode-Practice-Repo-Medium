package com.company.level1;

public class ImplementstrStr {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();

        if (targetLen == 0) {
            return 0;
        }
        if (targetLen > sourceLen) {
            return -1;
        }

        for (int i = 0; i < sourceLen - targetLen + 1; i++) {
            int k = 0;
            for (int j = 0; j < targetLen; j ++) {
                if (source.charAt( i + j) == target.charAt(j)) {
                    k++;
                    if (k == targetLen) {
                        return i;
                    }
                }
                else {
                    break;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String source = "tartarget";
        String target = "target";
        System.out.println(strStr(source, target));
    }
}
