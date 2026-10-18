class Solution {
    public int solution(int n) {
        int divide = 1234567;

        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % divide;

            prev = curr;
            curr = next;
        }

        return curr;
    }
}
