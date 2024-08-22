import java.util.*;
import java.io.*;

class Node{
    int num;
    List<Node> nodeList;

    public Node(int num) {
        this.num = num;
        this.nodeList = new ArrayList<>();
    }
}

class Main {
    static int result = 0;
    static Node[] node;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        node = new Node[n];
        for(int i = 0; i < n; i++)
            node[i] = new Node(i);
        int rootNode = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) {
                rootNode = i;
                continue;
            }
            node[num].nodeList.add(node[i]);
        }
        int deleteNode = Integer.parseInt(br.readLine());
        if(rootNode == deleteNode)
            sb.append(result);
        else {
            bfs(rootNode, deleteNode);
            sb.append(result);
        }
        
        System.out.println(sb);
    }

    static void bfs(int rootNode, int deleteNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node[rootNode]);
        while(!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowQueueSize = queue.size();

            for(Node next : nowNode.nodeList) {
                if(next.num == deleteNode)
                    continue;
                queue.offer(next);
            }
            if(nowQueueSize == queue.size())
                result++;
        }
    }
}