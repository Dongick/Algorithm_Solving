class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int min = 1000000;
            int x = balls[i][0];
            int y = balls[i][1];
            if(startY != y || x >= startX)
                min = Math.min(min, (int)Math.pow(startX + x, 2) + (int)Math.pow(Math.abs(startY - y), 2));
            if(startY != y || x <= startX)
                min = Math.min(min, (int)Math.pow((m - startX) + (m - x), 2) + (int)Math.pow(Math.abs(startY - y), 2));
            if(startX != x || y >= startY)
                min = Math.min(min, (int)Math.pow(Math.abs(startX - x), 2) + (int)Math.pow(startY + y, 2));
            if(startX != x || y <= startY)
                min = Math.min(min, (int)Math.pow(Math.abs(startX - x), 2) + (int)Math.pow((n - startY) + (n - y), 2));
            
            answer[i] = min;
        }
        return answer;
    }
}