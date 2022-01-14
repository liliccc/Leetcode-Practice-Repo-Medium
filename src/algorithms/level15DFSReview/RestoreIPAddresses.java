package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return results;
        }
        dfs(s, "", results, 0);
        return results;
    }

    private void dfs(String str, String currentIP, List<String> results, int count) {
        if (count == 4 ) {
            if (str.length() == 0) {
                results.add(currentIP);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (str.length() < i) {
                break;
            }
            String sub = str.substring(0, i);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            int num = Integer.parseInt(sub);
            if (num > 255) {
                continue;
            }
            String newIP = "";
            if (count == 0) {
                newIP = sub;
            }
            else {
                newIP = currentIP + "." + sub;
            }
            dfs(str.substring(i), newIP, results, count + 1);
        }
    }
}
