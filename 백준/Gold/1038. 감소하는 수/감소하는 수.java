import java.util.*;
import java.io.*;

class Main {
    static int[] arr = {0, 10, 55, 175, 385, 637, 847, 967, 1012, 1022};
    static int digit;
    static List<Integer> list = new ArrayList<>();
    static int temp = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n > 1022) {
            System.out.println(-1);
            return;
        } else if(n == 1022) {
            System.out.println("9876543210");
            return;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] <= n && arr[i + 1] > n) {
                digit = i + 1;
                break;
            }
        }
        dfs(9, 0);
        Collections.sort(list);
        System.out.println(list.get(n - arr[digit-1]));
    }

    static void dfs(int num, int count) {
        if(count == digit) {
            list.add(temp);
            return;
        }
        if(num < 0)
            return;

        temp = temp * 10 + num;
        dfs(num-1, count+1);
        temp /= 10;
        dfs(num-1, count);
    }
}