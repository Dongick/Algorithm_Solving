import java.io.*;
import java.util.*;

class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] check;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        check[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) 
                    continue;
                if(arr[nextX][nextY] == 0 || check[nextX][nextY] == true)
                    continue;
                queue.offer(new int[] {nextX, nextY});
                check[nextX][nextY] = true;
                arr[nextX][nextY] = arr[current[0]][current[1]] + 1;
            }
        }
    }
}