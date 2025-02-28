package Recursion;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilty {

    private static void solve(String tiles, Set<String> set, StringBuilder sb, boolean[] arr){
        set.add(sb.toString());

        for(int i = 0; i < tiles.length(); i++){
            if(arr[i] == true) continue;

            arr[i] = true;
            sb.append(tiles.charAt(i));

            solve(tiles, set, sb, arr);

            arr[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static int numTilePossibilities(String tiles){
        Set<String> set = new HashSet<>();
        boolean[] arr = new boolean[tiles.length()];
        solve(tiles, set, new StringBuilder(), arr);
        return set.size() - 1;
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        int result = numTilePossibilities(tiles);

        System.out.println(result);
    }
}
