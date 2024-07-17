import java.util.*;
import java.io.*;

class Main {
    static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            char[] arr = br.readLine().toCharArray();
            count = 0;
            if(recurstion(arr, 0, arr.length - 1))
                sb.append(1);
            else
                sb.append(0);
            sb.append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static boolean recurstion(char[] arr, int left, int right) {
        count ++;
        if(left >= right)
            return true;
        if(arr[left] == arr[right])
            return recurstion(arr, left+1, right-1);
        return false;
    }
}