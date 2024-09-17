class Solution {
    static char[] nameArr;
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    
    public int solution(String name) {
        int answer = 0;
        nameArr = new char[name.length()];
        visited = new int[name.length()];
        char[] arr = new char[name.length()];
        
        for(int i = 0; i < name.length(); i++) {
            nameArr[i] = name.charAt(i);
            arr[i] = 'A';
        }
            
        visited[0]++;
        
        func(0, 0, arr);
        answer = min;
        
        return answer;
    }
    
    static void func(int count, int idx, char[] arr) {
        if(visited[idx] > 2)
            return;
        
        boolean check = true;
        for(int i = 0; i < nameArr.length; i++) {
            if(arr[i] != nameArr[i]) {
                check = false;
                break;
            }
        }
        if(check) {
            min = Math.min(count, min);
            return;
        }
        
        if(arr[idx] != nameArr[idx]) {
            int num = nameArr[idx] - 'A';
            int minCount = Math.min(num, 26 - num);
            arr[idx] = nameArr[idx];
            func(count+minCount, idx, arr);
            arr[idx] = 'A';
        } else {
            int leftIdx = (idx == 0) ? nameArr.length - 1 : idx - 1;
            visited[leftIdx]++;
            func(count+1, leftIdx, arr);
            visited[leftIdx]--;

            int rightIdx = (idx == nameArr.length - 1) ? 0 : idx + 1;
            visited[rightIdx]++;
            func(count+1, rightIdx, arr);
            visited[rightIdx]--;
        }
    }
}