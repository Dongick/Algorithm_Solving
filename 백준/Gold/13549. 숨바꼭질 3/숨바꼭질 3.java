import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int idx;
    int second;

    public Node(int idx, int second) {
        this.idx = idx;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        return this.second - o.second;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append(bfs(n, k));
        System.out.println(sb);
    }

    static int bfs(int n, int k) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(n, 0));
        boolean[] check = new boolean[100001];
        int result = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(check[current.idx])
                continue;
            check[current.idx] = true;

            if(current.idx == k) {
                result = current.second;
                break;
            }

            if(current.idx - 1 >= 0) {
                queue.offer(new Node(current.idx - 1, current.second + 1));
            }
            if(current.idx + 1 <= 100000) {
                queue.offer(new Node(current.idx + 1, current.second + 1));
            }
            if(current.idx*2 <= 100000) {
                queue.offer(new Node(current.idx*2, current.second));
            }
        }
        return result;
    }
}