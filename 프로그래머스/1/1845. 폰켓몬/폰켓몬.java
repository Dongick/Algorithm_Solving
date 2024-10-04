import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        if(set.size() <= n/2)
            answer = set.size();
        else
            answer = n/2;
        return answer;
    }
}