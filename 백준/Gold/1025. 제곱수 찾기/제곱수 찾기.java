import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = -1;
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) { // 각 숫자를 배열에 입력
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        
        for(int i = 0; i < n; i++) { // 배열의 행
            for(int j = 0; j < m; j++) { // 배열의 열
                for(int di = -n; di < n; di++) { // 행 등차
                    for(int dj = -m; dj < m; dj++) { // 열 등차
                        if(di == 0 && dj == 0) // 행과 열의 등차 모두 0일 때
                            continue;
                        
                        int moveI = i; // 행을 등차만큼 이동시킨 후의 행의 값
                        int moveJ = j; // 열을 등차만큼 이동시킨 후의 열의 값
                        int num = 0;
                        // 배열 범위안에 포함되면
                        while(moveI >= 0 && moveJ >= 0 && moveI < n && moveJ < m) {
                            num = num * 10 + arr[moveI][moveJ];
                            
                            int check = (int)Math.sqrt(num); // 완전 제곱근 체크
                            if(check * check == num)
                                result = Math.max(result, num);
                            moveI += di;
                            moveJ += dj;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}