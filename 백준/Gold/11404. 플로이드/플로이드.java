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
    final static int INF = 100 * 100000;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());
        dist = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        for(int i = 1; i <= n; i++) {
            dijkstra(i);
            for(int j = 1; j <= n; j++) {
                if(dist[j] == INF)
                    sb.append(0).append(" ");
                else
                    sb.append(dist[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int num) {
        Queue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            dist[i] = INF;
        queue.offer(new Node(num, 0));
        dist[num] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(check[node.end])
                continue;
            check[node.end] = true;

            for(Node next : list.get(node.end)) {
                if(!check[next.end] && dist[next.end] > dist[node.end] + next.weight) {
                    dist[next.end] = dist[node.end] + next.weight;
                    queue.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}