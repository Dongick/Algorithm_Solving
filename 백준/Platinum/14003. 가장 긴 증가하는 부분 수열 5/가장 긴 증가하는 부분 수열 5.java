import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int[] trace;
    static List<int[]> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        trace = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        int maxIdx = 1;
        list.add(new int[] {1, arr[1]});
        for(int i = 2; i <= n; i++) {
            if(list.get(idx)[1] < arr[i]) {
                list.add(new int[] {i, arr[i]});
                trace[i] = list.get(idx)[0];
                maxIdx = i;
                idx++;
            } else {
                int index = BinarySearch(0, idx, arr[i]);
                list.set(index, new int[] {i, arr[i]});
                if(index > 0)
                    trace[i] = list.get(index-1)[0];
                if(idx == 0)
                    maxIdx = i;
            }
        }
        sb.append(idx+1).append("\n");
        Stack<Integer> stack = new Stack<>();
        while(maxIdx > 0) {
            stack.push(arr[maxIdx]);
            maxIdx = trace[maxIdx];
        }
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }

    static int BinarySearch(int start, int end, int num) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(list.get(mid)[1] < num)
                start = mid + 1;
            else
                end = mid;
        }
        
        return end;
    }
}