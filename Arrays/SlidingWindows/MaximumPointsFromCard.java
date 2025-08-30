package Arrays.SlidingWindows;

public class MaximumPointsFromCard {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sumL = 0, max = 0;
        for(int i = 0; i < k; i++){
            sumL += cardPoints[i];
        }

        max = sumL;
        int sumR = 0, lastR = n - 1;
        for(int i = k - 1; i >= 0; i--){
            sumL -= cardPoints[i];
            sumR += cardPoints[lastR];
            lastR--;

            max = Math.max(max, sumL + sumR);
        }

        return max;
    }
}
