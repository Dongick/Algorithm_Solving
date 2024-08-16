import java.util.*;
import java.io.*;

class Main {
    static int[][] trace;
    static int[][] arr;
    static final int INF = 100 * 100000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        trace = new int[n+1][n+1];
        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = INF;
            }
            arr[i][i] = 0;
        }
            
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] > c) {
                arr[a][b] = c;
                trace[a][b] = b;
            }
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if(k == i) continue;
                for(int j = 1; j <= n; j++) {
                    if(k == j || i == j) continue;
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        int x = i;
                        int y = k;
                        while(true) {
                            int num = trace[x][y];
                            if(num == y)
                                break;
                            y = num;
                        }
                        trace[i][j] = y;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == INF)
                    sb.append(0).append(" ");
                else
                    sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j || trace[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }
                
                int x = i;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(x);
                while(x != j) {
                    x = trace[x][j];
                    queue.offer(x);
                }
                
                sb.append(queue.size()).append(" ");
                while(!queue.isEmpty()) {
                    sb.append(queue.poll()).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}