import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int a = 0, b = 0, c = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, n, n);
        sb.append(c).append("\n").append(b).append("\n").append(a);
        System.out.println(sb);
    }

    static void func(int startX, int startY, int endX, int endY) {
        for(int i = startX; i < endX; i++) {
            for(int j = startY; j < endY; j++) {
                if(arr[startX][startY] != arr[i][j]) {
                    int midX = (endX - startX) / 3;
                    int midY = (endY - startY) / 3;
                    func(startX, startY, startX + midX, startY + midY);
                    func(startX, startY + midY, startX + midX, startY + midY*2);
                    func(startX, startY + midY*2, startX + midX, endY);
                    func(startX + midX, startY, startX + midX*2, startY + midY);
                    func(startX + midX, startY + midY, startX + midX*2, startY + midY*2);
                    func(startX + midX, startY + midY*2, startX + midX*2, endY);
                    func(startX + midX*2, startY, endX, startY + midY);
                    func(startX + midX*2, startY + midY, endX, startY + midY*2);
                    func(startX + midX*2, startY + midY*2, endX, endY);
                    return;
                }
            }
        }
        if(arr[startX][startY] == 1)
            a += 1;
        else if(arr[startX][startY] == 0)
            b += 1;
        else
            c += 1;
    }
}