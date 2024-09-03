import java.util.*;

class Solution {
    static int n;
    static int m;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        n = users.length;
        m = emoticons.length;
        int[] discountArr = new int[m];
        Arrays.fill(discountArr, 10);
        discountArr[0] = 0;
        
        int count = 0;
        int idx = 0;
        int max = (int)Math.pow(4, m);
        while(count < max) {
            if(discountArr[idx] != 40)
                discountArr[idx] += 10;
            else {
                while(discountArr[idx] == 40)
                    idx++;
                discountArr[idx] += 10;
                for(int i = idx - 1; i >= 0; i--)
                    discountArr[i] = 10;
                idx = 0;
            }
            
            int[] arr = func(discountArr, emoticons, users);
            
            if(answer[0] < arr[0]) {
                answer = arr;
            } else if(answer[0] == arr[0])
                answer[1] = Math.max(arr[1], answer[1]);
            
            count++;
        }
            
        return answer;
    }
    
    static int[] func(int[] discountArr, int[] emoticons, int[][] users) {
        int[] arr = new int[2];
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < m; j++) {
                if(users[i][0] <= discountArr[j]) {
                    max += emoticons[j] * (100 - discountArr[j]) / 100;
                } 
            }
            if(users[i][1] <= max)
                arr[0]++;
            else
                arr[1] += max;
        }
        
        return arr;
    }
}