class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n % 2 == 1)
            return 0;
        long[] dp = new long[n/2];
        long[] dp2 = new long[n/2-1];
        if(n == 2)
            return 3;
        dp[0] = 3;
        dp[1] = 11;
        dp2[0] = 2 * dp[0];
        
        for(int i = 2; i < n/2; i++) {
            dp[i] = (dp[i-1] * 3 + dp2[i-2] + 2) % 1000000007;
            dp2[i-1] = (dp2[i-2] + dp[i-1] * 2) % 1000000007;
        }
        
        answer = (int)dp[n/2-1];
        return answer;
    }
}