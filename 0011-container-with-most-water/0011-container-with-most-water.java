class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;

        int area = Integer.MIN_VALUE;
        while(left < right){
            int width = right - left;
            int min = Math.min(height[left], height[right]);
            area = Math.max(area, width * min);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return area;
    }
}