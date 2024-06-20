import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int distance = distance(x1, y1, x2, y2);
            condition(r1, r2, distance);
        }
    }
    
    // 두 중점 사이의 거리를 구하는 함수
    static int distance(int x1, int y1, int x2, int y2) {
        return (int)(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
    
    // 조건에 따라 결과 출력 함수
    static void condition(int r1, int r2, int distance) {
        if(distance == 0 && r1 == r2) { // 두 원이 일치할 때
            System.out.println(-1);
        } else if(Math.pow(r1 + r2, 2) > distance && Math.pow(r1 - r2, 2) < distance) { // 두 원이 두점에서 만날 때
            System.out.println(2);
        } else if(Math.pow(r1 + r2, 2) == distance || Math.pow(r1 - r2, 2) == distance) { // 두 원이 한점에서 만날 때
            System.out.println(1);
        } else { // 두 원이 만나지 않을 때
            System.out.println(0);
        }
    }
}