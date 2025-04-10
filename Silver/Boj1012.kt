import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val (m, n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
        val graph = Array(n+1) { IntArray(m+1) }
        val visited = Array(n+1) { BooleanArray(m+1) }

        repeat(k) {
           val (x, y) = bufferedReader.readLine().split(" ").map { it.toInt() }
            graph[y][x] = 1
        }
        
        var count = 0
        for (i in 0..<n) {
            for(j in 0..<m) {
                if(graph[i][j] == 1 && !visited[i][j]){
                    bfs(x = i, y = j, graph = graph, visited = visited)
                    count ++
                }
            }
        }
        println(count)
    }

    bufferedReader.close()
}

private fun bfs(x: Int, y: Int, graph: Array<IntArray>, visited: Array<BooleanArray>) {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val queue = ArrayDeque<Pair<Int, Int>>()

    queue.addLast(Pair(x, y))

    while(queue.isNotEmpty()) {
        val (currentX, currentY) = queue.removeFirst()

        for (i in 0 ..< 4) {
            val nextX = currentX + dx[i]
            val nextY = currentY + dy[i]

            if(nextX in 0 .. graph.size && nextY in 0 ..graph[0].size) { 
                if(graph[nextX][nextY]== 1 && !visited[nextX][nextY]){ 
                    queue.addLast(Pair(nextX, nextY))
                    visited[nextX][nextY] = true
                }
            }
        }
    }
}
