class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int start = 1; start <= n; start++) {
            int total = 0;

            for (int i = start; i <= n; i++) {
                total += i;

                if (total == n) {
                    answer++;
                    break;
                }

                if (total > n) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
