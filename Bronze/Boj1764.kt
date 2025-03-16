import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) =  bufferedReader.readLine().split(" ").map { it.toInt() }

    val neverHeard : MutableSet<String> = mutableSetOf()
    val result : MutableList<String> = mutableListOf()

    repeat(n) {
        neverHeard.add(bufferedReader.readLine())
    }

    repeat(m) {
        val neverSeenName : String = bufferedReader.readLine()

        if (neverHeard.contains(neverSeenName)) {
            result.add(neverSeenName)
        }
    }

   val sortedList = result.sorted()

    bufferedWriter.write("${sortedList.size}\n")
    sortedList.forEach { name ->
        bufferedWriter.write("$name\n")
    }

    bufferedWriter.flush()

    bufferedReader.close()
    bufferedWriter.close()
}
