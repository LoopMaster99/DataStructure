package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // to store the common prefix
        StringBuilder sb = new StringBuilder();

        // Sort the input array of strings lexicographically
        Arrays.sort(strs);

        // Get the first and last strings after sorting
        char[] first = strs[0].toCharArray();
        char[] second = strs[strs.length - 1].toCharArray();

        // Iterate through the characters of the first string
        for(int i = 0; i < first.length; i++){
            // If characters at the same position differ, stop
            if(first[i] != second[i]) break;

            // Append matching characters to the StringBuilder
            sb.append(first[i]);
        }

        return sb.toString();
    }

}
