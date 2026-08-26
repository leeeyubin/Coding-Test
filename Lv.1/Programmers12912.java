class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == 1 && b == 1) return 1;
        
        if(a == b) return a;
       
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        
        long num = max - min + 1;
        
        answer = (num * (max + min)) / 2;
        
        return answer;
    }
}
