class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        answer = func(1, 100000, diffs, times, n, limit);
        return answer;
    }
    
    static int func(int start, int end, int[] diffs, int[] times, int n, long limit) {
        while(start < end) {
            int mid = (start + end) / 2;
            long time = 0;
            for(int i = 0; i < n; i++) {
                if(diffs[i] <= mid)
                    time += times[i];
                else
                    time += (times[i] + times[i-1]) * (diffs[i] - mid) + times[i];
            }
            if(time > limit)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}