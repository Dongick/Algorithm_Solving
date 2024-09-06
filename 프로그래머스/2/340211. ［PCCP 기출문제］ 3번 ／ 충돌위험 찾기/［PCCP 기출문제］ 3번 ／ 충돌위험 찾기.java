import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length;
        int m = routes[0].length;
        int[][] arr = new int[x][2];
        int[] num = new int[x];
        boolean[] check = new boolean[x];
        for(int i = 0; i < x; i++) {
            arr[i][0] = points[routes[i][0] - 1][0];
            arr[i][1] = points[routes[i][0] - 1][1];
            num[i] = 1;
        }
        
        int count = 0;
        while(count < x) {
            answer += func(arr, check, x);
            
            for(int i = 0; i < x; i++) {
                if(check[i])
                    continue;
                int idx = routes[i][num[i]] - 1;
                
                if(arr[i][0] == points[idx][0] && arr[i][1] == points[idx][1]) {
                    num[i]++;
                    if(num[i] == m) {
                        check[i] = true;
                        count++;
                        continue;
                    }
                    idx = routes[i][num[i]] - 1;
                }
                
                if(arr[i][0] == points[idx][0]) {
                    if(arr[i][1] > points[idx][1])
                        arr[i][1]--;
                    else
                        arr[i][1]++;
                } else {
                    if(arr[i][0] > points[idx][0])
                        arr[i][0]--;
                    else
                        arr[i][0]++;
                }
            }
        }
        return answer;
    }
    
    static int func(int[][] arr, boolean[] check, int x) {
        int count = 0;
        
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < x; i++) {
            if(!check[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][0]);
                list.add(arr[i][1]);

                if(map.containsKey(list)) {
                    int num = map.get(list);
                    map.replace(list, num + 1);
                } else
                    map.put(list, 1);
            }
        }
        
        for(List<Integer> key : map.keySet()) {
            if(map.get(key) > 1)
                count++;
        }
        return count;
    }
}