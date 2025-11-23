class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
        }
        int[] sumarr = new int[max+1];

        if(nums.length==1) return nums[0];
        for(int num:nums){
            sumarr[num] += num;
        }
        int[] dp = new int[max+1];
        dp[0] = sumarr[0];
        dp[1] = Math.max(sumarr[0], sumarr[1]);
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1], sumarr[i]+dp[i-2]);
        }
        return dp[max];
    }
}