import java.util.*;
import java.io.*;

class Main {
    final static int INF = 400 * 10000 + 1;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        arr = new int[V+1][V+1];
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                arr[i][j] = INF;
            }
            arr[i][i] = 0;
        }
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int min = INF*2;
        for(int i = 1; i <= V-1; i++) {
            for(int j = i+1; j <= V; j++) {
                if(arr[i][j] == INF || arr[j][i] == INF)
                    continue;
                min = Math.min(min, arr[i][j] + arr[j][i]);
            }
        }
        if(min == INF*2)
            sb.append(-1);
        else
            sb.append(min);
        System.out.println(sb);
    }
}