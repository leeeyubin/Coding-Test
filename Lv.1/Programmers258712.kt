class Solution {
   fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val size = friends.size
      
        val friendIndexMap = mutableMapOf<String, Int>()
        friends.forEachIndexed { index, name ->
            friendIndexMap[name] = index
        }

        val graph = Array(size) { IntArray(size) }

        for (gift in gifts) {
            val (giver, receiver) = gift.split(" ") 
            val giverIndex = friendIndexMap[giver]!!
            val receiverIndex = friendIndexMap[receiver]!!
            graph[giverIndex][receiverIndex]++
        }

        val givenCount = IntArray(size) 
        val receivedCount = IntArray(size)
        val giftIndex = IntArray(size)    

        for (i in 0 until size) { 
            for (j in 0 until size) { 
                givenCount[i] += graph[i][j] 
                receivedCount[j] += graph[i][j] 
            }
        }

        for (i in 0 until size) {
            giftIndex[i] = givenCount[i] - receivedCount[i]
        }

        val nextMonthReceive = IntArray(size)

        for (i in 0 until size) {
            for (j in i + 1 until size) {
                val ij = graph[i][j]
                val ji = graph[j][i]

                when {
                    ij > ji -> nextMonthReceive[i]++
                    
                    ij < ji -> nextMonthReceive[j]++
                    
                    else -> {
                         if (giftIndex[i] > giftIndex[j]) nextMonthReceive[i]++
                         else if (giftIndex[i] < giftIndex[j]) nextMonthReceive[j]++
                    }
                }
            }
        }

        val answer = nextMonthReceive.maxOrNull() ?: 0
        return answer
    }
}
