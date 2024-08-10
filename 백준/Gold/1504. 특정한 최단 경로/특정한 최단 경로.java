import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

class Main {
    static List<List<Node>> list;
    static int[] dist;
    static int N;
    final static int INF = 200000 * 1000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        
        int result = Math.min(bfs(1, v1) + bfs(v1, v2) + bfs(v2, N), bfs(1, v2) + bfs(v2, v1) + bfs(v1, N));

        if(result >= INF)
            sb.append(-1);
        else
            sb.append(result);
        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        for(int i = 1; i <= N; i++)
            dist[i] = INF;
        
        dist[start] = 0;
        boolean[] check = new boolean[N+1];

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(check[n.end])
                continue;
            check[n.end] = true;
            for(Node node : list.get(n.end)) {
                if(dist[node.end] > dist[n.end] + node.weight) {
                    dist[node.end] = dist[n.end] + node.weight;
                    queue.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];
    }
}