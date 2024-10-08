class Solution {
    static boolean[][] red;
    static boolean[][] blue;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        red = new boolean[n][m];
        blue = new boolean[n][m];
        int[] redStart = new int[2];
        int[] blueStart = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == 1) {
                    redStart[0] = i;
                    redStart[1] = j;
                }
                if(maze[i][j] == 2) {
                    blueStart[0] = i;
                    blueStart[1] = j;
                }
            }
        }
        red[redStart[0]][redStart[1]] = true;
        blue[blueStart[0]][blueStart[1]] = true;
        
        func(redStart, blueStart, 0, maze);
        int answer = (result == Integer.MAX_VALUE) ? 0 : result;
        return answer;
    }
    
    static void func(int[] redIdx, int[] blueIdx, int count, int[][] maze) {
        if(maze[redIdx[0]][redIdx[1]] == 3 && maze[blueIdx[0]][blueIdx[1]] == 4) {
            result = Math.min(result, count);
            return;
        }
        
        if(maze[redIdx[0]][redIdx[1]] != 3) {
            for(int i = 0; i < 4; i++) {
                int[] redTemp = {redIdx[0] + dx[i], redIdx[1] + dy[i]};
                if(redTemp[0] >= 0 && redTemp[0] < n && redTemp[1] >= 0 && redTemp[1] < m && !red[redTemp[0]][redTemp[1]] && maze[redTemp[0]][redTemp[1]] != 5) {
                    if(maze[blueIdx[0]][blueIdx[1]] != 4) {
                        for(int j = 0; j < 4; j++) {
                            int[] blueTemp = {blueIdx[0] + dx[j], blueIdx[1] + dy[j]};
                            if(blueTemp[0] >= 0 && blueTemp[0] < n && blueTemp[1] >= 0 && blueTemp[1] < m && !blue[blueTemp[0]][blueTemp[1]] && maze[blueTemp[0]][blueTemp[1]] != 5) {
                                if(check(redTemp, blueTemp, redIdx, blueIdx)) {
                                    red[redTemp[0]][redTemp[1]] = true;
                                    blue[blueTemp[0]][blueTemp[1]] = true;
                                    func(redTemp, blueTemp, count+1, maze);
                                    blue[blueTemp[0]][blueTemp[1]] = false;
                                    red[redTemp[0]][redTemp[1]] = false;
                                }
                            }
                        }
                    } else {
                        if(redTemp[0] != blueIdx[0] || redTemp[1] != blueIdx[1]) {
                            red[redTemp[0]][redTemp[1]] = true;
                            func(redTemp, blueIdx, count+1, maze);
                            red[redTemp[0]][redTemp[1]] = false;
                        }
                    }
                }
            }
        } else {
            for(int i = 0; i < 4; i++) {
                int[] blueTemp = {blueIdx[0] + dx[i], blueIdx[1] + dy[i]};
                if(blueTemp[0] >= 0 && blueTemp[0] < n && blueTemp[1] >= 0 && blueTemp[1] < m && !blue[blueTemp[0]][blueTemp[1]] && maze[blueTemp[0]][blueTemp[1]] != 5) {
                    if(redIdx[0] != blueTemp[0] || redIdx[1] != blueTemp[1]) {
                        blue[blueTemp[0]][blueTemp[1]] = true;
                        func(redIdx, blueTemp, count+1, maze);
                        blue[blueTemp[0]][blueTemp[1]] = false;
                    }
                }
            }
        }
    }
    
    static boolean check(int[] redTemp, int[] blueTemp, int[] redIdx, int[] blueIdx) {
        if(redTemp[0] == blueIdx[0] && redTemp[1] == blueIdx[1] && redIdx[0] == blueTemp[0] && redIdx[1] == blueTemp[1])
            return false;
        if(redTemp[0] == blueTemp[0] && redTemp[1] == blueTemp[1])
            return false;
        return true;
    }
}