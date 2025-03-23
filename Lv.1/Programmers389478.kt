class Solution {
   fun solution(n: Int, w: Int, num: Int): Int {
       var height = (num - 1) / w + 1
       var position = (num - 1) % w + 1
       var answer: Int = 0
       
       while(true) {
           val value = w * (height - 1) + position
           
           if(n >= value) answer ++
           else break;
           
           height ++
           position = w - position + 1
       }
       
       return answer
    }   
}
