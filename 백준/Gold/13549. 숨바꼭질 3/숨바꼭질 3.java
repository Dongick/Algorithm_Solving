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
    static int[] arr = new int[100001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i <arr.length; i++)
            arr[i] = -1;

        bfs(n, k);
        sb.append(arr[k]);
        System.out.println(sb);
    }

    static void bfs(int n, int k) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(n, 0));
        arr[n] = 0;
        boolean[] check = new boolean[100001];

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(check[current.idx])
                continue;
            check[current.idx] = true;

            if(current.idx - 1 >= 0 && (arr[current.idx - 1] == -1 || arr[current.idx - 1] > current.second + 1)) {
                arr[current.idx - 1] = current.second + 1;
                queue.offer(new Node(current.idx - 1, current.second + 1));
            }
            if(current.idx + 1 <= 100000 && (arr[current.idx + 1] == -1 || arr[current.idx + 1] > current.second + 1)) {
                arr[current.idx + 1] = current.second + 1;
                queue.offer(new Node(current.idx + 1, current.second + 1));
            }
            if(current.idx*2 <= 100000 && (arr[current.idx*2] == -1 || arr[current.idx*2] > current.second)) {
                arr[current.idx*2] = current.second;
                queue.offer(new Node(current.idx*2, current.second));
            }
        }
    }
}