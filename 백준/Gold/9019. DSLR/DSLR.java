import java.util.*;
import java.io.*;

class Main {
    static int[] trace;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trace = new int[10000];
            arr = new int[10000];
            for(int i = 0; i < 10000; i++)
                arr[i] = 10000;
            
            int count = bfs(a, b);
            
            char[] result = new char[count];
            int num = b;
            while(count > 0) {
                int temp = trace[num];
                if(DSLR('D', temp) == num)
                    result[count-1] = 'D';
                else if(DSLR('S', temp) == num)
                    result[count-1] = 'S';
                else if(DSLR('L', temp) == num)
                    result[count-1] = 'L';
                else
                    result[count-1] = 'R';
                count--;
                num = temp;
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
        arr[a] = 0;

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(check[num])
                continue;
            check[num] = true;

            int D = DSLR('D', num);
            int S = DSLR('S', num);
            int L = DSLR('L', num);
            int R = DSLR('R', num);
            if(!check[D] && arr[D] > arr[num] + 1) {
                arr[D] = arr[num] + 1;
                trace[D] = num;
                queue.offer(D);
            }
            if(!check[S] && arr[S] > arr[num] + 1) {
                arr[S] = arr[num] + 1;
                trace[S] = num;
                queue.offer(S);
            }
            if(!check[L] && arr[L] > arr[num] + 1) {
                arr[L] = arr[num] + 1;
                trace[L] = num;
                queue.offer(L);
            }
            if(!check[R] && arr[R] > arr[num] + 1) {
                arr[R] = arr[num] + 1;
                trace[R] = num;
                queue.offer(R);
            }
        }
        return arr[b];
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
            int d1 = num / 1000;
            num %= 1000;
            int d2 = num / 100;
            num %= 100;
            int d3 = num / 10;
            int d4 = num % 10;
            return d2 * 1000 + d3 * 100 + d4 * 10 + d1;
        }
        else {
            int d1 = num / 1000;
            num %= 1000;
            int d2 = num / 100;
            num %= 100;
            int d3 = num / 10;
            int d4 = num % 10;
            return d4 * 1000 + d1 * 100 + d2 * 10 + d3;
        }
    }
}