import java.io.*;
import java.util.*;

class Node{
    char data;
    Node left;
    Node right;
    
    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Main{
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    
    static void preorder(Node node) {
        if(node == null)
            return;
        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    
    static void inorder(Node node) {
        if(node == null)
            return;
        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }
    
    static void postorder(Node node) {
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            if(tree[data - 'A'] == null)
                tree[data - 'A'] = new Node(data);
            if(left != '.') {
                if(tree[left - 'A'] == null)
                    tree[left - 'A'] = new Node(left);
                tree[data - 'A'].left = tree[left - 'A'];
            }
            if(right != '.') {
                if(tree[right - 'A'] == null)
                    tree[right - 'A'] = new Node(right);
                tree[data - 'A'].right = tree[right - 'A'];
            }
        }
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        sb.append("\n");
        System.out.println(sb);
    }
}