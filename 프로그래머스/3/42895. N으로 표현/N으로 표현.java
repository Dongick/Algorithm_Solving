import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(number == N)
            return 1;
        int max = 9 * 32000;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 8; i++)
            list.add(new ArrayList<>());
        list.get(1).add(N);
        boolean[] visited = new boolean[max+1];
        visited[N] = true;
        
        for(int i = 2; i <= 8; i++) {
            int lo = 1;
            int hi = i - 1;
            while(lo <= hi) {
                for(int num1 : list.get(lo)) {
                    for(int num2 : list.get(hi)) {
                        int[] num = {num1+num2, Math.abs(num1-num2), num1*num2, Math.max(num1, num2) / Math.min(num1, num2), Integer.parseInt(Integer.toString(N).repeat(i))};
                        for(int j = 0; j < 5; j++) {
                            if(num[j] != 0 && num[j] <= max && !visited[num[j]]) {
                                list.get(i).add(num[j]);
                                visited[num[j]] = true;
                            }
                        }
                    }
                }
                hi--;
                lo++;
            }
            if(list.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
}