import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val t : Int = bufferedReader.readLine().toInt()

    val result = StringBuilder()

    repeat(t) {
        val k : Int = bufferedReader.readLine().toInt()
        val n  : Int = bufferedReader.readLine().toInt()

        val array = Array(k + 1) { IntArray(n + 1) }

        for(i in 0 .. n) {
            array[0][i] = i
        }

        for(i in 1 .. k) {
            for(j in 1 .. n) {
                array[i][j] = array[i][j - 1] + array[i - 1][j]
            }
        }

        result.append("${array[k][n]}\n")
    }

    bufferedWriter.write(result.toString())

    bufferedReader.close()
    bufferedWriter.close()
}
