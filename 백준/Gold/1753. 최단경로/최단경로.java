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
    static int V;
    static List<Node>[] list;
    static int[] result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        result = new int[V+1];
        for(int i = 1; i <= V; i++)
            result[i] = Integer.MAX_VALUE;
        
        bfs(K);

        for(int i = 1; i <= V; i++) {
            if(result[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int K) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, 0));
        result[K] = 0;
        boolean[] check = new boolean[V+1];

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(check[n.end])
                continue;
            check[n.end] = true;
            for(Node node : list[n.end]) {
                if(result[node.end] > result[n.end] + node.weight) {
                    result[node.end] = result[n.end] + node.weight;
                    queue.offer(new Node(node.end, result[node.end]));
                }
            }
        }
    }
}