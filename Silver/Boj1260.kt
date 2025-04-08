import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m, v) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1) { IntArray(n+1) }
    val visited = BooleanArray(n+1)

    repeat(m) {
        val (x, y) = bufferedReader.readLine().split(" ").map { it.toInt() }

        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(v, graph, visited)
    println()

    visited.fill(false)
    bfs(v, graph, visited)

    bufferedReader.close()
    bufferedWriter.close()
}

private fun dfs(start: Int,  graph: Array<IntArray>, visited: BooleanArray) {
    val stack = arrayListOf<Int>()
    stack.add(start)

    while(stack.isNotEmpty()) {
        val index = stack.removeAt(stack.lastIndex)

        if(!visited[index]) {
            visited[index] = true
            print("$index ")

            for (i in graph[index].size - 1 downTo 1) {
                if (graph[index][i] == 1) {
                    stack.add(i)
                }
            }
        }
    }
}

private fun bfs(start: Int,   graph: Array<IntArray>, visited: BooleanArray) {
    val queue = ArrayDeque<Int>()
    queue.addLast(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val index = queue.removeFirst()
        print("$index ")

        for (i in 1..<graph.size) {
            if (graph[index][i] == 1 && !visited[i]) {
                queue.addLast(i)
                visited[i] = true
            }
        }
    }
}
