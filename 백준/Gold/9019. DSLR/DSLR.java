import java.util.*;
import java.io.*;

class Main {
    static int[] trace;
    static char[] traceDSLR;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trace = new int[10000];
            traceDSLR = new char[10000];
            
            int count = bfs(a, b);
            
            char[] result = new char[count];
            int num = b;
            while(count > 0) {
                result[count-1] = traceDSLR[num];
                num = trace[num];
                count--;
            }
            for(char alpa : result)
                sb.append(alpa);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static int bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        boolean[] check = new boolean[10000];
        check[a] = true;
        int count = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int num = queue.poll();
        
                int D = DSLR('D', num);
                int S = DSLR('S', num);
                int L = DSLR('L', num);
                int R = DSLR('R', num);
                if(!check[D]) {
                    trace[D] = num;
                    traceDSLR[D] = 'D';
                    queue.offer(D);
                    check[D] = true;
                }
                if(!check[S]) {
                    trace[S] = num;
                    traceDSLR[S] = 'S';
                    queue.offer(S);
                    check[S] = true;
                }
                if(!check[L]) {
                    trace[L] = num;
                    traceDSLR[L] = 'L';
                    queue.offer(L);
                    check[L] = true;
                }
                if(!check[R]) {
                    trace[R] = num;
                    traceDSLR[R] = 'R';
                    queue.offer(R);
                    check[R] = true;
                }
                if(D == b || S == b || L == b || R == b)
                    return count;
            }
            count++;
        }
        return count;
    }

    static int DSLR(char command, int num) {
        if(command == 'D') {
            num *= 2;
            return (num > 9999) ? num % 10000 : num;
        }
        else if(command == 'S') {
            return (num == 0) ? 9999 : num - 1;
        }
        else if(command == 'L') {
            int n = num / 1000;
            num %= 1000;
            return num * 10 + n;
        }
        else {
            int n = num % 10;
            num = num / 10;
            return n * 1000 + num;
        }
    }
}