import java.util.*;
import java.io.*;

class Main {
    static boolean[] check;
    static boolean[][] alpabat;
    static List<Integer> list = new ArrayList<>();
    static int result = 0;
    static int n, k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        alpabat = new boolean[n][26];
        check = new boolean[26];
        int count = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c != 'a' && c != 'c' && c != 'i' && c != 'n' && c != 't' && !alpabat[i][c-'a']) {
                    alpabat[i][c-'a'] = true;
                    if(!check[c-'a']) {
                        check[c-'a'] = true;
                        count++;
                    }
                }
                    
            }
        }

        if(k < 5)
            sb.append(0);
        else if(count <= k - 5)
            sb.append(n);
        else {
            k = k - 5;
            func(0);
            sb.append(result);
        }
        System.out.println(sb);
    }

    static void func(int idx) {
        if(list.size() == k) {
            func2();
            return;
        }
        for(int i = idx; i < 26; i++) {
            if(check[i]) {
                list.add(i);
                func(i+1);
                list.remove(Integer.valueOf(i));
            }
        }
    }

    static void func2() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 26; j++) {
                if(alpabat[i][j] && list.indexOf(j) == -1) {
                    count++;
                    break;
                }
            }
        }
        result = Math.max(result, n - count);
    }
}