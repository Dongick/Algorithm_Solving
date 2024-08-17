import java.util.*;
import java.io.*;

class Node {
    int next;
    int weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

class Main {
    static List<List<Node>> list = new ArrayList<>();
    static boolean[] check;
    static int max = 0;
    static int index = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        check = new boolean[n+1];
        dfs(1, 0);
        check = new boolean[n+1];
        dfs(index, 0);
        sb.append(max);
        System.out.println(sb);
    }

    static void dfs(int num, int cost) {
        if(max < cost) {
            max = cost;
            index = num;
        }
        check[num] = true;
        
        for(Node node : list.get(num)) {
            if(!check[node.next])
                dfs(node.next, cost + node.weight);
        }
    }
}