import java.io.*;
import java.util.*;

class Main{
    static long[] arr;
    static long[] tree;
    
    static long init(int start, int end, int node) {
        if(start == end)
            return tree[node] = arr[start];
        else {
            int mid = (start + end) / 2;
            return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
        }
    }
    
    static void update(int start, int end, int node, int idx, long diff) {
        if(idx < start || idx > end)
            return;
        tree[node] += diff;
        if(start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node*2, idx, diff);
            update(mid+1, end, node*2+1, idx, diff);
        }
    }
    
    static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start)
            return 0;
        if(left <= start && right >= end)
            return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));  // 트리의 높이
        tree = new long[(int)Math.pow(2, h+1)];
        
        init(1, n, 1);
        
        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[b];
                arr[b] = c;
                update(1, n, 1, b, diff);
            } else {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(sum(1, n, 1, b, c));
            }
        }
    }
}