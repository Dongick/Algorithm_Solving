class Solution {
    public long solution(int n, int[] times) {
        long answer = func(n, times);
        return answer;
    }
    
    static long func(int n, int[] times) {
        long lo = 1;
        long hi = (long)1000000000 * 1000000000;
        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0;
            for(int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if(count < n)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}