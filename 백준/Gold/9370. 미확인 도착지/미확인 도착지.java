import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int next;
    int weight;

    public Node(int next, int weight) {
        this.next = next;
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
    static int n;
    final static int INF =  50000 * 1000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i = 0; i <= n; i++)
                list.add(new ArrayList<>());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list.get(a).add(new Node(b, d));
                list.get(b).add(new Node(a, d));
            }
            List<Integer> result = new ArrayList<>();
            dist = new int[n+1];
            
            for(int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                int shortPass1 = bfs(s, x);
                int shortPass2 = Math.min(bfs(s, g) + bfs(g, h) + bfs(h, x), bfs(s, h) + bfs(h, g) + bfs(g, x));
                if(shortPass1 == shortPass2)
                    result.add(x);
            }
            Collections.sort(result);

            for(int i : result)
                sb.append(i).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            dist[i] = INF;
        dist[start] = 0;
        queue.offer(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(check[node.next])
                continue;
            check[node.next] = true;

            for(Node next : list.get(node.next)) {
                if(!check[next.next] && dist[next.next] > dist[node.next] + next.weight) {
                    dist[next.next] = dist[node.next] + next.weight;
                    queue.offer(new Node(next.next, dist[next.next]));
                }
                    
            }
        }
        return dist[end];
    }
}