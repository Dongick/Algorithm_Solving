import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int distance = y - x; // 두 점 사이의 거리
            double halfDistance = (double)distance * 0.5; // 두 점 사이의 거리의 절반
            
            calc(halfDistance);
        }
    }
    
    // 계산 함수
    // distance가 10이면 halfDistance = 5 이므로 sum 값은 1 -> 3 이렇게 변화
    // halfDistance와 sum의 차이 값과 i 값의 비교를 통해 몇번 통과해야 하는지 결정
    static void calc(double halfDistance) {
        int sum = 0;
        int i = 1;
        double reminder;
        // 두 점 사이의 거리의 절반에 도달 할 때까지 i값을 1씩 증가시키면서 합계에 더함
        while((double)(sum + i) < halfDistance) {
            sum += i;
            i += 1;
        }
        reminder = halfDistance - sum;
        if(reminder == i) {
            System.out.println(i * 2);
        } else if(i >= (int)(reminder * 2)) {
            System.out.println((i - 1) * 2 + 1);
        } else {
            System.out.println((i - 1) * 2 + 2);
        } 
    }
}