import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = System.out.bufferedWriter()

    val n = bufferedReader.readLine().toInt()

    val numberList = bufferedReader.readLine().split(" ").map { it.toInt() }.sorted()

    var accTime = 0
    var totalTime = 0

    for (time in numberList) {
        accTime += time
        totalTime += accTime
    }

    bufferedWriter.write(totalTime.toString())

    bufferedReader.close()
    bufferedWriter.close()
}
