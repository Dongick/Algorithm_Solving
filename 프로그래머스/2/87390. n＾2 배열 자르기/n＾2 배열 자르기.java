class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        int xStartIdx = (int)(left / n);
        int yStartIdx = (int)(left % n);
        int xEndIdx = (int)(right / n);
        int yEndIdx = (int)(right % n);
        
        int idx = 0;
        for(int i = xStartIdx; i <= xEndIdx; i++) {
            for(int j = 0; j < n; j++) {
                if(i == xStartIdx) {
                    if(j < yStartIdx)
                        continue;
                }
                if(i == xEndIdx) {
                    if(j > yEndIdx)
                        continue;
                }
                answer[idx] = (i > j) ? i + 1 : j + 1;
                idx++;
            }
        } 
        return answer;
    }
}