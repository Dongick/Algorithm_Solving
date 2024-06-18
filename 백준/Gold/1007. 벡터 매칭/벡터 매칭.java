import java.io.*;
import java.util.*;

class Main
{
    static double result; // 결과
	static boolean[] check; // 각 점의 양수/음수 유무

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 개수
		while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 점의 개수
			result = Double.MAX_VALUE;
			check = new boolean[n];
            int[][] num = new int[n][2]; // 모든 점의 좌표
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
			    int x = Integer.parseInt(st.nextToken()); // 각 점의 x좌표
                int y = Integer.parseInt(st.nextToken()); // 각 점의 y좌표
				num[i][0] = x;
				num[i][1] = y;
			}
			combination(num, 0, n/2);
			System.out.println(result);
		}
	}
	
    // n개의 점에서 2/n개의 점을 뽑는 조합 함수
	static void combination(int[][] num, int index, int cnt) {
		if (cnt == 0) { // 조합할 원소 갯수가 더 이상 없을 경우
			result = Math.min(result, calc(num));
		} else {
			for (int i = index; i < num.length; i++) {
				check[i] = true;
				combination(num, i + 1, cnt - 1);
				check[i] = false;
			}
		}
	}
	
    // 백터 값 계산 함수
	static double calc(int[][] num)
	{
		int x = 0;
		int y = 0;
		for (int i = 0; i < num.length; i++)
		{
			if (check[i]) { // 양수로 선택된 점일 경우
				x += num[i][0];
				y += num[i][1];
            } else { // 음수로 선택된 점일 경우
				x -= num[i][0];
				y -= num[i][1];
			}
		}
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}