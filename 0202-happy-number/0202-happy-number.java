class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        while(true){
            int rem = n % 10;
            rem *= rem;
            n = n / 10;
            sum += rem;

            if(n == 0){
                if(set.contains(sum)) return false;
                set.add(sum);
                if(sum == 1) return true;
                else{
                    n = sum;
                    sum = 0;
                }
            }
        }
    }
}