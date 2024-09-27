import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1 , o2) -> o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {targets[0][0], targets[0][1]});
        
        for(int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            boolean check = false;
            
            for(int j = 0; j < list.size(); j++) {
                int left = list.get(j)[0];
                int right = list.get(j)[1];
                if(left >= e || right <= s)
                    continue;
                if(left <= s && right >= e) {
                    list.set(j, new int[] {s, e});
                    check = true;
                    break;
                } else if(left <= s && right <= e) {
                    list.set(j, new int[] {s, right});
                    check = true;
                     break;
                } else if(left >= s && right >= e) {
                    list.set(j, new int[] {left, e});
                    check = true;
                    break;
                } else if(left >= s && right <= e) {
                    check = true;
                    break;
                }
            }
            
            if(!check) {
                list.add(new int[] {s, e});
            }
        }
        
        int answer = list.size();
        return answer;
    }
}