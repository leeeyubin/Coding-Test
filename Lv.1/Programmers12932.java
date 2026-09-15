class Solution {
    public int[] solution(long n) {
        int nLength = String.valueOf(n).length();
        int[] answer = new int[nLength];
        long divider = 1;
        
        for(int i =1; i < nLength; i++) divider *= 10;
        
        for(int i = nLength; i > 0; i--) {
            answer[i-1]= (int) (n / divider);
            n %= divider;
            divider /= 10;
        }
        
        return answer;
    }
}
