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
            String s = Integer.toString(N).repeat(i);
            if(Integer.parseInt(s) <= max) {
                visited[Integer.parseInt(s)] = true;
                list.get(i).add(Integer.parseInt(s));
                if(Integer.parseInt(s) == number)
                    return i;
            }
                
            int lo = 1;
            int hi = i - 1;
            while(lo <= hi) {
                for(int num1 : list.get(lo)) {
                    for(int num2 : list.get(hi)) {
                        int num = num1+num2;
                        if(!visited[num]) {
                            list.get(i).add(num);
                            visited[num] = true;
                            if(num == number)
                                return i;
                        }
                        num = Math.abs(num1-num2);
                        if(!visited[num]) {
                            list.get(i).add(num);
                            visited[num] = true;
                            if(num == number)
                                return i;
                        }
                        num = num1*num2;
                        if(num <= max && !visited[num]) {
                            list.get(i).add(num);
                            visited[num] = true;
                            if(num == number)
                                return i;
                        }
                        if(num1 != 0 && num2 != 0) {
                            num = Math.max(num1, num2) / Math.min(num1, num2);
                            if(!visited[num]) {
                                list.get(i).add(num);
                                visited[num] = true;
                                if(num == number)
                                    return i;
                            }
                        }
                    }
                }
                hi--;
                lo++;
            }
        }
        
        return -1;
    }
}