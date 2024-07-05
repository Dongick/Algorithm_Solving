import java.io.*;
import java.util.*;

class Main{
    static List<List<Integer>> list;
    static long[] num;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        num = new long[n];
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            num[i] = 1;
        }
        long gcd;
        StringTokenizer st;
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long p = Integer.parseInt(st.nextToken());
            long q = Integer.parseInt(st.nextToken());
            
            gcd = getGcd(p, q);
            calc(a, b, p / gcd, q / gcd);
        }
        
        gcd = getGcd(num[0], num[1]);
        for(int i = 2; i < n; i++)
            gcd = getGcd(gcd, num[i]);
        for(int i = 0; i < n; i++)
            sb.append(num[i] / gcd).append(" ");
        
        System.out.println(sb);
    }
    
    static long getGcd(long a, long b) {
        while(b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    
    static void calc(int a, int b, long p, long q) {
        boolean[] check = new boolean[n];
        long tempA = num[a];
        long tempB = num[b];
        update(a, tempB * p, check);
        update(b, tempA * q, check);
        list.get(a).add(b);
        list.get(b).add(a);
    }
    
    static void update(int target, long val, boolean[] check) {
        num[target] *= val;
        check[target] = true;
        for(int number : list.get(target)) {
            if(!check[number])
                update(number, val, check);
        }
    }
}