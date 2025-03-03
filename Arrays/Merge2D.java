package Arrays;

import java.util.*;

public class Merge2D {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<int[]> list = new ArrayList<>();

        int left = 0, right = 0;
        while(left < n1 && right < n2){
            if(nums1[left][0] == nums2[right][0]){
                list.add(new int[]{nums1[left][0],
                 nums1[left][1] + nums2[right][1]});
                 left++; 
                 right++;
            }
            else if(nums1[left][0] < nums2[right][0]){
                list.add(new int[]{nums1[left][0], nums1[left][1]});
                left++;
            }
            else {
                list.add(new int[]{nums2[right][0], nums2[right][1]});
                right++;
            }
        }
        while(left < n1){
            list.add(new int[]{nums1[left][0], nums1[left][1]});
                left++;
        }
        while(right < n2){
            list.add(new int[]{nums2[right][0], nums2[right][1]});
                right++;
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};

        int[][] merged = mergeArrays(nums1, nums2);

        Arrays.deepToString(merged);
    }
}
