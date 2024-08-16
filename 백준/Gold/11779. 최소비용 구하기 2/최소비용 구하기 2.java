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
    static List<List<Node>> list = new ArrayList<>();
    static int[] trace;
    static int[] arr;
    static int n;
    static final int INF = 1000 * 100000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        trace = new int[n+1];
        arr = new int[n+1];
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            arr[i] = INF;
        }
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int cost = bfs(start, end);
        sb.append(cost).append("\n");

        Stack<Integer> stack = new Stack<>();
        int num = end;
        while(num != start) {
            stack.push(num);
            num = trace[num];
        }
        stack.push(start);

        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        boolean[] check = new boolean[n+1];
        arr[start] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(check[node.end])
                continue;
            check[node.end] = true;

            for(Node next : list.get(node.end)) {
                if(!check[next.end] && arr[next.end] > arr[node.end] + next.weight) {
                    arr[next.end] = arr[node.end] + next.weight;
                    trace[next.end] = node.end;
                    queue.offer(new Node(next.end, arr[next.end]));
                }
            }
        }

        return arr[end];
    }
}