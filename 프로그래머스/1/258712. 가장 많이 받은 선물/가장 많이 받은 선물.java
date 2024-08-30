class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] giftPower = new int[friends.length];
        int[][] arr = new int[friends.length][friends.length];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");

            int idx = 0;
            for(int j = 0; j < friends.length; j++) {
                if(s[0].equals(friends[j])) {
                    giftPower[j]++;
                    idx = j;
                    break;
                }
            }
            for(int j = 0; j < friends.length; j++) {
                if(s[1].equals(friends[j])) {
                    giftPower[j]--;
                    arr[idx][j]++;
                    break;
                }
            }
        }
        
        int[] result = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for(int j = i+1; j < friends.length; j++) {
                if(arr[i][j] > arr[j][i]) {
                    result[i]++;
                } else if(arr[i][j] < arr[j][i])
                    result[j]++;
                else {
                    if(giftPower[i] > giftPower[j])
                        result[i]++;
                    else if(giftPower[i] < giftPower[j])
                        result[j]++;
                    else
                        continue;
                }
            }
        }
        for(int i = 0; i < friends.length; i++)
            answer = Math.max(answer, result[i]);
        return answer;
    }
}