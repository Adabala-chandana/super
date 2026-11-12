package day6;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int i = 1;

        while (i < strs.length) {
            if (strs[i].startsWith(prefix)) {
                i++;
            } else {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
