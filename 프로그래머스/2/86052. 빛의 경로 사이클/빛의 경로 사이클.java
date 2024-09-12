import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = grid.length;
        int m = grid[0].length();
        boolean[][][] visited = new boolean[n][m][4];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    if(visited[i][j][k])
                        continue;
                    int count = 0;
                    int x = i;
                    int y = j;
                    int idx = k;
                    
                    while(true) {
                        if(visited[x][y][idx]) {
                            if(x == i && y == j && idx == k) {
                                list.add(count);
                            }
                            break;
                        }
                        visited[x][y][idx] = true;
                        
                        int nx = x + dx[idx];
                        int ny = y + dy[idx];
                        
                        if(nx < 0)
                            nx = n - 1;
                        else if(nx == n)
                            nx = 0;
                        
                        if(ny < 0)
                            ny = m - 1;
                        else if(ny == m)
                            ny = 0;
                        
                        if(grid[nx].charAt(ny) == 'L') {
                            if(idx == 0 || idx == 1)
                                idx += 2;
                            else
                                idx = 3 - idx;
                        }
                        if(grid[nx].charAt(ny) == 'R') {
                            if(idx == 0 || idx == 1)
                                idx = 3 - idx;
                            else
                                idx -= 2;
                        }
                        x = nx;
                        y = ny;
                        
                        count++;
                    }
                }
            }
        }
        
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        Arrays.sort(answer);
        
        
        
        return answer;
    }
}