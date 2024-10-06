class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int i = 0; i < sizes.length; i++) {
            int tempW = Math.max(sizes[i][0], sizes[i][1]);
            int tempH = Math.min(sizes[i][0], sizes[i][1]);
            w = Math.max(w, tempW);
            h = Math.max(h, tempH);
        }
        int answer = w * h;
        return answer;
    }
}