import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oil = new int[m];
        
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    func(land, i, j);
                }
            }
            answer = Math.max(oil[j], answer);
        }

        return answer;
    }
    
    static void func(int[][] land, int x, int y) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();
        stack.push(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;
        
        while(!stack.isEmpty()) {
            int[] num = stack.pop();
            list.add(num);
            
            for(int i = 0; i < 4; i++) {
                int tempX = num[0] + dx[i];
                int tempY = num[1] + dy[i];
                if(tempX >= 0 && tempY >= 0 && tempX < n && tempY < m && land[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    stack.push(new int[] {tempX, tempY});
                    count++;
                }
            }
        }
        
        boolean[] check = new boolean[m];
        for(int[] num : list) {
            if(!check[num[1]]) {
                oil[num[1]] += count;
                check[num[1]] = true;
            }
        }
    }
}