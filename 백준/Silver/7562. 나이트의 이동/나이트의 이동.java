import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int l;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            arr = new int[l][l];
            sb.append(bfs(startX, startY, endX, endY) - 1).append("\n");
        }
        
        System.out.println(sb);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        arr[startX][startY] = 1;
        
        while(!queue.isEmpty() && arr[endX][endY] == 0) {
            int[] num = queue.poll();
            for(int i = 0; i < 8; i++) {
                int x = num[0] + dx[i];
                int y = num[1] + dy[i];
                if(x < 0 || y < 0 || x >= l || y >= l)
                    continue;
                if(arr[x][y] == 0) {
                    queue.offer(new int[] {x, y});
                    arr[x][y] = arr[num[0]][num[1]] + 1;
                }
            }
        }
        return arr[endX][endY];
    }
}