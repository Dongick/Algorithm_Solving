import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[6];
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count2 = n * 4 + (n - 2) * 4;
        int count3 = 4;
        long count1 = (long)n * n * 5 - count2 - count3;

        if(n == 1) {
            Arrays.sort(arr);
            int sum = 0;
            for(int i = 0; i < 5; i++)
                sum += arr[i];
            System.out.println(sum);
            return;
        }
        int[] num = new int[3];

        for(int i = 0; i < 3; i++) {
            if(arr[i] < arr[5-i])
                num[i] = arr[i];
            else
                num[i] = arr[5-i];
        }
        Arrays.sort(num);
        System.out.println(num[0] * count1 + num[1] * count2 + num[2] * count3);
    }
}