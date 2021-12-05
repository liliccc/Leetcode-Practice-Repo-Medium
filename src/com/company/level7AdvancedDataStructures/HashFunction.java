package com.company.level7AdvancedDataStructures;

public class HashFunction {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // ((n1 * 33 + n2) * 33 + n3) * 33 + n4
        long ans = 0;
        for (char c : key) {
            ans = (ans * 33 + (int) c) % HASH_SIZE;
        }
        return (int)ans;
    }
}
