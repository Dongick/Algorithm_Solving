import java.util.*;
import java.io.*;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Main {
    static List<Edge> list = new ArrayList<>();
    static long[] dist;
    final static long INF = 500L * 6000 * 10000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
        }
        dist = new long[n+1];
        for(int i = 1; i <= n; i++)
            dist[i] = INF;
        dist[1] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(Edge edge : list) {
                if(dist[edge.start] == INF)
                    continue;

                if(dist[edge.end] > dist[edge.start] + edge.weight) {
                    dist[edge.end] = dist[edge.start] + edge.weight;

                    if(i == n) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(dist[i] == INF)
                sb.append(-1).append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}