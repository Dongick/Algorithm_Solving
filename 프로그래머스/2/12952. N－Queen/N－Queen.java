import java.util.*;

class Solution {
    static int result = 0;
    static boolean[] y;
    
    public int solution(int n) {
        int answer = 0;
        y = new boolean[n];
        func(0, n, new ArrayList<int[]>());
        answer = result;
        return answer;
    }
    
    static void func(int count, int n, List<int[]> list) {
        if(count == n) {
            result++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!y[i] && func2(count, i, n, list)) {
                y[i] = true;
                list.add(new int[] {count, i});
                func(count+1, n, list);
                y[i] = false;
                list.remove(count);
            }
        }
    }
    
    static boolean func2(int x, int y, int n, List<int[]> list) {
        for(int[] num : list) {
            if(Math.abs(x - num[0]) == Math.abs(y - num[1]))
                return false;
        }
        return true;
    }
}